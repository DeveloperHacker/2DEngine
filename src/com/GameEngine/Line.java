package com.GameEngine;

public class Line {
    public final double A;
    public final double B;
    public final double C;
    public Line(Line line) {
        A = line.A;
        B = line.B;
        C = line.C;
    }
    public Line(double A, double B, double C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }
    public double solve(Point p) {
        return A*p.x + B*p.y + C;
    }
    public double solve(double x, double y) {
        return A*x + B*y + C;
    }
    static boolean intersection(Line _1, Line _2){
        return !(_1.A/_2.A == _1.B/_2.B);
    }
}
