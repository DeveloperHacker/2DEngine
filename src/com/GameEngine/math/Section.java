package com.gameEngine.math;

public class Section{
    public final Point _1;
    public final Point _2;
    public Section(Section section) {
        _1 = section._1;
        _2 = section._2;
    }
    public Section(Point _1, Point _2) {
        this._1 = _1;
        this._2 = _2;
    }
    public Section(double x_1, double y_1, double x_2, double y_2) {
        _1 = new Point(x_1, y_1);
        _2 = new Point(x_2, y_2);
    }
    public Line toLine() throws Exception {
        return new Line(-_2.y + _1.y, -_1.x + _2.x, _1.x*_2.y - _2.x*_1.y);
    }
    static boolean intersection(Section _1, Section _2){
        return false;
    }
    @Override
     public boolean equals(java.lang.Object obj) {
        return (((Section)obj)._1.equals(_1)) && (((Section)obj)._2.equals(_2));
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
