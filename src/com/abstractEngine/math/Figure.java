package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Figure {

    private Vector pos;
    private List<Vector> vectors;
    private Vector center;

    public Figure(Figure figure) {
        this.pos = figure.pos;
        this.center = figure.center;
        this.vectors = new ArrayList<>(figure.vectors);
    }

    public Figure(Vector pos, Figure figure) {
        this.pos = pos;
        this.center = figure.center;
        this.vectors = new ArrayList<>(figure.vectors);
    }

    public Figure(Vector pos, List<Vector> vec) throws IllegalArgumentException {
        this.pos = pos;
        if (vec.size() < 3) throw new IllegalArgumentException("Figure is not region");
        Vector sum = vec.get(0);
        for (int i = 1; i < vec.size(); ++i) sum = sum.add(vec.get(i));
        if (sum.abs() > Vector.EPSILON) throw new IllegalArgumentException("Figure is not closed.");
        this.vectors = new ArrayList<>(vec);
        this.center = calcCenter();
    }

    public Figure(List<Vector> vec) throws IllegalArgumentException {
        this(new Vector(), vec);
    }

    public boolean convex() {
        double direct = vectors.get(vectors.size() - 1).mul(vectors.get(0));
        for (int i = 1; i < vectors.size(); ++i)
            if (0 > direct * vectors.get(i - 1).mul(vectors.get(i)))
                return false;
        return true;
    }

    public double height() {
        Vector prev = new Vector(pos);
        double min = prev.y;
        double max = prev.y;
        for (Vector vector : vectors) {
            prev = prev.add(vector);
            if (prev.y > max) max = prev.y;
            if (prev.y < min) min = prev.y;
        }
        return Math.abs(max - min);
    }

    public double width() {
        Vector prev = new Vector(pos);
        double min = prev.x;
        double max = prev.x;
        for (Vector vector : vectors) {
            prev = prev.add(vector);
            if (prev.x > max) max = prev.x;
            if (prev.x < min) min = prev.x;
        }
        return Math.abs(max - min);
    }

    public boolean isInside(Vector Vector) {
        Vector m = new Vector(Vector).rem(new Vector(pos));
        double direct = 0;
        double temp;
        boolean init = false;
        for (Vector vector : vectors) {
            temp = vector.mul(m);
            m = m.rem(vector);
            if (temp != 0) {
                if (!init) {
                    init = true;
                } else if (direct * temp < 0)
                    return false;
                direct = temp;
            }
        }
        return true;
    }

    private Vector calcCenter() {
        Vector prev = pos;
        double x = prev.x;
        double y = prev.y;
        for (int i = 0; i < vectors.size() - 1; ++i) {
            prev = prev.add(vectors.get(i));
            x += prev.x;
            y += prev.y;
        }
        return new Vector(x / vectors.size(), y / vectors.size());
    }

    public static boolean intersection(Figure _1, Figure _2) {
        Vector prev = new Vector(_1.pos());
        for (Vector vector : _1.vectors) {
            prev = prev.add(vector);
            if (_2.isInside(prev)) return true;
        }
        prev = new Vector(_2.pos());
        for (Vector vector : _2.vectors) {
            prev = prev.add(vector);
            if (_1.isInside(prev)) return true;
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
        Vector prev = _1.pos;
        for (Vector vector : _1.vectors) {
            if (Section.intersection(new Section(prev, vector), _2)) return true;
            prev = vector;
        }
        return false;
    }

    public void moveTo(Vector pos) {
        this.pos = pos;
        this.center = calcCenter();
    }

    public Vector pos() {
        return pos;
    }

    public Vector vectors(int index) {
        return vectors.get(index);
    }

    public List<Vector> vectors() {
        return new ArrayList<>(vectors);
    }

    public Vector set(List<Vector> vectors) {
        this.vectors = new ArrayList<>(vectors);
        center = calcCenter();
        return center;
    }

    public Vector center() {
        return center;
    }

    public void scale(Vector origin, double scale) {
        Vector pos = new Vector(this.pos);
        this.pos = pos.rem(origin).scale(scale).add(origin);
        for (int i = 0; i < vectors.size(); ++i) {
            vectors.set(i, vectors.get(i).scale(scale));
        }
    }

    public void rotate(Vector origin, double theta) {
        pos = pos.rem(origin).rotate(theta).add(origin);
        for (int i = 0; i < vectors.size(); ++i) {
            vectors.set(i, vectors.get(i).rotate(theta));
        }
        this.center = calcCenter();
    }

    public Rectangle roundRectangle() {
        return new Rectangle(new Vector(minX(), minY()), width(), height());
    }

    public double minX() {
        double min = pos.x;
        Vector current = pos;
        for (Vector vector: vectors) {
            current = current.add(vector);
            if (current.x < min) {
                min = current.x;
            }
        }
        return min;
    }

    public double maxX() {
        double max = pos.x;
        Vector current = pos;
        for (Vector vector: vectors) {
            current = current.add(vector);
            if (current.x < max) {
                max = current.x;
            }
        }
        return max;
    }

    public double minY() {
        double min = pos.y;
        Vector current = pos;
        for (Vector vector: vectors) {
            current = current.add(vector);
            if (current.y < min) {
                min = current.y;
            }
        }
        return min;
    }

    public double maxY() {
        double max = pos.y;
        Vector current = pos;
        for (Vector vector: vectors) {
            current = current.add(vector);
            if (current.y > max) {
                max = current.y;
            }
        }
        return max;
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

    public Figure instanceClone() {
        return new Figure(pos, vectors);
    }

    public Figure clone() {
        return new Figure(this);
    }

    @Override
    public String toString() {
        return "[" + "'Position = " + pos + "', 'Vectors = " + vectors + "', 'Center = " + center + "']";
    }
}
