package com.GameEngine;

public class MovableObject extends Object {
    private Vector s;
    private Float hp;
    private Boolean unf;
    private Float m;
    private Vector n;

    public MovableObject() {

    }
    public MovableObject(MovableObject obj) {

    }
    public void setSpeed(Vector speed) { s = speed; }
    public void setHP(Float HP) { hp = HP; }
    public void setUnfallen(Boolean unfallen) { unf = unfallen; }
    public void setMass(Float mass) { m = mass; }
    public void setNormal(Vector normal) { n = normal; }
    public Vector getSpeed() { return s; }
    public Float getHP() { return hp; }
    public Boolean getUnfallen() { return unf; }
    public Float getMass() { return m; }
    public Vector getNormal() { return n; }
}
