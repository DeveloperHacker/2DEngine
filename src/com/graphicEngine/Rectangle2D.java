package com.graphicEngine;

import com.abstractEngine.math.Vector;
import com.abstractEngine.math.Point;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Rectangle2D extends Figure2D {

    private static List<Vector> initVectors(double height, double width) {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(width, 0));
        vectors.add(new Vector(0, height));
        vectors.add(new Vector(-width, 0));
        vectors.add(new Vector(0, -height));
        return vectors;
    }

    public Rectangle2D(Point pos, double height, double width, Color outline) {
        super(pos, initVectors(height, width), outline);
    }
}
