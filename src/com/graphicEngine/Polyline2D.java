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
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
        Vector prev;
        Vector current = parentPos.add(polyline.pos());
        graphics.setColor(outlineColor);
        for (Vector vector : polyline.vectors()) {
            prev = current;
            current = current.add(vector);
            graphics.drawLine((int)(prev.x), (int)(prev.y), (int)(current.x), (int)(current.y));
        }
    }
}
