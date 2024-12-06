package agh.ics.oop.presenter;

import java.io.IOException;
import java.util.List;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationApp;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.AbstractWorldMap;
import agh.ics.oop.model.GrassField;
import agh.ics.oop.model.MapChangeListener;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.OptionsParser;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap map;
    @FXML
    private Label mapGrid;
    @FXML
    private TextField moveListTextField;
    @FXML
    private Label moveDescriptionLabel;

    public void drawMap(WorldMap map) {
        mapGrid.setText(map.toString());
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
        List<MoveDirection> directions = OptionsParser.parse(moveList.split(" "));
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        AbstractWorldMap map = new GrassField(10);
        setMap(map);
        map.addObserver(this);
        Simulation simulation = new Simulation(positions, directions, map);
        SimulationEngine engine = new SimulationEngine(List.of(simulation));
        moveDescriptionLabel.setText("Simulation started with moves: " + moveList);
        new Thread(() -> {
            engine.runSync();
        }).start();
    }

    @FXML
    private void onNewSimulationClicked(){
        SimulationApp simulationApp = new SimulationApp();
        try {
            simulationApp.start(new Stage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
