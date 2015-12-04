package com.abstractEngine.math;

public class Ellipse {
    private Point pos;
    private double height;
    private double width;

    public Ellipse(Ellipse ellipse) {
        this.pos = ellipse.pos;
        this.height = ellipse.height;
        this.width = ellipse.width;
    }

    public Ellipse(Point pos, double height, double width) {
        this.pos = pos;
        this.height = height;
        this.width = width;
    }

    public Ellipse(Rectangle rectangle) {
        this.pos = rectangle.center();
        this.height = rectangle.height();
        this.width = rectangle.width();
    }

    public Point pos() {
        return pos;
    }

    public double height() {
        return height;
    }

    public double width() {
        return width;
    }

//    public Figure toFigure() {
//
//    }
}
