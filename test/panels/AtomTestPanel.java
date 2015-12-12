package panels;

import com.abstractEngine.Model;
import com.abstractEngine.math.*;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;
import com.graphicEngine.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class AtomTestPanel extends TestPanel {


    protected Timer updateClock;
    protected ActionListener updateClockListener;
    public static final int cycleTime = 10;
    protected Model model;

    public AtomTestPanel(Model model, Screen screen) {
        super(screen);
        this.model = model;

        updateClockListener = timeEvent -> model.update();
        updateClock = new Timer(cycleTime, updateClockListener);
        updateClock.start();

        initTest();
    }

    protected void initTest() {
    }

    public void add(Atom2D atom2D) {
        model.add(atom2D);
    }

    public static Color randColor() {
        java.util.List<Integer> rgb = new ArrayList<>(3);
        rgb.add((int) (Math.random() * 255));
        rgb.add(0);
        rgb.add(255);
        Collections.shuffle(rgb);
        return new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        model.show(graphics, screen, new com.abstractEngine.math.Vector());
    }
}

class _1_AtomTestPanel extends AtomTestPanel {

    public _1_AtomTestPanel(int width, int height, String name) {
        super(new TestModel(new Vector(), width, height, new Vector(0, 0.2), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 25;
        Ellipse circle = new Ellipse(new com.abstractEngine.math.Vector(radius, radius), radius * 2, radius * 2);
        Figure mask = circle.toFigure(10);
        Atom atom;
        Atom2D atom2D;
        com.abstractEngine.math.Vector speed;
        int quantityBalls = 10;
        for (int i = 1; i < quantityBalls + 1; ++i) {
            speed = new com.abstractEngine.math.Vector(Math.random() * 2 - 1, Math.random() * 2 - 1);
            atom = new Atom(new com.abstractEngine.math.Vector(width() * i / (quantityBalls + 1) - mask.width() / 2, height() / 2), mask, 10, speed, true, "ball" + i);
            atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
            add(atom2D);
        }
    }
}

class _2_AtomTestPanel extends AtomTestPanel {

    public _2_AtomTestPanel(int width, int height, String name) {
        super(new TestModel(new com.abstractEngine.math.Vector(), width, height, new com.abstractEngine.math.Vector(0, 0.2), name), new Screen(new com.abstractEngine.math.Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 25;
        Ellipse circle = new Ellipse(new com.abstractEngine.math.Vector(radius, radius), radius * 2, radius * 2);
        Figure mask = circle.toFigure(10);
        Atom atom;
        Atom2D atom2D;
        com.abstractEngine.math.Vector speed;
        int quantityBalls = 10;
        for (int i = 1; i < quantityBalls; ++i) {
            atom = new Atom(new Vector(width() * i / (quantityBalls + 1) - mask.width() / 2, height() / 2),
                    mask, 10, new Vector(), true, "ball" + i);
            atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
            add(atom2D);
        }

        atom = new Atom(new Vector(width() * quantityBalls / (quantityBalls + 1) - mask.width() / 2, height() / 2),
                mask, 10, new Vector(-10, 0), true, "ball" + quantityBalls);
        atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
        add(atom2D);
    }
}