package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends ImageView {

    private static boolean turnX = true;
    private final GameLauncher gameLauncher;

    public Field(Image image, GameLauncher gameLauncher) {
        super(image);
        this.setOnMouseClicked(event -> mouseClicked());
        this.gameLauncher = gameLauncher;
    }

    public static boolean isTurnX() {
        return turnX;
    }

    private void mouseClicked() {

        if (getImage() == Images.EMPTY) {
            if (turnX) {
                this.setImage(Images.CROSS);
                turnX = false;
            } else {
                this.setImage(Images.CIRCLE);
                turnX = true;
            }
            gameLauncher.winCheck();
            gameLauncher.turnCheck();
        }
    }
}



