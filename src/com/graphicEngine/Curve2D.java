package com.graphicEngine;

import com.abstractEngine.math.CurveBezier;

import java.awt.*;

public class Curve2D implements View {

    private final CurveBezier curve;
    private Color outlineColor;

    public Curve2D(CurveBezier curve, Color outlineColor) {
        this.curve = curve;
        this.outlineColor = outlineColor;
    }

    @Override
    public void show(Graphics graphics, com.abstractEngine.math.Vector posScreen, int height, int width) {
        new Polyline2D(curve.toPolyline(), outlineColor).show(graphics, posScreen, height, width);
    }
}
