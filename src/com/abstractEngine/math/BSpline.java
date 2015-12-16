package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class BSpline implements Curve {
    private final List<Vector> points;

    public BSpline(Vector P1, Vector P2, Vector P3) {
        this.points = new ArrayList<>(3);
        this.points.add(P1);
        this.points.add(P2);
        this.points.add(P3);
    }

    @Override
    public Polyline toPolyline(double step) {
        Vector P0 = points.get(0);
        Vector P1 = points.get(1);
        Vector P2 = points.get(2);
        Double N0;
        Double N1;
        Double N2;
        List<Vector> vectors = new ArrayList<>();
        double t = step;
        Vector current = P0;
        Vector prev;
        while (t <= 1.0) {
            N0 = 1.0 / 2.0 * (1.0 - t) * (1.0 - t);
            N1 = 3.0 / 4.0 - (1.0 / 2.0 - t) * (1.0 / 2.0 - t);
            N2 = 1.0 / 2.0 * t * t;
            prev = current;
            current = P0.scale(N0)
                    .add(P1.scale(N1))
                    .add(P2.scale(N2));
            vectors.add(current.rem(prev));
            t += step;
        }
        return new Polyline(P0, vectors);
    }

    @Override
    public Polyline getGuidePolyline() {
        List<Vector> vectors = new ArrayList<>();
        Vector pos = points.get(0);
        Vector prev;
        Vector current = pos;
        for (int i = 1; i < points.size(); ++i) {
            prev = current;
            current = points.get(i);
            vectors.add(current.rem(prev));
        }
        return new Polyline(pos, vectors);
    }
}
