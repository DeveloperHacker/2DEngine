package com.GameEngine;
import java.util.ArrayList;

public class Figure {
    public final Point pos;
    public final ArrayList<Vector> vectors;
    public Figure(Point pos, ArrayList<Vector> vec) {
        this.pos = pos;
        vectors = vec;
    }
    static boolean intersection(Figure _1, Figure _2){
        return false;
    }
    @Override
    public String toString() {
        return "Figure: [" +
                "'Position = " + pos.toString() +
                "', 'Vectors = " + vectors.toString() +
                "']";
    }
}
