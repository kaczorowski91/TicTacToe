package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends ImageView {

    private final GameLauncher gameLauncher;

    public Field(Image image, GameLauncher gameLauncher) {
        super(image);
        this.setOnMouseClicked(event -> mouseClicked());
        this.gameLauncher = gameLauncher;
    }

    private void mouseClicked() {

        if (getImage() == Images.EMPTY) {
            this.setImage(Images.CROSS);

            gameLauncher.winCheck();
            gameLauncher.aiMove();
            gameLauncher.winCheck();
        }
    }
}



