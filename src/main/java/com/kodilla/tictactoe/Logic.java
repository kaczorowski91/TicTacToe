package com.kodilla.tictactoe;

import java.util.Iterator;

public class Logic {

    FieldStorage fieldStorage = new FieldStorage();
    LineStorage lineStorage = new LineStorage(fieldStorage);


    public boolean win() {

        for (int i = 0; i < lineStorage.getWinLines().size(); i++) {

            Iterator<Line> iterator = lineStorage.getWinLines().iterator();
            Line line;
            while (iterator.hasNext()) {
                line = iterator.next();

                if (line.getFields().contains(Images.EMPTY)) {
                    return false;
                }
                 if (line.fields.contains(Images.CIRCLE)) {
                    return true;
                }
                if (line.fields.contains(Images.CROSS)) {
                    return true;
                }
            }
        }
        return false;
    }
}
