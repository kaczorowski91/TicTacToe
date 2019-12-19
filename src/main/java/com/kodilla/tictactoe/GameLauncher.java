package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GameLauncher extends Application {

    private final FieldStorage fieldStorage;
    private final LineStorage lineStorage;
    private final EndScene endScene;
    private final Ai ai;

    private int circleScoreValue = 0;
    private int crossScoreValue = 0;
    private final Label crossScore = new Label("" + crossScoreValue);
    private final Label circleScore = new Label("" + circleScoreValue);

    private Stage window;

    public GameLauncher() {
        this.fieldStorage = new FieldStorage(this);
        this.lineStorage = new LineStorage(fieldStorage);
        this.endScene = new EndScene(fieldStorage);
        this.ai = new Ai(fieldStorage);
    }

    public void aiMove() {

        ai.move();
    }

    public void winCheck() {

        for (Line line : lineStorage.getWinLines()) {

            boolean isWin = line.getFields().stream()
                    .allMatch(field -> field.getImage() != Images.EMPTY && field.getImage().equals(line.getFields().get(0).getImage()));
            if (isWin) {
                fieldStorage.getWinfield().setImage(line.getFields().get(0).getImage());

                if (fieldStorage.getWinfield().getImage().equals(Images.CIRCLE)) {
                    circleScoreValue++;
                    circleScore.setText("" + circleScoreValue);
                }
                if (fieldStorage.getWinfield().getImage().equals((Images.CROSS))) {
                    crossScoreValue++;
                    crossScore.setText("" + crossScoreValue);
                }
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

    @Override
    public void start(Stage primaryStage) throws Exception {

        window = primaryStage;
        GridPane grid = new GridPane();


        Label gameResult = new Label("Game Result:");
        gameResult.setFont(new Font(40));
        gameResult.setTranslateY(-50);

        Label circle = new Label("Circle:");
        circle.setFont(new Font(30));


        circleScore.setFont(new Font(30));
        circleScore.setTranslateX(85);

        Label cross = new Label("Cross:");
        cross.setFont(new Font(30));
        cross.setTranslateY(50);


        crossScore.setFont(new Font(30));
        crossScore.setTranslateX(85);
        crossScore.setTranslateY(50);

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

        grid.add(gameResult, 4, 1);
        grid.add(circle, 4, 1);
        grid.add(cross, 4, 1);
        grid.add(circleScore, 4, 1);
        grid.add(crossScore, 4, 1);
    }

    public static void main(String[] args) {
        launch(args);
    }

}