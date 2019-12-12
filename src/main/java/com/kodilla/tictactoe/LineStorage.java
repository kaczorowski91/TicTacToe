package com.kodilla.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class LineStorage {

    private final Set<Line> winLines = new HashSet<>();

    public LineStorage(FieldStorage fieldStorage) {
        winLines.add(new Line(fieldStorage.getField(0, 0), fieldStorage.getField(1, 0), fieldStorage.getField(2, 0)));
        winLines.add(new Line(fieldStorage.getField(0, 1), fieldStorage.getField(1, 1), fieldStorage.getField(2, 1)));
        winLines.add(new Line(fieldStorage.getField(0, 2), fieldStorage.getField(1, 2), fieldStorage.getField(2, 2)));
        winLines.add(new Line(fieldStorage.getField(0, 0), fieldStorage.getField(0, 1), fieldStorage.getField(0, 2)));
        winLines.add(new Line(fieldStorage.getField(1, 0), fieldStorage.getField(1, 1), fieldStorage.getField(1, 2)));
        winLines.add(new Line(fieldStorage.getField(2, 2), fieldStorage.getField(2, 1), fieldStorage.getField(2, 2)));
        winLines.add(new Line(fieldStorage.getField(0, 0), fieldStorage.getField(1, 1), fieldStorage.getField(2, 2)));
        winLines.add(new Line(fieldStorage.getField(0, 2), fieldStorage.getField(1, 1), fieldStorage.getField(2, 0)));

    }

    public Set<Line> getWinLines() {
        return winLines;
    }


}