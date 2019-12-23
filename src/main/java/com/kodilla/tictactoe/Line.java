package com.kodilla.tictactoe;


import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.List;

public class Line {

    List<Field> fields;

    public Line(Field... fields) {
        this.fields = new ArrayList<>(Arrays.asList(fields));
    }

    public List<Field> getFields() {
        return fields;
    }
}