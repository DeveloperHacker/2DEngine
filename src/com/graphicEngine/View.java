package com.graphicEngine;

import com.abstractEngine.math.Point;

import java.awt.*;

public interface View {
    void show(Graphics graphics, Point posScreen, int height, int width);
}
