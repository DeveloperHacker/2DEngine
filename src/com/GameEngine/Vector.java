package com.GameEngine;

public class Vector {
    public final Point v;
    public Vector() {
        v = new Point();
    }
    public Vector(Point point) {
        v = point;
    }
    public Vector(double x, double y) {
        v = new Point(x , y);
    }
    public double abs() {
        return Math.sqrt(v.x * v.x + v.y * v.y);
    }
    static Vector add(Vector _1, Vector _2) {
        return new Vector(_1.v.x + _2.v.x, _1.v.y + _2.v.y);
    }
    static Vector rem(Vector _1, Vector _2) {
        return new Vector(_1.v.x - _2.v.x, _1.v.y - _2.v.y);
    }
    static double mul(Vector _1, Vector _2) {
        return _1.v.x * _2.v.x + _1.v.y * _2.v.y;
    }
    static double cos(Vector _1, Vector _2) {
        return mul(_1, _2) / (_1.abs() * _2.abs());
    }
    @Override
    public String toString() {
        return "Vector: " + v.toString();
    }
}
