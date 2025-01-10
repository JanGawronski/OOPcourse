package agh.ics.oop.presenter;

import java.io.IOException;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.Boundary;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.OptionsParser;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;
    @FXML
    private GridPane mapGrid;
    @FXML
    private TextField moveListTextField;
    @FXML
    private Label moveDescriptionLabel;

    private final int CELL_WIDTH = 50;
    private final int CELL_HEIGHT = 50;

    private void drawMap(WorldMap map) {
        clearGrid();

        Boundary bounds = map.getCurrentBounds();

        int width = bounds.upperRight().getX() - bounds.lowerLeft().getX() + 1;
        int height = bounds.upperRight().getY() - bounds.lowerLeft().getY() + 1;

        for (int i = 0; i < width; i++) {
            mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_WIDTH));
            Label label = new Label(Integer.toString(i + bounds.lowerLeft().getX()));
            mapGrid.add(label, i + 1, 0);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < height; i++) {
            mapGrid.getRowConstraints().add(new RowConstraints(CELL_HEIGHT));
            Label label = new Label(Integer.toString(bounds.upperRight().getY() - i));
            mapGrid.add(label, 0, i + 1);
            GridPane.setHalignment(label, HPos.CENTER);
        }

        for (int i = 0; i < width; i++) {
            for (int j = height - 1; j >= 0; j--) {
                Vector2d position = new Vector2d(i + bounds.lowerLeft().getX(), bounds.upperRight().getY() - j);
                if (map.isOccupied(position)) {
                    Label label = new Label(map.objectAt(position).map(Object::toString).orElse(""));
                    mapGrid.add(label, i + 1, j + 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                }
            }
        }

        mapGrid.getColumnConstraints().add(new ColumnConstraints(CELL_HEIGHT));
        mapGrid.getRowConstraints().add(new RowConstraints(CELL_WIDTH));
        Label label = new Label("y\\x");
        mapGrid.add(label, 0, 0);
        GridPane.setHalignment(label, HPos.CENTER);
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0));
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void setMap(WorldMap map) {
        this.map = map;
    }

    @Override
    public void mapChanged(WorldMap map, String message) {
        Platform.runLater(() -> {
            moveDescriptionLabel.setText(message);
            drawMap(map);
        });
    }

    @FXML
    public void onSimulationStartClicked() {
        String moveList = moveListTextField.getText();
        List<MoveDirection> directions = OptionsParser.parse(moveList.split("\\s+"));
        List<Vector2d> positions = List.of(new Vector2d(2, 2), new Vector2d(3, 4));
        AbstractWorldMap map = new GrassField(10);
        try {
            SimulationApp simulationApp = new SimulationApp();
            simulationApp.launchSimulationWindow(map);
            Simulation simulation = new Simulation(positions, directions, map);
            Thread thread = new Thread(simulation);
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}