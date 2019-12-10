package com.kodilla.tictactoe;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Field extends ImageView {

    private static boolean turnX = true;

    public Field(Image image) {
        super(image);
        this.setOnMouseClicked(event -> mouseClicked());
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
        }


    }
}

