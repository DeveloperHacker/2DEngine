package com.graphicEngine;

import com.abstractEngine.math.Ellipse;
import com.abstractEngine.math.Vector;

import java.awt.*;

public class Ellipse2D implements View {

    public final Ellipse ellipse;
    private Color outlineColor;
    private Color fillColor;

    public Ellipse2D(Ellipse ellipse, Color outlineColor, Color fillColor) {
        this.ellipse = ellipse;
        this.outlineColor = outlineColor;
        this.fillColor = fillColor;
    }

    public Ellipse2D(Ellipse ellipse, Color outlineColor) {
        this(ellipse, outlineColor, null);
    }

    public Color getOutlineColor() {
        return outlineColor;
    }

    public Color getFillColor() {
        return fillColor;
    }

    public void setOutlineColor(Color outlineColor) {
        this.outlineColor = outlineColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        Vector size = new Vector(ellipse.getWidth(), ellipse.getHeight());
        Vector temp = parentPos.add(ellipse.getPosition()).rem(size.scale(1.0 / 2));
        if (fillColor != null) {
            graphics.setColor(fillColor);
            graphics.fillOval((int) (temp.x), (int) (temp.y), (int) (size.x), (int) (size.y));
        }
        graphics.setColor(outlineColor);
        graphics.drawOval((int) (temp.x), (int) (temp.y), (int) (size.x), (int) (size.y));
    }
}
