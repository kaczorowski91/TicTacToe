package com.kodilla.tictactoe;

public class FieldStorage {

    private final Field [][] fields = new Field[3][3];

    public FieldStorage() {

        for(int x=0; x<fields.length; x++){
            for(int y=0; y<fields[x].length;y++){
                fields [x][y] = new Field(Images.EMPTY);
            }
        }
    }

    public Field getField (int x, int y){
        return fields[x][y];
    }



}