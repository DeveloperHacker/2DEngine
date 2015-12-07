package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;

import java.awt.*;

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
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
        Vector prev = figure.pos().add(parentPos);
        Vector current;
        graphics.setColor(outline);
        for (Vector vec : figure.vectors()) {
            current = prev.add(vec);
            graphics.drawLine((int) (prev.x), (int) (prev.y), (int) (current.x), (int) (current.y));
            prev = current;
        }
    }
}
