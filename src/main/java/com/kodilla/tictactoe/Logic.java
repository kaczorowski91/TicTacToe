package com.kodilla.tictactoe;

public class Logic {

    FieldStorage fieldStorage = new FieldStorage();
    LineStorage lineStorage = new LineStorage(fieldStorage);


    public boolean win() {

        for (int i = 0; i < lineStorage.getWinLines().size(); i++) {

            if (lineStorage.getWinLines().contains(Images.CIRCLE)) {
                return true;
            } else if (lineStorage.getWinLines().contains(Images.CROSS))
            {
                return true;
            }
        }
        return false;

    }
}