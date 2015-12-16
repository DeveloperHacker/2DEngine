package com.abstractEngine.math;

public class Circle extends Ellipse {

    public Circle(Vector pos, double radius) {
        super(pos, radius, radius);
    }

    public double getRadius() {
        return getHeight();
    }

    @Override
    public Figure toFigure(int quantityVertex) {
        return new RightFigure(getPosition().add(new Vector(0, -getHeight() / 2)), quantityVertex, getHeight());
    }
}
