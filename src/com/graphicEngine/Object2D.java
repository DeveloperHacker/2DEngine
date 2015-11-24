package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;

import java.awt.*;

public class Object2D {

    public final Object object;
    private GraphicsModel background;

    public Object2D(Object object, GraphicsModel background) {
        this.object = new Object(object);
        this.background = background;
    }

    public Object2D(Object2D object, GraphicsModel background) {
        this.object =  object.object;
        this.background = background;
    }

    public Object2D(Point pos, Figure mask, double mass, Vector speed, boolean movable, String name, GraphicsModel background) {
        object = new Object(pos, mask, mass, speed, movable, name);
        this.background = background;
    }

    public Object2D(Point pos, Figure mask, double mass, boolean movable, String name, GraphicsModel background) {
        object = new Object(pos, mask, mass, movable, name);
        this.background = background;
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

    public void show(Graphics graphics, Point posScreen, int height, int width) {
        background.show(graphics, Point.rem(posScreen, object.pos()), height, width);
    }
}
