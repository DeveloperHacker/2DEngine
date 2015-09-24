package com.GameEngine;
import java.util.ArrayList;

public class MovableObject extends Object {
    private Vector s;
    private double hp;
    private boolean unf;
    private double m;
    private Vector n;
    public MovableObject(MovableObject obj) {
        super(obj.pos, obj.h, obj.w, obj.mask, obj.k);
        this.s = obj.s;
        this.hp = obj.hp;
        this.unf = obj.unf;
        this.m = obj.m;
        this.n = obj.n;
    }
    public MovableObject(Point pos, Vector h, Vector w, ArrayList<Figure> mask, double k,
                         Vector s, double hp, boolean unf, double m, Vector n) {
        super(pos, h, w, mask, k);
        this.s = s;
        this.hp = hp;
        this.unf = unf;
        this.m = m;
        this.n = n;
    }
    public MovableObject(Point pos, Vector h, Vector w, double k,
                         Vector s, double hp, boolean unf, double m, Vector n) {
        super(pos, h, w, k);
        this.s = s;
        this.hp = hp;
        this.unf = unf;
        this.m = m;
        this.n = n;
    }
    public void setSpeed(Vector speed) { s = speed; }
    public void setHP(double HP) { hp = HP; }
    public void setUnfallen(Boolean unfallen) { unf = unfallen; }
    public void setMass(double mass) { m = mass; }
    public void setNormal(Vector normal) { n = normal; }
    public Vector getSpeed() { return s; }
    public double getHP() { return hp; }
    public Boolean getUnfallen() { return unf; }
    public double getMass() { return m; }
    public Vector getNormal() { return n; }
    @Override
    public String toString() {
        return "MovableObject: [" +
                "'Pos = " + pos.toString() +
                "', 'Height = " + h.abs() +
                "', 'Width = " + w.abs() +
                "', 'Mask = " + mask.toString() +
                "', 'K = " + k +
                "', 'Speed = " + s.toString() +
                "', 'Hp = " + hp +
                "', 'Unfallen = " + unf +
                "', 'Mass = " + m +
                "', 'n = " + n.toString() +
        "']";
    }
}
