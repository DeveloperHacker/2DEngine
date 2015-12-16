package com.graphicEngine;

import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Frame2D implements View {

    private List<View> background;
    private double delay = 0;

    public Frame2D() {
        background = new ArrayList<>();
    }

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

    public void set(double delay) {
        this.delay = delay;
    }

    public double delay() {
        return delay;
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        for (View model : background) model.drawOutline(graphics, screen, parentPos);
    }
}
