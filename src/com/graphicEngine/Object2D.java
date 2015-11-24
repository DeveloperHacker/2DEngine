package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;

import java.awt.*;

public class Object2D {

    public final Object object;
    private Figure2D mask;
    private GraphicsModel background;

    public Object2D(Object object, Color outlineColor) {
        this.object = new Object(object.pos(), object.mask(), object.mass(), object.speed(), object.movable(), object.name());
        this.mask = new Figure2D(object.mask(), outlineColor);
    }

    public Object2D(Object2D object, Frame2D background, Color outlineColor) {
        this.object = new Object(object.object.pos(), object.object.mask(), object.object.mass(), object.object.speed(), object.object.movable(), object.object.name());
        this.mask = new Figure2D(object.object.mask(), outlineColor);
        this.background = background;
    }

    public Object2D(Point pos, Figure mask, double mass, Vector speed, boolean movable, String name, Color outlineColor) {
        object = new Object(pos, mask, mass, speed, movable, name);
        this.mask = new Figure2D(mask, outlineColor);
    }

    public Object2D(Point pos, Figure mask, double mass, boolean movable, String name, Color outlineColor) {
        object = new Object(pos, mask, mass, movable, name);
        this.mask = new Figure2D(mask, outlineColor);
    }

    public void set(GraphicsModel background) {
        this.background = background;
    }

    public GraphicsModel background() {
        return background;
    }

    public String name() {
        return object.name();
    }

    public void showOutline(Graphics graphics, Point posScreen, int height, int width) {
        mask.show(graphics, posScreen, height, width);
    }

    public void show(Graphics graphics, Point posScreen, int height, int width) {
        background.show(graphics, Point.rem(posScreen, object.pos()), height, width);
    }
}
