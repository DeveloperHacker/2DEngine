package com.graphicEngine;

import com.abstractEngine.math.Vector;

public class Screen {
    private Vector pos;
    final Vector diagonal;

    public Screen(Vector pos, double width, double height) {
        this.pos = pos;
        this.diagonal = new Vector(width, height);
    }

    public Vector pos() {
        return pos;
    }

    public void moveTo(Vector pos) {
        this.pos = pos;
    }

    public double width() {
        return diagonal.x;
    }

    public double height() {
        return diagonal.y;
    }
}