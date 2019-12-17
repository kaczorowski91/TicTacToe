package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class GameLauncher extends Application {

    private final FieldStorage fieldStorage;
    private final LineStorage lineStorage;
    private final EndScene endScene;

    Stage window;


    public void winCheck() {

        for (Line line : lineStorage.getWinLines()) {

            boolean isWin = line.getFields().stream()
                    .allMatch(field -> field.getImage() != Images.EMPTY && field.getImage().equals(line.getFields().get(0).getImage()));
            if (isWin) {
                fieldStorage.getWinfield().setImage(line.getFields().get(0).getImage());
                endScene.display();
            }
            boolean drawGame = fieldStorage.getFieldList().stream()
                    .noneMatch(field -> field.getImage().equals(Images.EMPTY));
            if (drawGame) {
                fieldStorage.getWinfield().setImage(Images.DRAW);
                endScene.display();

            }
        }


    }

    public GameLauncher() {

        this.fieldStorage = new FieldStorage(this);
        this.lineStorage = new LineStorage(fieldStorage);
        this.endScene = new EndScene(fieldStorage);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;

        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 20));
        grid.setHgap(20);
        grid.setVgap(20);

        Scene scene = new Scene(grid, 1000, 800, Color.YELLOW);


        window.setScene(scene);
        window.setTitle("TicTacToeNEW");
        window.show();


        grid.add(fieldStorage.getField(0, 0), 0, 0);
        grid.add(fieldStorage.getField(1, 0), 1, 0);
        grid.add(fieldStorage.getField(2, 0), 2, 0);
        grid.add(fieldStorage.getField(0, 1), 0, 1);
        grid.add(fieldStorage.getField(1, 1), 1, 1);
        grid.add(fieldStorage.getField(1, 2), 1, 2);
        grid.add(fieldStorage.getField(0, 2), 0, 2);
        grid.add(fieldStorage.getField(2, 1), 2, 1);
        grid.add(fieldStorage.getField(2, 2), 2, 2);
        grid.add(fieldStorage.getWinfield(), 4, 1);


    }

    public static void main(String[] args) {
        launch(args);
    }

}