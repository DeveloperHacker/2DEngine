package com.abstractEngine.math;

import java.util.ArrayList;
import java.util.List;

public class RightFigure extends Figure {

    public RightFigure(RightFigure figure) {
        super(figure.pos(), figure.vectors());
    }

    public RightFigure(Vector pos, int quantityVertex, double radius, double alpha) {
        super(pos, generateOutline(quantityVertex, radius, alpha));
    }

    public RightFigure(Vector pos, int quantityVertex, double radius) {
        super(pos, generateOutline(quantityVertex, radius, 0));
    }

    private static List<Vector> generateOutline(int quantityVertex, double radius, double alpha) {
        List<Vector> vectors = new ArrayList<>();
        Vector prevRadius = new Vector(0, - radius).rotate(alpha);
        Vector nextRadius;
        for(int i = 0; i < quantityVertex; ++i) {
            nextRadius = prevRadius.rotate(Math.PI * 2 / quantityVertex);
            vectors.add(nextRadius.rem(prevRadius));
            prevRadius = nextRadius;
        }
        return vectors;
    }
}
