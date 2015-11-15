package com.graphicEngine;

import com.abstractEngine.math.Point;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Animation2D implements GraphicsModel {

    private List<Frame2D> frames;
    private int currentFrame;

    public Animation2D(Frame2D frame) {
        frames = new ArrayList<>();
        frames.add(frame);
        currentFrame = 0;
    }

    public Animation2D(Animation2D animation) {
        frames = new ArrayList<>(animation.frames);
        currentFrame = 0;
    }

    public Animation2D(List<Frame2D> frames) throws IllegalArgumentException {
        this.frames = new ArrayList<>(frames);
        if (frames.size() == 0) throw new IllegalArgumentException();
        currentFrame = 0;
    }

    public void set(List<Frame2D> frames) {
        this.frames = frames;
    }

    public void add(Frame2D frame) {
        frames.add(frame);
    }

    public void remove(Frame2D frame) {
        frames.remove(frame);
        if (frames.size() == 0) throw new IllegalArgumentException();
        currentFrame = 0;
    }

    public List<Frame2D> frames() {
        return new ArrayList<>(frames);
    }

    @Override
    public void show(Graphics graphics, Point posScreen, int height, int width) {
        if (frames.size() != 0) {
            frames.get(currentFrame).show(graphics, posScreen, height, width);
            ++currentFrame;
            if (currentFrame == frames.size()) currentFrame = 0;
        }
    }
}
