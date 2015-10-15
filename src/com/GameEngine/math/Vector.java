package com.gameEngine.math;

public class Vector {
    public final Point pos;
    public Vector() {
        pos = new Point();
    }
    public Vector(Vector vector) {
        pos = vector.pos;
    }
    public Vector(Point point) {
        pos = point;
    }
    public Vector(double x, double y) {
        pos = new Point(x , y);
    }
    public double abs() {
        return Math.sqrt(pos.x * pos.x + pos.y * pos.y);
    }
    public static Vector add(Vector _1, Vector _2) {
        return new Vector(_1.pos.x + _2.pos.x, _1.pos.y + _2.pos.y);
    }
    public static Vector rem(Vector _1, Vector _2) {
        return new Vector(_1.pos.x - _2.pos.x, _1.pos.y - _2.pos.y);
    }
    public static double scalarMul(Vector _1, Vector _2) {
        return _1.pos.x * _2.pos.x + _1.pos.y * _2.pos.y;
    }
    public static double cos(Vector _1, Vector _2) {
        return scalarMul(_1, _2) / (_1.abs() * _2.abs());
    }
    public static double vectorMul(Vector _1, Vector _2) {
        return _1.pos.x * _2.pos.y - _2.pos.x * _1.pos.y;
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj instanceof Figure) {
            Vector vector = (Vector)obj;
            if (!vector.pos.equals(pos)) return false;
            return true;
        }
        else return false;
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        return a + b * pos.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new Vector(this);
    }
    @Override
    public String toString() {
        return "[" + pos.x + "X + " + pos.y + "Y]";
    }
}
