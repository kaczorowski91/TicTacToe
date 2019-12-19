package com.kodilla.tictactoe;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EndScene {

    private final FieldStorage fieldStorage;

    public EndScene(FieldStorage fieldStorage) {
        this.fieldStorage = fieldStorage;
    }

    public void display() {
        Stage endScene = new Stage();
        Label label = new Label();
        Button closeButton = new Button("New Game");

        endScene.initModality(Modality.APPLICATION_MODAL); //Block events to other windows
        endScene.setTitle("End Game");
        endScene.setMinWidth(500);
        endScene.setMinHeight(400);

        if (fieldStorage.getWinfield().getImage().equals(Images.DRAW)) {
            label.setText(" DRAW ");
        }

        if (fieldStorage.getWinfield().getImage().equals(Images.CROSS)) {
            label.setText(" CROSS WIN");
        }

        if (fieldStorage.getWinfield().getImage().equals(Images.CIRCLE)) {
            label.setText(" CIRCLE WIN ");
        }

        closeButton.setOnAction(e -> {
            endScene.close();
            fieldStorage.getFieldList().stream()
                    .forEach(field -> field.setImage(Images.EMPTY));
            fieldStorage.getWinfield().setImage(Images.EMPTY);

        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);   //Display window and wait for it to be closed before returning
        endScene.setScene(scene);       //Display window and wait for it to be closed before returning
        endScene.showAndWait();       //Display window and wait for it to be closed before returning
    }

}