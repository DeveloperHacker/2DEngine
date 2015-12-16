package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Figure2D implements View {

    public final Figure figure;
    private Color outlineColor;
    private Color fillColor;

    public Figure2D(Figure figure, Color outlineColor, Color fillColor) {
        this.figure = new Figure(figure);
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    public Figure2D(Figure figure, Color outlineColor) {
        this(figure, outlineColor, null);
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public void setOutlineColor(Color outline) {
        this.outlineColor = outline;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        Vector prev = figure.pos().add(parentPos);
        Vector current;
        List<Vector> points = new ArrayList<>();
        for (Vector vec : figure.vectors()) {
            points.add(prev);
            current = prev.add(vec);
            prev = current;
        }
        int[] xs = new int[points.size()];
        int[] ys = new int[points.size()];
        Vector point;
        for (int i = 0; i < points.size(); i++) {
            point = points.get(i);
            xs[i] = ((int) (point.x));
            ys[i] = ((int) (point.y));
        }
        if (fillColor != null) {
            graphics.setColor(fillColor);
            graphics.fillPolygon(xs, ys, points.size());
        }
        graphics.setColor(outlineColor);
        graphics.drawPolygon(xs, ys, points.size());
    }
}
