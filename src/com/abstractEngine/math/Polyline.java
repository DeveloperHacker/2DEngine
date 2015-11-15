package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Polyline {

    private Point pos;
    private List<Vector> vectors;

    public Polyline(Polyline polyline) {
        pos = polyline.pos;
        vectors = new ArrayList<>(polyline.vectors);
    }

    public Polyline(Point pos, List<Vector> vectors) {
        this.vectors = new ArrayList<>(vectors);
        this.pos = pos;
    }

    public static boolean intersection(Polyline _1, Figure _2) {
        for (Vector vector : _1.vectors) {
            if (_2.isInside(vector.pos)) return true;
        }
        return _2.isInside(_1.pos);
    }

    public static boolean intersection(Polyline _1, Polyline _2) {
        Point prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (intersection(_2, new Section(prev, vector.pos))) return true;
            prev = vector.pos;
        }
        return false;
    }

    public static boolean intersection(Polyline _1, Section _2) {
        Point prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Section.intersection(_2, new Section(prev, vector.pos))) return true;
            prev = vector.pos;
        }
        return false;
    }

    public static boolean intersection(Polyline _1, Line _2) {
        Point prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Line.intersection(_2, new Section(prev, vector.pos))) return true;
            prev = vector.pos;
        }
        return false;
    }

    public void setPos(Point pos) {
        this.pos = pos;
    }

    public Point pos() {
        return pos;
    }

    public List<Vector> vectors() {
        return new ArrayList<>(vectors);
    }
}
