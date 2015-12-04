package com.abstractEngine.math;

public class Vector extends Point{

    public Vector() {
        super();
    }

    public Vector(Vector vector) {
        super(vector);
    }

    public Vector(Point point) {
        super(point);
    }

    public Vector(double x, double y) {
        super(x, y);
    }

    public double abs() {
        return Math.sqrt(x * x + y * y);
    }

    public Vector add(Vector vector) {
        return new Vector(add((Point)vector));
    }

    public Vector rem(Vector vector) {
        return new Vector(rem((Point)vector));
    }

    public Vector mul(double num) {
        return new Vector(x * num, y * num);
    }

    public Vector minus() {
        return new Vector(-x, -y);
    }

    public double scalarMul(Vector vector) {
        return x * vector.x + y * vector.y;
    }

    public double cos(Vector vector) {
        return scalarMul(vector) / (abs() * vector.abs());
    }

    public double vectorMul(Vector vector) {
        return x * vector.y - vector.x * y;
    }

    public Vector rotate(double theta) {
        double cos = Math.cos(theta);
        double sin = Math.sin(theta);
        return new Vector(x * cos - y * sin, x * sin + y * cos);
    }

    @Override
    public String toString() {
        return "[" + x + "X + " + y + "Y]";
    }
}
