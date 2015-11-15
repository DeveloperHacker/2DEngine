package com.graphicEngine;

import com.abstractEngine.math.Point;

import java.awt.*;

public interface GraphicsModel {
    void show(Graphics graphics, Point posScreen, int height, int width);
}
