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
        if (this == obj) return true;
        if (obj instanceof Point) {
            Point point = (Point) obj;
            return (point.x == x) && (point.y == y);
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "(" + x + "; " + y + ")";
    }
}
