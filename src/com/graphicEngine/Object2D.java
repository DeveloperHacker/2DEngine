package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Object2D {

    public final Object object;
    private List<Figure2D> mask;
    private Frame2D background;

    public Object2D(Object object, Color outlineColor) {
        this.object = new Object(object.pos(), object.mask(), object.mass(), object.speed(), object.name());
        mask.addAll(object.mask().stream().map(figure -> new Figure2D(figure, outlineColor)).collect(Collectors.toList()));
    }

    public Object2D(Point pos, List<Figure> mask, double mass, Vector speed, String name, Color outlineColor) {
        object = new Object(pos, mask, mass, speed, name);
        this.mask.addAll(object.mask().stream().map(figure -> new Figure2D(figure, outlineColor)).collect(Collectors.toList()));
    }

    public Object2D(Point pos, ArrayList<Figure> mask, double mass, String name, Color outlineColor) {
        object = new Object(pos, mask, mass, name);
        this.mask.addAll(object.mask().stream().map(figure -> new Figure2D(figure, outlineColor)).collect(Collectors.toList()));
    }

    public Object2D(Point pos, double mass, String name) {
        object = new Object(pos, new ArrayList<>(), mass, name);
    }

    public void set(Frame2D background) {
        this.background = background;
    }

    public Frame2D background() {
        return background;
    }

    public String name() {
        return object.name();
    }

    public void showOutline(Graphics graphics, Point posScreen, int height, int width) {
        for (Figure2D figure : mask) figure.show(graphics, posScreen, height, width);
    }

    public void show(Graphics graphics, Point posScreen, int height, int width) {
        background.show(graphics, posScreen, height, width);
    }
}
