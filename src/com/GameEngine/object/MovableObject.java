package com.gameEngine.object;
import com.gameEngine.math.*;
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
    public boolean equals(java.lang.Object obj) {
        return ((MovableObject)obj).s.equals(s)
                && ((MovableObject)obj).hp == hp
                && ((MovableObject)obj).unf == unf
                && ((MovableObject)obj).m == m
                && ((MovableObject)obj).n.equals(n);
    }
    @Override
    public int hashCode() {
        final int a = 37;
        final int b = 19;
        final int c = 23;
        final int d = 29;
        final int e = 31;
        return super.hashCode() + a * s.hashCode() + b * (int)hp + c * (unf ? 1 : 0) + d * (int)m + e * n.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new MovableObject(this);
    }
    @Override
    public String toString() {
        return "[" + "'Position = " + pos.toString() +
                "', 'Height = " + h.abs() +
                "', 'Width = " + w.abs() +
                "', 'Mask = " + mask.toString() +
                "', 'K = " + k +
                "', 'Speed = " + s.toString() +
                "', 'Hp = " + hp +
                "', 'Unfallen = " + unf +
                "', 'Mass = " + m +
                "', 'n = " + n.toString() + "']";
    }
}
