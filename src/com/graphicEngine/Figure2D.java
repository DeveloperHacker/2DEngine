package com.graphicEngine;

import com.abstractEngine.math.*;
import com.abstractEngine.math.Point;

import java.awt.*;
import java.util.List;

public class Figure2D implements View {

    public final Figure figure;
    private Color outline;

    public Figure2D(Figure figure, Color outline) {
        this.figure = new Figure(figure);
        this.outline = outline;
    }

    public Color outline() {
        return outline;
    }

    public void set(Color outline) {
        this.outline = outline;
    }

    @Override
    public void show(Graphics graphics, Point posScreen, int height, int width) {
        Point prev = figure.pos().add(posScreen);
        Point current;
        graphics.setColor(outline);
        for (Vector vec : figure.vectors()) {
            current = prev.add(vec);
            graphics.drawLine((int) (prev.x), (int) (prev.y), (int) (current.x), (int) (current.y));
            prev = current;
        }
    }
}
