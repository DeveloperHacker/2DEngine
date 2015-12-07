package com.abstractEngine;

import com.abstractEngine.math.Vector;
import com.graphicEngine.Screen;

import java.awt.*;

public abstract class ModelElement<T> {

    public final String name;
    protected Vector pos;

    public ModelElement(String name) {
        this.name = name;
    }

    abstract public void show(Graphics graphics, Screen screen, Vector parentPos);

    public Vector pos() {
        return pos;
    }

    public void moveTo(Vector pos) {
        this.pos = pos;
    }
}
