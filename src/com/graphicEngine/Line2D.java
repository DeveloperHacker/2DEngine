package com.graphicEngine;

import com.abstractEngine.math.Line;
import com.abstractEngine.math.Section;
import com.abstractEngine.math.Vector;

import java.awt.*;

public class Line2D implements View {
    public final Line line;
    private Color outlineColor;

    public Line2D(Line line, Color outlineColor) {
        this.line = new Line(line);
        this.outlineColor = outlineColor;
    }

    public Line2D(double A, double B, double C, Color outlineColor) throws IllegalArgumentException {
        line = new Line(A, B, C);
        this.outlineColor = outlineColor;
    }

    public Line2D(Section section, Color outlineColor) {
        line = new Line(section);
        this.outlineColor = outlineColor;
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        Line line = this.line.moveTo(parentPos.add(new Vector(0, this.line.y(0))));
        Vector P1 = new Vector(0, line.y(0));
        Vector P2 = new Vector(screen.width(), line.y(screen.width()));
        new Section2D(P1, P2, outlineColor).drawOutline(graphics, screen, new Vector());
    }
}
