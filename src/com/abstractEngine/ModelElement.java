package com.abstractEngine;

import com.abstractEngine.math.Vector;
import com.graphicEngine.Screen;

import java.awt.*;

public abstract class ModelElement {

    public final String name;
    protected Vector pos;

    public ModelElement(Vector pos, String name) {
        this.name = name;
        this.pos = pos;
    }

    abstract public void show(Graphics graphics, Screen screen, Vector parentPos);

    public Vector pos() {
        return pos;
    }

    public void moveTo(Vector pos) {
        this.pos = pos;
    }
}
