package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Figure {
    private static List<Vector> initVectors(double width, double height) {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(width, 0));
        vectors.add(new Vector(0, height));
        vectors.add(new Vector(-width, 0));
        vectors.add(new Vector(0, -height));
        return vectors;
    }

    public Rectangle(Vector pos, double width, double height) {
        super(pos, initVectors(width, height));
    }
}
