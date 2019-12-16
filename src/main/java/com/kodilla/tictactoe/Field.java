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
            if (gameLauncher.winGame) {
                gameLauncher.setEndScene();
            }
            gameLauncher.drawCheck();
            if (gameLauncher.drawGame) {
               gameLauncher.setEndScene();
            }

        }

    }

}



