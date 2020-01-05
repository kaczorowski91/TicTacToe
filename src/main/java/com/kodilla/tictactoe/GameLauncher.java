package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
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
    private final Label level = new Label("Level: Normal");
    private final Button reset = new Button("Score Reset");
    private final Button easyLevel = new Button("Easy Level");
    private final Button normalLevel = new Button("Normal Level");
    private boolean playEasyLevel=false;

    public GameLauncher() {
        this.fieldStorage = new FieldStorage(this);
        this.lineStorage = new LineStorage(fieldStorage);
        this.endScene = new EndScene(fieldStorage);
        this.ai = new Ai(fieldStorage);
    }

    public void aiMove() {
        if(!playEasyLevel)
            ai.move();
        if(playEasyLevel)
            ai.easyMove();
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

    public void sceneClean(){
        fieldStorage.getFieldList()
                .forEach(field -> field.setImage(Images.EMPTY));
        fieldStorage.getWinfield().setImage(Images.EMPTY);
        circleScoreValue = 0;
        crossScoreValue = 0;
        circleScore.setText("" + circleScoreValue);
        crossScore.setText("" + crossScoreValue);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

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

        reset.setFont(new Font(30));
        reset.setTranslateX(60);

        easyLevel.setFont(new Font(30));
        easyLevel.setTranslateY(-70);

        normalLevel.setFont(new Font(30));

        level.setFont(new Font(30));
        level.setTranslateY(70);

        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(0, 0, 0, 20));
        grid.setHgap(20);
        grid.setVgap(20);

        Scene scene = new Scene(grid, 1000, 800);

        primaryStage.setScene(scene);
        primaryStage.setTitle("TicTacToeNEW");
        primaryStage.show();

        reset.setOnAction(event -> {
            circleScoreValue = 0;
            crossScoreValue = 0;
            circleScore.setText("" + circleScoreValue);
            crossScore.setText("" + crossScoreValue);

        });

        easyLevel.setOnAction(event -> {
            playEasyLevel=true;
            this.sceneClean();
            level.setText("Easy level");
        });

        normalLevel.setOnAction(event -> {
            playEasyLevel=false;
            this.sceneClean();
            level.setText("Normal level");

        });

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
        grid.add(reset, 4, 2);
        grid.add(easyLevel,4,0);
        grid.add(normalLevel,4,0);
        grid.add(level, 4 , 0);
    }

    public static void main(String[] args) {
        launch(args);
    }

}