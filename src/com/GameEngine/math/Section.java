package com.gameEngine.math;

public class Section {
    public final Point _1;
    public final Point _2;

    public Section(Section section) {
        _1 = section._1;
        _2 = section._2;
    }

    public Section(Point _1, Point _2) throws Exception {
        this._1 = _1;
        this._2 = _2;
        if (_1 == _2) throw new Exception("Error: Section:" + this.toString());
    }

    public Section(double x_1, double y_1, double x_2, double y_2) throws Exception {
        _1 = new Point(x_1, y_1);
        _2 = new Point(x_2, y_2);
        if (_1 == _2) throw new Exception("Error: Section:" + this.toString());
    }

    public Line toLine() {
        return new Line(this);
    }

    /** ToDo: персечение отрезков лежащих на одной прямой */
    public static boolean intersection(Section _1, Section _2) {
        Line line1 = _1.toLine();
        Line line2 = _2.toLine();
        return (line1.solve(_2._1) * line1.solve(_2._2) < 0) && (line2.solve(_1._1) * line2.solve(_1._2) < 0);
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
