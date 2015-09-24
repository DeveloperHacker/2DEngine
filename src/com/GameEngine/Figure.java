package com.GameEngine;
import java.util.ArrayList;

public class Figure {
    public final Point pos;
    public final ArrayList<Vector> vectors;
    public Figure(Point pos, ArrayList<Vector> vec) {
        this.pos = pos;
        vectors = vec;
    }
    
}
