package worlds;

import com.abstractEngine.World;
import com.abstractEngine.math.*;
import com.abstractEngine.math.Point;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;
import com.graphicEngine.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public abstract class TestPanel extends JPanel {

    protected Timer paintClock, updateClock;
    protected ActionListener paintClockListener, updateClockListener;
    public static final Color backgroundColor = Color.BLACK;
    public static final int repaintCycleTime = 10;
    protected World2D world;
    protected int width;
    protected int height;

    public TestPanel(World world, int width, int height) {
        this.world = new World2D(world, width, height);
        this.width = width;
        this.height = height;
        paintClockListener = timeEvent -> repaint();
        paintClock = new Timer(repaintCycleTime, paintClockListener);
        paintClock.start();
        updateClockListener = timeEvent -> world.update();
        updateClock = new Timer(World2D.cycleTime, updateClockListener);
        updateClock.start();
        initTest();
    }

    protected void initTest() {
    }

    public void add(Atom2D object) {
        world.add(object);
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        world.show(graphics);
    }
}

class _1_TestPanel extends TestPanel {

    public _1_TestPanel(int width, int height) {
        super(new TestWorld(width, height), width, height);
    }

    @Override
    protected void initTest() {
        Figure circle = new RightFigure(new Point(25, 0), 16, 25);
        Atom atom;
        Atom2D atom2D;
        Color randColor;
        Vector speed;
        int quantityBalls = 15;
        for (int i = 1; i < quantityBalls; ++i) {
            speed = new Vector(Math.random() * 2 - 1, Math.random() * 2 - 1);
            atom = new Atom(new Point(width() * i / quantityBalls - circle.width() / 2, height() / 2), circle, 10, speed, true, "ball" + i);
            List<Integer> rgb = new ArrayList<>(3);
            rgb.add((int)(Math.random() * 255));
            rgb.add(0);
            rgb.add(255);
            Collections.shuffle(rgb);
            randColor = new Color(rgb.get(0), rgb.get(1), rgb.get(2));
            atom2D = new Atom2D(atom, new Frame2D(new Figure2D(circle, randColor)));
            add(atom2D);
        }
    }
}