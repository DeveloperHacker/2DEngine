package com.graphicEngine;

import com.abstractEngine.math.Ellipse;
import com.abstractEngine.math.Vector;

import java.awt.*;

public class Ellipse2D implements View {

    public final Ellipse ellipse;
    private Color outline;

    public Ellipse2D(Ellipse ellipse, Color outline) {
        this.ellipse = ellipse;
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
        graphics.setColor(outline);
        Vector size = new Vector(ellipse.getWidth(), ellipse.getHeight());
        Vector temp = parentPos.add(ellipse.getPosition()).rem(size.scale(1.0/2));
        graphics.drawOval((int)(temp.x), (int)(temp.y), (int)(size.x), (int)(size.y));
    }
}
