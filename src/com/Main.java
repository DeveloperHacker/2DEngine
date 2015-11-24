package com;

import com.abstractEngine.math.*;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;
import com.graphicEngine.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Main extends JFrame {
    private EditorPanel editorPanel;

    public Main(String name) {
        super(name);
        setBounds(10, 10, World2D.WIDTH, World2D.HEIGHT + 30);
        setResizable(false);

        editorPanel = new EditorPanel();
        editorPanel.setBackground(EditorPanel.backgroundColor);
        this.add(editorPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initTest1();
//        initTest2();
//        initTest3();
    }

    public void initTest1() {
        Figure rectangle = new Rectangle2D(new Point(0, 0), 50, 50, Color.BLACK).figure;
        Figure rectangle1 = new Rectangle2D(new Point(0, 0), 50, 50, Color.BLACK).figure;
        Object2D object1 = new Object2D(new Object(new Point(World2D.WIDTH / 2 + 200, 275),
                rectangle, 10, new Vector(-10, 0), true, "1"), Color.BLACK);
        Object2D object2 = new Object2D(new Object(new Point(World2D.WIDTH / 2 - 200, 300),
                rectangle1, 10, new Vector(10, 0), true, "2"), Color.BLACK);
        Object2D object3 = new Object2D(new Object(new Point(World2D.WIDTH / 2, 300),
                rectangle, 10, new Vector(0, 0), true, "3"), Color.BLACK);
        object1.set(new Frame2D(new Figure2D(rectangle, Color.BLUE)));
        object2.set(new Frame2D(new Figure2D(rectangle1, Color.GREEN)));
        object3.set(new Frame2D(new Figure2D(rectangle, Color.RED)));
        editorPanel.add(object1);
        editorPanel.add(object2);
//        editorPanel.add(object3);
    }

    private void initTest2() {
        Figure rectangle = new Rectangle2D(new Point(0, 0), 50, 50, Color.BLACK).figure;
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1.5, 2.5).mul(40));
        vectors.add(new Vector(1.5, 2.5).mul(40));
        vectors.add(new Vector(-3, 0).mul(40));
        vectors.add(new Vector(-3, 0).mul(40));
        vectors.add(new Vector(1.5, -2.5).mul(40));
        vectors.add(new Vector(1.5, -2.5).mul(40));
        Figure triangle = new Figure(new Point(0, 0), vectors);
        vectors.clear();
        vectors.add(new Vector(3, 0).mul(40));
        vectors.add(new Vector(-1.5, 2.5).mul(40));
        vectors.add(new Vector(-1.5, 2.5).mul(40));
        vectors.add(new Vector(-1.5, -2.5).mul(40));
        vectors.add(new Vector(-1.5, -2.5).mul(40));
        vectors.add(new Vector(3, 0).mul(40));
        Figure invertedTriangle = new Figure(new Point(0, 40), vectors);
        List<Frame2D> frames = new ArrayList<>();
        double t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, invertedTriangle, t), Color.BLACK)));
            t += 0.01;
        }
        t = 1;
        while (t > 0) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, invertedTriangle, t), Color.BLACK)));
            t -= 0.01;
        }
        Animation2D animation = new Animation2D(frames);
        Object2D object = new Object2D(new Point(300, 150), invertedTriangle, 10, true, "triangle", Color.BLACK);
        object.set(animation);
        editorPanel.add(object);
    }

    private void initTest3() {
        Figure rectangle = new Rectangle2D(new Point(0, 0), 50, 50, Color.BLACK).figure;
        List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(-6, 0).mul(40));
        Figure triangle = new Figure(new Point(0, 0), vectors);
        vectors.clear();
        vectors.add(new Vector(0.1875, 1.75).mul(40));
        vectors.add(new Vector(0.75 - 0.1875, 3 - 1.75).mul(40));
        vectors.add(new Vector(1.6875 - 0.75, 3.75 - 3).mul(40));
        vectors.add(new Vector(3 - 1.6875, 4 - 3.75).mul(40));
        vectors.add(new Vector(4.3125 - 3, 3.75 - 4).mul(40));
        vectors.add(new Vector(5.25 - 4.3125, 3 - 3.75).mul(40));
        vectors.add(new Vector(5.8125 - 5.25, 1.75 - 3).mul(40));
        vectors.add(new Vector(6 - 5.8125, -1.75).mul(40));
        vectors.add(new Vector(-6, 0).mul(40));
        Figure invertedTriangle = new Figure(new Point(0, 0), vectors);
        List<Frame2D> frames = new ArrayList<>();
        double t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, invertedTriangle, t), Color.BLACK)));
            t += 0.01;
        }
        t = 1;
        while (t > 0) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, invertedTriangle, t), Color.BLACK)));
            t -= 0.01;
        }
        Animation2D animation = new Animation2D(frames);
        Object2D object = new Object2D(new Point(550, 150), rectangle, 10, false, "triangle", Color.BLACK);
        object.set(animation);
        editorPanel.add(object);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main("Main"));
    }
}

class EditorPanel extends JPanel {
    private World2D world = new World2D();
    private Timer paintClock, updateClock;
    private ActionListener paintClockListener, updateClockListener;
    public static final Color backgroundColor = Color.WHITE;
    public static final int repaintCycleTime = 15;

    public EditorPanel() {
        super();
        paintClockListener = timeEvent -> repaint();
        paintClock = new Timer(repaintCycleTime, paintClockListener);
        paintClock.start();
        updateClockListener = timeEvent -> world.update();
        updateClock = new Timer(world.cycleTime, updateClockListener);
        updateClock.start();
    }

    public World2D getWorld() {
        return world;
    }

    public void add(Object2D object) {
        world.add(object);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        world.show(graphics);
    }
}