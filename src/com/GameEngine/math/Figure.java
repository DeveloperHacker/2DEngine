package com.gameEngine.math;

import java.util.ArrayList;

public class Figure {
    public final Point pos;
    public final ArrayList<Vector> vectors;
    public Figure(Figure figure) {
        pos = figure.pos;
        vectors = figure.vectors;
    }
    public Figure(Point pos, ArrayList<Vector> vec) {
        this.pos = pos;
        vectors = vec;
    }
    static boolean intersection(Figure _1, Figure _2){
        return false;
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        return ((Figure)obj).pos.equals(pos) && ((Figure)obj).vectors.equals(vectors);
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        final int c = 11;
        return a + b * pos.hashCode() + c * vectors.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new Figure(this);
    }
    @Override
    public String toString() {
        return "[" + "'Position = " + pos + "', 'Vectors = " + vectors + "']";
    }
}
