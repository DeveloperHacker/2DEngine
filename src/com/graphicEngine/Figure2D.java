package com.graphicEngine;

import com.abstractEngine.math.*;
import com.abstractEngine.math.Point;

import java.awt.*;
import java.util.List;

public class Figure2D implements GraphicsModel {

    public final Figure figure;
    private Color outlineColor;

    public Figure2D(Figure figure, Color outline) {
        this.figure = new Figure(figure);
        outlineColor = outline;
    }

    public Figure2D(com.abstractEngine.math.Point pos, List<Vector> vec, Color outline)
            throws IllegalArgumentException {
        figure = new Figure(pos, vec);
        outlineColor = outline;
    }

    @Override
    public void show(Graphics graphics, Point posScreen, int height, int width) {
        Point prev = Point.rem(figure.pos(), posScreen);
        Point current;
        graphics.setColor(outlineColor);
        for (Vector vec : figure.vectors()) {
            current = Point.add(prev, vec.pos);
            graphics.drawLine((int) (prev.x), (int) (prev.y), (int) (current.x), (int) (current.y));
            prev = current;
        }
    }
}
