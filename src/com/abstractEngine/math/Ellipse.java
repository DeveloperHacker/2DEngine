package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

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

    public Figure toFigure(Integer quantityVertex) {
        return new Figure(pos().add(new Point(0, -height / 2)), generateOutline(quantityVertex));
    }

    private List<Vector> generateOutline(Integer quantityVertex) {
        List<Vector> vectors = new ArrayList<>();
        double a = height / 2;
        double b = width / 2;
        double tg, ctg;
        double beta;
        Vector prevRadius = new Vector(0, -a);
        Vector nextRadius;
        Vector generatrix;
        for(int i = 0; i < quantityVertex; ++i) {
            beta = (i + 1) * Math.PI * 2 / quantityVertex;
            tg = Math.tan(beta);
            ctg = 1 / tg;
            generatrix = new Vector(-a * b / Math.sqrt(a * a * tg * tg + b * b),
                    a * b / Math.sqrt(a * a + b * b * ctg * ctg));
            nextRadius = prevRadius.rotate(Math.PI * 2 / quantityVertex);
            nextRadius = nextRadius.mul(1/nextRadius.abs()).mul(generatrix.abs());
            vectors.add(nextRadius.rem(prevRadius));
            prevRadius = nextRadius;
        }
        return vectors;
    }
}
