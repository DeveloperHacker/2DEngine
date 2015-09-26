package com.GameEngine;

public class Section{
    public final Point _1;
    public final Point _2;
    public Section(Point _1, Point _2) {
        this._1 = _1;
        this._2 = _2;
    }
    public Section(double x_1, double y_1, double x_2, double y_2) {
        _1 = new Point(x_1, y_1);
        _2 = new Point(x_2, y_2);
    }
    public Line toLine() {
        return new Line(-_2.y + _1.y, -_1.x + _2.x, _1.x*_2.y - _2.x*_1.y);
    }
    static boolean intersection(Section _1, Section _2){
        return false;
    }
}
