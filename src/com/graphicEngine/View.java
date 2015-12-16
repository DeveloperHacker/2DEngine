package com.graphicEngine;

import com.abstractEngine.math.Vector;

import java.awt.*;

public interface View {
    void drawOutline(Graphics graphics, Screen screen, Vector parentPos);
}

