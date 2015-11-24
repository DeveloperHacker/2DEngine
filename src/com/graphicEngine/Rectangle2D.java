package com.graphicEngine;

import com.abstractEngine.math.Rectangle;
import com.abstractEngine.math.Point;

import java.awt.Color;

public class Rectangle2D {

    Rectangle rectangle;
    Color outlineColor;

    public Rectangle2D(Point pos, double height, double width, Color outlineColor) {
        rectangle = new Rectangle(pos, height, width);
        this.outlineColor = outlineColor;
    }
}
