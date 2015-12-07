package com.graphicEngine;

import com.abstractEngine.math.Section;
import com.abstractEngine.math.Vector;

import java.awt.*;

public class Section2D implements View {
    public final Section section;
    private Color outlineColor;

    public Section2D(double x_1, double y_1, double x_2, double y_2, Color outlineColor) throws IllegalArgumentException {
        section = new Section(x_1, y_1, x_2, y_2);
        this.outlineColor = outlineColor;
    }

    public Section2D(Vector _1, Vector _2, Color outlineColor) throws IllegalArgumentException {
        this.section = new Section(_1, _2);
        this.outlineColor = outlineColor;
    }

    public Section2D(Section section, Color outlineColor) {
        this.section = new Section(section);
        this.outlineColor = outlineColor;
    }

    @Override
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
        graphics.setColor(outlineColor);
        graphics.drawLine((int) (section._1.x + parentPos.x), (int) (section._1.y + parentPos.y),
                (int) (section._2.x + parentPos.x), (int) (section._2.y + parentPos.y));
    }
}
