package com.kodilla.tictactoe;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Game extends Application {

    private boolean turnX = true;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();

    }


    private class Tile extends StackPane {

        private Text text = new Text();

        public Tile() {
            Rectangle border = new Rectangle(200, 200);
            border.setFill(Color.GOLD); //set color in rectangle
            border.setStroke(Color.BLUEVIOLET); //set color between rectangle
            setAlignment(Pos.CENTER);
            text.setFont(Font.font(100));
            getChildren().addAll(border, text);

            setOnMouseClicked(event -> {

                if (event.getButton() == MouseButton.PRIMARY) {
                    if (!turnX)
                        return;
                    drawX();
                    turnX = false;
                }

                if (event.getButton() == MouseButton.SECONDARY) {
                    if (turnX)
                        return;
                    drawO();
                    turnX = true;
                }
            });

        }

        private void drawX() {
            text.setText("X");
        }

        private void drawO() {
            text.setText("O");
        }
    }

    public Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(600, 600);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                root.getChildren().add(tile);
            }
        }
        return root;
    }


}
