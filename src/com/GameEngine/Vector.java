package com.GameEngine;

public class Vector {
    private Point v;
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
}
