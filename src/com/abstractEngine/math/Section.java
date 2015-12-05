package com.abstractEngine.math;

public class Section {
    public final Vector _1;
    public final Vector _2;

    public Section(Section section) {
        _1 = section._1;
        _2 = section._2;
    }

    public Section(Vector _1, Vector _2) throws IllegalArgumentException {
        this._1 = _1;
        this._2 = _2;
        if (_1 == _2) throw new IllegalArgumentException("Error: Section:" + this.toString());
    }

    public Section(double x_1, double y_1, double x_2, double y_2) throws IllegalArgumentException {
        _1 = new Vector(x_1, y_1);
        _2 = new Vector(x_2, y_2);
        if (_1 == _2) throw new IllegalArgumentException("Error: Section:" + this.toString());
    }

    public Line toLine() {
        return new Line(this);
    }

    public boolean isInside(Vector Vector) {
        if (new Line(this).solve(Vector) != 0) return false;
        if (_1.y != _2.y) {
            Vector up, down;
            if (_1.y > _2.y) {
                up = _1;
                down = _2;
            } else {
                up = _2;
                down = _1;
            }
            if (Vector.y > up.y || Vector.y < down.y) return false;
            if (Vector.y <= up.y && Vector.y >= down.y) return true;
        }
        if (_1.x != _2.x) {
            Vector right, left;
            if (_1.x > _2.x) {
                right = _1;
                left = _2;
            } else {
                right = _2;
                left = _1;
            }
            if (Vector.x > right.x || Vector.x < left.x) return false;
            if (Vector.x <= right.x && Vector.x >= left.x) return true;
        }
        return true;
    }

    public static boolean intersection(Section _1, Section _2) {
        Line line1 = _1.toLine();
        Line line2 = _2.toLine();
        return ((line1.solve(_2._1) * line1.solve(_2._2) < 0) && (line2.solve(_1._1) * line2.solve(_1._2) < 0))
                || (_1.isInside(_2._1) || (_1.isInside(_2._2)));
    }

    public static boolean intersection(Section _1, Line _2) {
        return (_2.solve(_1._1) * _2.solve(_1._2) < 0);
    }

    public static boolean intersection(Section _1, Figure _2) {
        return Figure.intersection(_2, _1);
    }

    public static boolean intersection(Section _1, Polyline _2) {
        return Polyline.intersection(_2, _1);
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj instanceof Section) {
            Section section = (Section) obj;
            return ((section._1.equals(_1) && section._2.equals(_2))
                    || (section._1.equals(_2) && section._2.equals(_1)));
        } else return false;
    }

    @Override
    public int hashCode() {
        int result = _1.hashCode();
        result = 31 * result + _2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "[" + _1 + _2 + "]";
    }
}
