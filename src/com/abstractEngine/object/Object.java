package com.abstractEngine.object;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;

public class Object {
    private Point pos;
    private Figure mask;
    private double mass;
    private Vector speed;
    private final boolean movable;
    private final String name;

    public Object(Object object, boolean movable) {
        this.pos = object.pos;
        this.mask = object.mask;
        this.mass = object.mass;
        this.speed = object.speed;
        this.name = object.name;
        this.movable = movable;
    }

    public Object(Object object) {
        this.pos = object.pos;
        this.mask = object.mask;
        this.mass = object.mass;
        this.speed = object.speed;
        this.name = object.name;
        this.movable = object.movable;
    }

    public Object(Point pos, Figure mask, double mass, Vector speed, boolean movable, String name) {
        this.pos = pos;
        this.mask = mask;
        this.mass = mass;
        this.speed = speed;
        this.name = name;
        this.movable = movable;
    }

    public Object(Point pos, Figure mask, double mass, boolean movable, String name) {
        this.pos = pos;
        this.mask = mask;
        this.mass = mass;
        this.speed = new Vector();
        this.name = name;
        this.movable = movable;
    }

    public void setMask(Figure mask) {
        this.mask = new Figure(mask);
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setSpeed(Vector speed) {
        this.speed = speed;
    }

    public Figure mask() {
        return new Figure(mask);
    }

    public Point pos() {
        return pos;
    }

    public double mass() {
        return mass;
    }

    public Vector speed() {
        return speed;
    }

    public String name() {
        return name;
    }

    public boolean movable() {
        return movable;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Object)) return false;
        Object object = (Object) o;
        return object.mask.equals(mask);
    }

    @Override
    public int hashCode() {
        int result;
        result = mask.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "['Speed = " + speed + "', 'Position = " + pos + "', 'Mask = " + mask + "', 'Mass = " + mass + "']";
    }
}
