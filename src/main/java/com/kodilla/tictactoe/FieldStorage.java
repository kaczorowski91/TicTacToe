package com.kodilla.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class FieldStorage {

    private final Field[][] fields = new Field[3][3];
    private final List<Field> fieldList = new ArrayList<>();

    public FieldStorage(GameLauncher gameLauncher) {


        for (int x = 0; x < fields.length; x++) {
            for (int y = 0; y < fields[x].length; y++) {
                fields[x][y] = new Field(Images.EMPTY, gameLauncher);
                fieldList.add(fields[x][y]);
            }
        }

    }

    public Field getField(int x, int y) {
        return fields[x][y];
    }

    public List<Field> getFieldList() {
        return fieldList;
    }

    public WinField winfield = new WinField(Images.EMPTY);

    public WinField getWinfield() {
        return winfield;
    }


}