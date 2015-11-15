package com.graphicEngine;

import com.abstractEngine.math.CurveBezier;

import java.awt.*;

public class CurveBezier2D implements GraphicsModel {

    private final CurveBezier curve;

    public CurveBezier2D(CurveBezier curve) {
        this.curve = curve;
    }

    @Override
    public void show(Graphics graphics, com.abstractEngine.math.Point posScreen, int height, int width) {

    }
}
