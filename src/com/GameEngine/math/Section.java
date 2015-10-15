package com.gameEngine.math;

public class Section{
    public final Point _1;
    public final Point _2;
    public Section(Section section) {
        _1 = section._1;
        _2 = section._2;
    }
    public Section(Point _1, Point _2) throws Exception {
        this._1 = _1;
        this._2 = _2;
        if(_1 == _2) throw new Exception("Error: Section:" + this.toString());
    }
    public Section(double x_1, double y_1, double x_2, double y_2) throws Exception {
        _1 = new Point(x_1, y_1);
        _2 = new Point(x_2, y_2);
        if(_1 == _2) throw new Exception("Error: Section:" + this.toString());
    }
    public Line toLine() {
        return new Line(this);
    }
    public static boolean intersection(Section _1, Section _2){
        Line line = _1.toLine();
        if (line.solve(_2._1)*line.solve(_2._2) >= 0) return false;
        line = _2.toLine();
        if (line.solve(_1._1)*line.solve(_1._2) >= 0) return false;
        return true;
    }
    @Override
     public boolean equals(java.lang.Object obj) {
        if (this == obj) return true;
        if (obj instanceof Figure) {
            Section section = (Section)obj;
            if (!section._1.equals(_1)) return false;
            if (!section._2.equals(_2)) return false;
            return true;
        }
        else return false;
    }
    @Override
    public int hashCode() {
        final int a = 5;
        final int b = 7;
        final int c = 11;
        return a + b * _1.hashCode() + c * _2.hashCode();
    }
    @Override
    public java.lang.Object clone() {
        return new Section(this);
    }
    @Override
    public String toString() {
        return "[" + _1 + _2 + "]";
    }
}
