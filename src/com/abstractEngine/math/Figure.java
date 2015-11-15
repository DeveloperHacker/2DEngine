package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Figure {

    private Point pos;
    private List<Vector> vectors;
    public Point center;

    public Figure(Figure figure) {
        pos = figure.pos;
        center = figure.center;
        vectors = new ArrayList<>(figure.vectors);
    }

    public Figure(Point pos, List<Vector> vec) throws IllegalArgumentException {
        this.pos = pos;
        if (vec.size() < 3) throw new IllegalArgumentException();
        Vector sum = vec.get(0);
        for (int i = 1; i < vec.size(); ++i) sum = Vector.add(sum, vec.get(i));
        if (!sum.equals(new Vector())) throw new IllegalArgumentException("Figure is not closed.");
        double direct = Vector.vectorMul(vec.get(vec.size() - 1), vec.get(0));
        for (int i = 1; i < vec.size(); ++i)
            if (0 > direct * Vector.vectorMul(vec.get(i - 1), vec.get(i)))
                throw new IllegalArgumentException("Figure is not convex.");
        vectors = new ArrayList<>(vec);
        center = calcCenter();
    }

    public boolean isInside(Point point) {
        Vector m = new Vector(point.x - pos.x, point.y - pos.y);
        double direct = Vector.vectorMul(m, vectors.get(0));
        for (int i = 1; i < vectors.size(); ++i) {
            m = Vector.rem(m, vectors.get(i - 1));
            if (0 > direct * Vector.vectorMul(m, vectors.get(i))) return false;
        }
        return true;
    }

    private Point calcCenter() {
        Vector current = vectors.get(0);
        double x = current.pos.x;
        double y = current.pos.y;
        for (int i = 1; i < vectors.size(); ++i) {
            current = Vector.rem(current, vectors.get(i));
            x += current.pos.x;
            y += current.pos.y;
        }
        return new Point(x * vectors.size(), y * vectors.size());
    }

    public static boolean intersection(Figure _1, Figure _2) {
        Vector prev = new Vector();
        for (Vector vector : _1.vectors) {
            prev = Vector.add(prev, vector);
            if (_2.isInside(new Point(_1.pos.x + prev.pos.x, _1.pos.y + prev.pos.y))) return true;
        }
        prev = new Vector();
        for (Vector vector : _2.vectors) {
            prev = Vector.add(prev, vector);
            if (_1.isInside(new Point(_2.pos.x + prev.pos.x, _2.pos.y + prev.pos.y))) return true;
        }
        return false;
    }

    public static boolean intersection(Figure _1, Polyline _2) {
        return Polyline.intersection(_2, _1);
    }

    public static boolean intersection(Figure _1, Section _2) {
        return _1.isInside(_2._1) || _1.isInside(_2._2);
    }

    public static boolean intersection(Figure _1, Line _2) {
        Point prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Section.intersection(new Section(prev, vector.pos), _2)) return true;
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

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Figure)) return false;
        Figure figure = (Figure) obj;
        return figure.vectors.equals(vectors);
    }

    @Override
    public int hashCode() {
        int result;
        result = vectors.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + "'Position = " + pos + "', 'Vectors = " + vectors + "']";
    }
}
