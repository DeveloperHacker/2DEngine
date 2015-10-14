package com.gameEngine.math;
import java.util.ArrayList;

public class Figure {
    public final Point pos;
    public final ArrayList<Vector> vectors;
    public final String name;
    public Figure(Figure figure, String name) {
        pos = figure.pos;
        vectors = new ArrayList<>(figure.vectors);
        this.name = name;
    }
    public Figure(Point pos, ArrayList<Vector> vec, String name) throws Exception {
        this.pos = pos;
        Vector sum = vec.get(0);
        for (int i = 1; i < vec.size(); ++i) sum = Vector.add(sum, vec.get(i));
        if (!sum.equals(new Vector())) throw new Exception("Figure " + name + " is not closed.");
        double direct = Vector.vectorMul(vec.get(vec.size() - 1), vec.get(0));
        for (int i = 1; i < vec.size(); ++i)
            if (0 > direct * Vector.vectorMul(vec.get(i - 1),vec.get(i)))
                throw new Exception("Figure " + name + " is not convex.");
        vectors = new ArrayList<>(vec);
        this.name = name;
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
    public static boolean intersection(Figure _1, Figure _2) {
        Vector prev = new Vector();
        for(Vector vector: _1.vectors) {
            prev = Vector.add(prev, vector);
            if(_2.isInside(new Point(_1.pos.x + prev.pos.x, _1.pos.y + prev.pos.y))) return true;
        }
        prev = new Vector();
        for(Vector vector: _2.vectors) {
            prev = Vector.add(prev, vector);
            if (_1.isInside(new Point(_2.pos.x + prev.pos.x, _2.pos.y + prev.pos.y))) return true;
        }
        return false;
    }
    @Override
    public boolean equals(java.lang.Object obj) {
        return ((Figure)obj).pos.equals(pos) && ((Figure)obj).vectors.equals(vectors);
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        final int c = 11;
        return a + b * pos.hashCode() + c * vectors.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new Figure(this, name + "Clone");
    }
    @Override
    public String toString() {
        return "[" + "'Position = " + pos + "', 'Vectors = " + vectors + "']";
    }
}
