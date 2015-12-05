package com.graphicEngine;

import com.abstractEngine.math.Polyline;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.List;

public class Polyline2D implements View {
    public final Polyline polyline;
    private Color outlineColor;

    public Polyline2D(Polyline polyline, Color outlineColor) {
        this.polyline = new Polyline(polyline);
        this.outlineColor = outlineColor;
    }

    public Polyline2D(Vector pos, List<Vector> vectors, Color outlineColor) {
        this.polyline = new Polyline(pos, vectors);
        this.outlineColor = outlineColor;
    }

    @Override
    public void show(Graphics graphics, Vector posScreen, int height, int width) {
        Vector prev = polyline.pos();
        for (Vector vector : polyline.vectors()) {
            new Section2D(prev, vector, outlineColor).show(graphics, posScreen, height, width);
            prev = vector;
        }
    }
}
