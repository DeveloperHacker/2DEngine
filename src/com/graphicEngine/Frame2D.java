package com.graphicEngine;

import com.abstractEngine.math.Point;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Frame2D implements GraphicsModel {

    private List<GraphicsModel> background;

    public Frame2D(Frame2D frame) {
        background = new ArrayList<>(frame.background);
    }

    public Frame2D(List<GraphicsModel> models) {
        background = new ArrayList<>(models);
    }

    public Frame2D(GraphicsModel model) {
        background = new ArrayList<>();
        background.add(model);
    }

    public List<GraphicsModel> background() {
        return new ArrayList<>(background);
    }

    public void add(GraphicsModel model) {
        background.add(model);
    }

    @Override
    public void show(Graphics graphics, Point posScreen, int height, int width) {
        for (GraphicsModel model : background) model.show(graphics, posScreen, height, width);
    }
}
