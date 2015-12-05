package com.graphicEngine;

import com.abstractEngine.math.Line;
import com.abstractEngine.math.Section;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;

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
    public void show(Graphics graphics, Vector posScreen, int height, int width) {
        ArrayList<Vector> Vectors = new ArrayList<>(2);
        Vector P_1 = posScreen.add(new Vector(0, height));
        Vector P_2 = posScreen.add(new Vector(width, height));
        Vector P_3 = posScreen.add(new Vector(width, 0));
        Section S_1 = new Section(posScreen, P_1);
        Section S_2 = new Section(P_1, P_2);
        Section S_3 = new Section(P_2, P_3);
        Section S_4 = new Section(P_3, posScreen);
        if (Line.intersection(line, S_1)) Vectors.add(new Vector(posScreen.x, line.y(posScreen.x)));
        if (Line.intersection(line, S_2)) Vectors.add(new Vector(line.x(posScreen.y + height), posScreen.y + height));
        if (Line.intersection(line, S_3)) Vectors.add(new Vector(posScreen.x + width, line.y(posScreen.x + width)));
        if (Line.intersection(line, S_4)) Vectors.add(new Vector(line.x(posScreen.y), posScreen.y));
        if (Vectors.size() == 2)
            new Section2D(Vectors.get(0), Vectors.get(1), outlineColor).show(graphics, posScreen, height, width);
        if (Vectors.size() > 2)
            new Section2D(Vectors.get(0), Vectors.get(2), outlineColor).show(graphics, posScreen, height, width);
    }
}
