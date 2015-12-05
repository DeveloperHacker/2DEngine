package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Animation2D implements View {

    private List<Frame2D> frames;
    private int currentFrame = 0;
    private int delay = 0;
    private int time = 0;

    public Animation2D(Frame2D frame) {
        frames = new ArrayList<>();
        frames.add(frame);
    }

    public Animation2D(Animation2D animation) {
        frames = new ArrayList<>(animation.frames);
    }

    public Animation2D(List<Frame2D> frames) throws IllegalArgumentException {
        this.frames = new ArrayList<>(frames);
        if (frames.size() == 0) throw new IllegalArgumentException();
    }

    public void set(List<Frame2D> frames) {
        this.frames = frames;
    }

    public void set(int delay) {
        this.delay = delay;
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

    public static Figure transform(Figure _1, Figure _2, double t) throws IllegalArgumentException {
        if (_1.vectors().size() != _2.vectors().size()) throw new IllegalArgumentException();
        List<Vector> vectors1 = _1.vectors();
        List<Vector> vectors2 = _2.vectors();
        List<Vector> vectors = new ArrayList<>(vectors1.size());
        Vector prev1 = new Vector(_1.pos());
        Vector prev2 = new Vector(_2.pos());
        Vector prev = (prev1.mul(1 - t)).add(prev2.mul(t));
        for (int i = 0; i < vectors1.size(); i++) {
            prev1 = prev1.add(vectors1.get(i));
            prev2 = prev2.add(vectors2.get(i));
            vectors.add(((prev1.mul(1 - t)).add(prev2.mul(t))).rem(prev));
            prev = (prev1.mul(1 - t)).add(prev2.mul(t));
        }
        return new Figure(prev, vectors);
    }

    @Override
    public void show(Graphics graphics, Vector posScreen, int height, int width) {
        if (frames.size() != 0) {
                frames.get(currentFrame).show(graphics, posScreen, height, width);
                if (time == delay) {
                    time = -1;
                    ++currentFrame;
                    if (currentFrame == frames.size()) currentFrame = 0;
                }
                time++;
        }
    }
}
