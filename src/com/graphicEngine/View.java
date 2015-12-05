package com.graphicEngine;

import com.abstractEngine.math.Vector;

import java.awt.*;

public interface View {
    void show(Graphics graphics, Vector posScreen, int height, int width);
}
