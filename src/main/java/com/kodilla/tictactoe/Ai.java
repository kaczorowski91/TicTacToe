package com.kodilla.tictactoe;

public class Ai {

    private final FieldStorage fieldStorage;


    public Ai(FieldStorage fieldStorage) {
        this.fieldStorage = fieldStorage;
    }

    public void move() {

        boolean aIPlayed = false;

        if (fieldStorage.getField(1, 1).getImage().equals(Images.EMPTY)) { //first round check centre, centre available
            fieldStorage.getField(1, 1).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(1, 1).getImage().equals(Images.CROSS) &&  // first round check centre, centre unavailable
                fieldStorage.getField(1, 0).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(1, 0).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(0, 0).getImage().equals(Images.CROSS) &&  //second round first cross, centre unavailable
                fieldStorage.getField(2, 2).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(2, 2).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(2, 0).getImage().equals(Images.CROSS) && //second round first cross, centre unavailable
                fieldStorage.getField(0, 2).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(0, 2).setImage(Images.CIRCLE);
            aIPlayed = true;
        }
        if (!aIPlayed && fieldStorage.getField(0, 2).getImage().equals(Images.CROSS) && //second round first cross, centre unavailable
                fieldStorage.getField(2, 0).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(2, 0).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(2, 2).getImage().equals(Images.CROSS) && //second round first cross, centre unavailable
                fieldStorage.getField(0, 0).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(0, 0).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(0, 2).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(0, 2).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed && fieldStorage.getField(2, 0).getImage().equals(Images.EMPTY)) {
            fieldStorage.getField(2, 0).setImage(Images.CIRCLE);
            aIPlayed = true;
        }

        if (!aIPlayed) {
            easyMove();
        }
    }


    public void easyMove() {

        for (Field field : fieldStorage.getFieldList()) {
            if (field.getImage().equals(Images.EMPTY)) {
                field.setImage(Images.CIRCLE);
                break;
            }
        }
    }
}

