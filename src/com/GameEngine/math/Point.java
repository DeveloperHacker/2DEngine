package com.gameEngine.math;

public class Point {
    public final double x;
    public final double y;
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(Point point) {
        x = point.x;
        y = point.y;
    }
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        return (((Point)obj).x == x) && (((Point)obj).y == y);
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        final int c = 11;
        return a + b * (int)x + c * (int)y;
    }
    @Override
    public java.lang.Object clone() {
        return new Point(this);
    }
    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
