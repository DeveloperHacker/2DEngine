package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class CurveBezier {
    private Vector pos;
    private final List<Vector> vectors;
    private double step;

    public  CurveBezier(CurveBezier curve) {
        this.pos = curve.pos();
        vectors = new ArrayList<>(curve.vectors);
    }

    public CurveBezier(List<Vector> vectors, Vector pos, List<Vector> vectors1, double step) throws IllegalArgumentException {
        if (vectors.size() < 2) throw new IllegalArgumentException();
        this.vectors = new ArrayList<>(vectors);
        this.pos = pos;
        this.step = step;
    }

    public Polyline toPolyline() {
        List<Vector> Vectors = new ArrayList<>();
        Vector prev = pos;
        Vectors.add(prev);
        for (Vector vector : vectors) {
            prev = prev.add(vector);
            Vectors.add(prev);
        }
        List<Integer> cnk = new ArrayList<>();
        List<Integer> prevcnk;
        cnk.add(1);
        cnk.add(1);
        for (int i = 3; i < Vectors.size(); ++i) {
            prevcnk = cnk;
            cnk.clear();
            cnk.add(1);
            for (int j = 1; j < prevcnk.size() - 1; ++j) {
                cnk.set(j, prevcnk.get(j - 1) + prevcnk.get(j));
            }
            cnk.add(1);
        }
        List<Vector> newVectors = new ArrayList<>();
        double way = 0;
        while (way <= 1) {
            double x = 0;
            double y = 0;
            for (int i = 0; i < Vectors.size(); ++i) {
                x += Vectors.get(i).x * Math.pow(way, i) * Math.pow(1.0 - way, Vectors.size() - i - 1);
                y += Vectors.get(i).y * Math.pow(way, i) * Math.pow(1.0 - way, Vectors.size() - i - 1);
            }
            newVectors.add(new Vector(x, y));
            way += step;
        }
        List<Vector> vectors = new ArrayList<>();
        Vector prev1 = Vectors.get(0);
        for (int i = 1; i < Vectors.size(); ++i) {
            vectors.add(new Vector(Vectors.get(i).rem(prev1)));
            prev1 = Vectors.get(i);
        }
        return new Polyline(Vectors.get(0), vectors);
    }

    public List<Vector> vectors() {
        return new ArrayList<>(vectors);
    }

    public Vector pos() {
        return pos;
    }

    public void set(Vector pos) {
        this.pos = pos;
    }

    public double step() {
        return step;
    }

    public void set(double step) {
        this.step = step;
    }
}
