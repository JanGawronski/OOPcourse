package agh.ics.oop.presenter;

import java.util.HashMap;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import agh.ics.oop.model.WorldElement;
import agh.ics.oop.model.Grass;
import agh.ics.oop.model.Animal;

public class WorldElementBox extends VBox {
    private static final HashMap<String, Image> images = new HashMap<>();

    public WorldElementBox(WorldElement element){
        String imageName = element.getImageFileName();
        if (!images.containsKey(imageName)) {
            images.put(imageName, new Image(getClass().getResource("/" + imageName).toExternalForm()));
        }
        ImageView imageView = new ImageView(images.get(imageName));
        imageView.setFitWidth(20);
        imageView.setFitHeight(20);

        Label label;
        if (element.getClass().equals(Grass.class)) {
            label = new Label("Grass");
        } else if (element.getClass().equals(Animal.class)) {
            label = new Label(element.getPosition().toString());
        } else {
            throw new IllegalArgumentException("Unsupported element type");
        }

        this.getChildren().addAll(imageView, label);
        this.alignmentProperty().set(javafx.geometry.Pos.CENTER);
    }
}