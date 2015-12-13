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
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
//        ArrayList<Vector> vectors = new ArrayList<>(2);
//        Vector P_1 = screen.pos().add(new Vector(0, screen.height()));
//        Vector P_2 = screen.pos().add(new Vector(screen.width(), screen.height()));
//        Vector P_3 = screen.pos().add(new Vector(screen.width(), 0));
//        Section S_1 = new Section(screen.pos(), P_1);
//        Section S_2 = new Section(P_1, P_2);
//        Section S_3 = new Section(P_2, P_3);
//        Section S_4 = new Section(P_3, screen.pos());
        Line line = this.line.moveTo(parentPos.add(new Vector(0, this.line.y(0))));
//        if (Line.intersection(line, S_1)) {
//            vectors.add(new Vector(screen.pos().x, line.y(screen.pos().x)));
//        }
//        if (Line.intersection(line, S_2)) {
//            vectors.add(new Vector(line.x(screen.pos().y + screen.height()), screen.pos().y + screen.height()));
//        }
//        if (Line.intersection(line, S_3)) {
//            vectors.add(new Vector(screen.pos().x + screen.width(), line.y(screen.pos().x + screen.width())));
//        }
//        if (Line.intersection(line, S_4)) {
//            vectors.add(new Vector(line.x(screen.pos().y), screen.pos().y));
//        }
//        if (vectors.size() >= 2)
//            new Section2D(vectors.get(0), vectors.get(1), outlineColor).show(graphics, screen, new Vector());
        Vector P1 = new Vector(0, line.y(0));
        Vector P2 = new Vector(screen.width(), line.y(screen.width()));
        new Section2D(P1, P2, outlineColor).show(graphics, screen, new Vector());
    }
}
