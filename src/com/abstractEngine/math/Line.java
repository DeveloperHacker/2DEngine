package com.abstractEngine.math;

public class Line {
    public final double A;
    public final double B;
    public final double C;

    public Line(Line line) {
        A = line.A;
        B = line.B;
        C = line.C;
    }

    public Line(Section section) {
        this.A = section._2.y - section._1.y;
        this.B = section._1.x - section._2.x;
        this.C = -section._1.x * section._2.y + section._2.x * section._1.y;
    }

    public Line(double A, double B, double C) throws IllegalArgumentException {
        this.A = A;
        this.B = B;
        this.C = C;
        if ((A == 0) && (B == 0)) throw new IllegalArgumentException("Error: Line:" + this.toString());
    }

    public double solve(Point p) {
        return A * p.x + B * p.y + C;
    }

    public double solve(double x, double y) {
        return A * x + B * y + C;
    }

    public double y(double x) {
        return -A / B * x - C / B;
    }

    public double x(double y) {
        return -B / A * y - C / A;
    }

    public static boolean intersection(Line _1, Line _2) {
        return (_1.equals(_2)) || (_1.A * _2.B != _1.B * _2.A);
    }

    public static boolean intersection(Line _1, Section _2) {
        return (_1.solve(_2._1) * _1.solve(_2._2) < 0);
    }

    public static boolean intersection(Line _1, Figure _2) {
        return (Figure.intersection(_2, _1));
    }

    public static boolean intersection(Line _1, Polyline _2) {
        return Polyline.intersection(_2, _1);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj instanceof Line) {
            Line line = (Line) obj;
            return (line.A * B == line.B * A) && (line.C * B == line.B * C);
        } else return false;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(A);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(B);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(C);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "[" + A + "x + " + B + "y + " + C + " = 0]";
    }
}
