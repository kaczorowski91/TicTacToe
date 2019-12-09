package com.kodilla.tictactoe;


public class Line {

    Field field0, field1, field2;
    // czy da się zrobić konstruktor z różna ilością pól i jak? varargs

    public Line(Field field0, Field field1, Field field2) {
        this.field0 = field0;
        this.field1 = field1;
        this.field2 = field2;

    }

}