package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class CurveBezier implements Curve{
    private final List<Vector> points;
    private static double[] koef3 = {1, 2, 1};
    private static double[] koef4 = {1, 3, 3, 1};
    private static double[] koef5 = {1, 4, 6, 4, 1};

    public  CurveBezier(CurveBezier curve) {
        points = new ArrayList<>(curve.points);
    }

    public CurveBezier(Vector P1, Vector P2, Vector P3) {
        this.points = new ArrayList<>(3);
        this.points.add(P1);
        this.points.add(P2);
        this.points.add(P3);
    }

    public CurveBezier(Vector P1, Vector P2, Vector P3, Vector P4) {
        this.points = new ArrayList<>(4);
        this.points.add(P1);
        this.points.add(P2);
        this.points.add(P3);
        this.points.add(P4);
    }

    public CurveBezier(Vector P1, Vector P2, Vector P3, Vector P4, Vector P5) {
        this.points = new ArrayList<>(4);
        this.points.add(P1);
        this.points.add(P2);
        this.points.add(P3);
        this.points.add(P4);
        this.points.add(P5);
    }

    @Override
    public Polyline toPolyline(double step) {
        List<Vector> vectors = new ArrayList<>();
        int size = this.points.size();
        double[] koef = {};
        switch (size) {
            case 3: {
                koef = koef3;
                break;
            }
            case 4: {
                koef = koef4;
                break;
            }
            case 5: {
                koef = koef5;
                break;
            }
        }
        double way = step;
        Vector current = points.get(0);
        Vector prev;
        while (way <= 1) {
            prev = current;
            current = new Vector();
            for (int i = 0; i < size; ++i) {
                current = current.add(points.get(i).scale(koef[i] * Math.pow(1 - way, size - i - 1) * Math.pow(way, i)));
            }
            vectors.add(current.rem(prev));
            way += step;
        }
        return new Polyline(points.get(0), vectors);
    }

    @Override
    public Polyline getGuidePolyline() {
        List<Vector> vectors = new ArrayList<>();
        Vector pos = points.get(0);
        Vector prev;
        Vector current = pos;
        for (int i = 1; i < points.size(); ++i){
            prev = current;
            current = points.get(i);
            vectors.add(current.rem(prev));
        }
        return new Polyline(pos, vectors);
    }
}
