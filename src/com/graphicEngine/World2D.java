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
    public List<Object2D> objects;

    private Figure screen;
    public final int width;
    public final int height;

    public static final int cycleTime = 10;

    private void initScreen() {
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(width, 0));
        vectors.add(new Vector(0, height));
        vectors.add(new Vector(-width, 0));
        vectors.add(new Vector(0, -height));
        screen = new Figure(new Point(0, 0), vectors);
        objects = new ArrayList<>();
    }

    public World2D(World world, int width, int height) {
        initScreen();
        this.world = world;
        this.width = width;
        this.height = height;
    }

    public void add(Object2D object) {
        objects.add(object);
        world.add(object.object);
    }

    public void show(Graphics graphics) {
        for (Object2D object : objects) {
            object.show(graphics, screen.pos(), height, width);
        }
    }

    public void update() {
        world.update();
    }
}
