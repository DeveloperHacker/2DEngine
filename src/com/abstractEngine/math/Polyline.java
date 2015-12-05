package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Polyline {

    private Vector pos;
    private List<Vector> vectors;

    public Polyline(Polyline polyline) {
        pos = polyline.pos;
        vectors = new ArrayList<>(polyline.vectors);
    }

    public Polyline(Vector pos, List<Vector> vectors) {
        this.vectors = new ArrayList<>(vectors);
        this.pos = pos;
    }

    public static boolean intersection(Polyline _1, Figure _2) {
        for (Vector vector : _1.vectors) {
            if (_2.isInside(vector)) return true;
        }
        return _2.isInside(_1.pos);
    }

    public static boolean intersection(Polyline _1, Polyline _2) {
        Vector prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (intersection(_2, new Section(prev, vector))) return true;
            prev = vector;
        }
        return false;
    }

    public static boolean intersection(Polyline _1, Section _2) {
        Vector prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Section.intersection(_2, new Section(prev, vector))) return true;
            prev = vector;
        }
        return false;
    }

    public static boolean intersection(Polyline _1, Line _2) {
        Vector prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Line.intersection(_2, new Section(prev, vector))) return true;
            prev = vector;
        }
        return false;
    }

    public void set(Vector pos) {
        this.pos = pos;
    }

    public Vector pos() {
        return pos;
    }

    public List<Vector> vectors() {
        return new ArrayList<>(vectors);
    }
}
