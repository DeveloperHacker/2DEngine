package com.graphicEngine;

import com.abstractEngine.math.Point;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Frame2D implements View {

    private List<View> background;

    public Frame2D(Frame2D frame) {
        background = new ArrayList<>(frame.background);
    }

    public Frame2D(List<View> models) {
        background = new ArrayList<>(models);
    }

    public Frame2D(View model) {
        background = new ArrayList<>();
        background.add(model);
    }

    public List<View> background() {
        return new ArrayList<>(background);
    }

    public void add(View model) {
        background.add(model);
    }

    @Override
    public void show(Graphics graphics, Point posScreen, int height, int width) {
        for (View model : background) model.show(graphics, posScreen, height, width);
    }
}
