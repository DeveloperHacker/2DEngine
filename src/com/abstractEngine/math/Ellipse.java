package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class Ellipse {
    private Vector pos;
    private double height;
    private double width;

    public Ellipse(Ellipse ellipse) {
        this.pos = ellipse.pos;
        this.height = ellipse.height;
        this.width = ellipse.width;
    }

    public Ellipse(Vector pos, double width, double height) {
        this.pos = pos;
        this.height = height;
        this.width = width;
    }

    public Ellipse(Rectangle rectangle) {
        this.pos = rectangle.center();
        this.height = rectangle.height();
        this.width = rectangle.width();
    }

    public Vector getPosition() {
        return pos;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void scale(double scale) {
        pos = pos.scale(scale);
        height *= scale;
        width *= scale;
    }

    public Figure toFigure(int quantityVertex) {
        return new Figure(getPosition().add(new Vector(0, -height / 2)), generateOutline(quantityVertex));
    }

    private List<Vector> generateOutline(int quantityVertex) {
        double radius = Math.max(width, height) / 2;
        boolean horizontal = (width > height);
        List<Vector> vectors = new RightFigure(new Vector(), quantityVertex, radius).vectors();
        Vector currentVector;
        if (horizontal) {
            for (int i = 0; i < vectors.size(); ++i) {
                currentVector = vectors.get(i);
                vectors.set(i, new Vector(currentVector.x, currentVector.y * height / width));
            }
        } else {
            for (int i = 0; i < vectors.size(); ++i) {
                currentVector = vectors.get(i);
                vectors.set(i, new Vector(currentVector.x * width / height, currentVector.y));
            }
        }
        return vectors;
    }
}
