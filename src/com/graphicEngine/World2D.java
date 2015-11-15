package com.graphicEngine;

import com.abstractEngine.World;
import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class World2D {

    public final World world;

    private Figure screen;
    public static final int SCALE = 70;
    public static final int WIDTH = 16 * SCALE;
    public static final int HEIGHT = 9 * SCALE;

    public static final int cycleTime = 10;

    {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(WIDTH, 0));
        vectors.add(new Vector(0, HEIGHT));
        vectors.add(new Vector(-WIDTH, 0));
        vectors.add(new Vector(0, -HEIGHT));
        screen = new Figure(new Point(0, 0), vectors);
    }

    public World2D() {
        world = new World();
    }

    public void show(Graphics graphics) {

    }

    public void update() {
        world.update();
    }
}
