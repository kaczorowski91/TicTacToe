package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class GameLauncher extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 20));

        grid.setHgap(20);
        grid.setVgap(20);
        Scene scene = new Scene(grid, 1000, 800, Color.BLACK);


        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToeNEW");

        primaryStage.show();


        grid.add(FieldStore.field00, 0, 0);
        grid.add(FieldStore.field10, 1, 0);
        grid.add(FieldStore.field20, 2, 0);
        grid.add(FieldStore.field01, 0, 1);
        grid.add(FieldStore.field11, 1, 1);
        grid.add(FieldStore.field12, 1, 2);
        grid.add(FieldStore.field02, 0, 2);
        grid.add(FieldStore.field21, 2, 1);
        grid.add(FieldStore.field22, 2, 2);


        Set<Line> winLines = new HashSet<>();  //dlaczego nie mogę dodać hash setu w klasie logic (nie działa add)
        winLines.add(LineStore.line1);
        winLines.add(LineStore.line2);
        winLines.add(LineStore.line3);
        winLines.add(LineStore.line4);
        winLines.add(LineStore.line5);
        winLines.add(LineStore.line6);
        winLines.add(LineStore.line7);
        winLines.add(LineStore.line8);





    }


    public static void main(String[] args) {
        launch(args);
    }
}