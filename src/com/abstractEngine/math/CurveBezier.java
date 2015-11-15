package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class CurveBezier {
    private Point pos;
    private final List<Vector> vectors;
    private double step;

    public  CurveBezier(CurveBezier curve) {
        this.pos = curve.pos();
        vectors = new ArrayList<>(curve.vectors);
        this.step = step;
    }

    public CurveBezier(List<Vector> vectors, Point pos, List<Vector> vectors1, double step) throws IllegalArgumentException {
        if (vectors.size() < 2) throw new IllegalArgumentException();
        this.vectors = new ArrayList<>(vectors);
        this.pos = pos;
        this.step = step;
    }

    public Polyline toPolyline() {
        List<Point> points = new ArrayList<>();
        Point prev = pos;
        points.add(prev);
        for (Vector vector : vectors) {
            prev = Point.add(prev, vector.pos);
            points.add(prev);
        }
        List<Integer> cnk = new ArrayList<>();
        List<Integer> prevcnk;
        cnk.add(1);
        cnk.add(1);
        for (int i = 3; i < points.size(); ++i) {
            prevcnk = cnk;
            cnk.clear();
            cnk.add(1);
            for (int j = 1; j < prevcnk.size() - 1; ++j) {
                cnk.set(j, prevcnk.get(j - 1) + prevcnk.get(j));
            }
            cnk.add(1);
        }
        List<Point> newPoints = new ArrayList<>();
        double way = 0;
        while (way <= 1) {
            double x = 0;
            double y = 0;
            for (int i = 0; i < points.size(); ++i) {
                x += points.get(i).x * Math.pow(way, i) * Math.pow(1.0 - way, points.size() - i - 1);
                y += points.get(i).y * Math.pow(way, i) * Math.pow(1.0 - way, points.size() - i - 1);
            }
            newPoints.add(new Point(x, y));
            way += step;
        }
        List<Vector> vectors = new ArrayList<>();
        Point prev1 = points.get(0);
        for (int i = 1; i < points.size(); ++i) {
            vectors.add(new Vector(Point.rem(points.get(i), prev1)));
            prev1 = points.get(i);
        }
        return new Polyline(points.get(0), vectors);
    }

    public List<Vector> vectors() {
        return new ArrayList<>(vectors);
    }

    public Point pos() {
        return pos;
    }

    public void set(Point pos) {
        this.pos = pos;
    }

    public double step() {
        return step;
    }

    public void set(double step) {
        this.step = step;
    }
}