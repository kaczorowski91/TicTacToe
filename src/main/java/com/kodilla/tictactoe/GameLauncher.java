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
    public static GameLauncher gameLauncher;


    public GameLauncher() {

        this.fieldStorage = new FieldStorage();
        this.lineStorage = new LineStorage(fieldStorage);

    }


    public boolean win() {
        for (int i = 0; i < lineStorage.getWinLines().size(); i++) {
            for (Line line : lineStorage.getWinLines()) {
                Field field1 = line.getFields().get(0);
                Field field2 = line.getFields().get(1);
                Field field3 = line.getFields().get(2);

                if (field1.getImage() != Images.EMPTY && field1.getImage().equals(field2.getImage()) &&
                        field2.getImage().equals(field3.getImage())) {
                    return true;
                }
            }
        }
        return true;
    }

    public void setWin() {
        fieldStorage.getWinfield().setWin();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 20));

        grid.setHgap(20);
        grid.setVgap(20);
        Scene scene = new Scene(grid, 1000, 800, Color.YELLOW);


        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToeNEW");

        primaryStage.show();


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