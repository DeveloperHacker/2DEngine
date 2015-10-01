package com.gameEngine.math;

public class Line {
    public final double A;
    public final double B;
    public final double C;
    public Line(Line line) {
        A = line.A;
        B = line.B;
        C = line.C;
    }
    public Line(double A, double B, double C) throws Exception {
        this.A = A;
        this.B = B;
        this.C = C;
        if ((A == 0) && (B == 0)) throw new Exception("Error: Line:" + this.toString());
    }
    public double solve(Point p) {
        return A*p.x + B*p.y + C;
    }
    public double solve(double x, double y) {
        return A*x + B*y + C;
    }
    static boolean intersection(Line _1, Line _2) {
        return !(_1.A/_2.A == _1.B/_2.B);
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        return (((Line)obj).A == A) && (((Line)obj).B == B) && (((Line)obj).C == C);
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        final int c = 11;
        final int d = 13;
        return a + b * (int)A + c * (int)B + d * (int)C;
    }
    @Override
    public java.lang.Object clone() {
        return new Line(this);
    }
    @Override
    public String toString() {
        return "[" + A + "x + " + B + "y + " + C + " = 0]";
    }
}
