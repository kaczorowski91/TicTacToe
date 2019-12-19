package com.kodilla.tictactoe;

public class Ai {

    private final FieldStorage fieldStorage;


    public Ai(FieldStorage fieldStorage) {
        this.fieldStorage = fieldStorage;
    }

    public void move() {

        boolean aIPlayed=false;

        if (!aIPlayed && fieldStorage.getField(1, 1).getImage().equals(Images.CROSS)) {


            Field fieldToSet = fieldStorage.getField(0, 0);
            if (fieldToSet.getImage().equals(Images.EMPTY)) {
                fieldToSet.setImage(Images.CIRCLE);
                aIPlayed=true;
            }
        }



        if(!aIPlayed) {
            for (Field field : fieldStorage.getFieldList()) {
                if (field.getImage().equals(Images.EMPTY)) {
                    field.setImage(Images.CIRCLE);
                    break;
                }
            }
        }
    }

}
