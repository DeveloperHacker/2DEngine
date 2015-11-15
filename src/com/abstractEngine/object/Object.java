package com.abstractEngine.object;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;

import java.util.ArrayList;
import java.util.List;

public class Object {
    private Point pos;
    private List<Figure> mask;
    private double mass;
    private Vector speed;
    private final String name;

    public Object(Object object) {
        pos = object.pos;
        mask = object.mask;
        mass = object.mass;
        speed = object.speed;
        name = object.name;
    }

    public Object(Point pos, List<Figure> mask, double mass, Vector speed, String name) {
        this.pos = pos;
        this.mask = mask;
        this.mass = mass;
        this.speed = speed;
        this.name = name;
    }

    public Object(Point pos, List<Figure> mask, double mass, String name) {
        this.pos = pos;
        this.mask = mask;
        this.mass = mass;
        this.speed = new Vector();
        this.name = name;
    }

    public Object(Point pos, double mass, String name) {
        this.pos = pos;
        this.mask = new ArrayList<>();
        this.mass = mass;
        this.speed = new Vector();
        this.name = name;
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

    public void add(Figure figure) {
        mask.add(figure);
    }

    public List<Figure> mask() {
        return mask;
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
        return "[" + "'Position = " + pos + "', 'Mask = " + mask + "', 'K = " + mass + "']";
    }
}
