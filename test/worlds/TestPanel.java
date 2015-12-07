package worlds;

import com.abstractEngine.Model;
import com.abstractEngine.math.*;
import com.abstractEngine.math.Rectangle;
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
    public static final int cycleTime = 10;
    protected Model model;
    protected Screen screen;
    protected int width;
    protected int height;

    public TestPanel(Model model, Screen screen) {
        this.model = model;
        this.screen = screen;
        this.width = (int)(screen.width());
        this.height = (int)(screen.height());
        paintClockListener = timeEvent -> repaint();
        paintClock = new Timer(repaintCycleTime, paintClockListener);
        paintClock.start();
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

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public static Color randColor()  {
        List<Integer> rgb = new ArrayList<>(3);
        rgb.add((int)(Math.random() * 255));
        rgb.add(0);
        rgb.add(255);
        Collections.shuffle(rgb);
        return new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        model.show(graphics, screen, new Vector());
    }
}

class _1_TestPanel extends TestPanel {

    public _1_TestPanel(int width, int height, String name) {
        super(new TestModel(new Vector(), width, height, new Vector(0, 0.2), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 25;
        Ellipse circle = new Ellipse(new Vector(radius, radius), radius * 2, radius * 2);
        Figure mask = circle.toFigure(10);
        Atom atom;
        Atom2D atom2D;
        Vector speed;
        int quantityBalls = 10;
        for (int i = 1; i < quantityBalls + 1; ++i) {
            speed = new Vector(Math.random() * 2 - 1, Math.random() * 2 - 1);
            atom = new Atom(new Vector(width() * i / (quantityBalls + 1) - mask.width() / 2, height() / 2), mask, 10, speed, true, "ball" + i);
            atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
            add(atom2D);
        }
    }

}

class _2_TestPanel extends TestPanel {

    public _2_TestPanel(int width, int height, String name) {
        super(new Model(new Vector(), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        Curve bezier;
        Polyline2D approximation;
        Polyline2D generatrix;
        Figure figure;
        Atom2D atom2D;

        bezier = new CurveBezier(new Vector(80, 0), new Vector(40, 260), new Vector(260, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        figure = approximation.polyline.close();
        atom2D = new Atom2D(new Atom(new Vector(10, 10), figure, 10, false, "bezier"), approximation);
        add(atom2D);
        atom2D = new Atom2D(new Atom(new Vector(10, 10), figure, 10, false, "bezier"), generatrix);
        add(atom2D);

        bezier = new CurveBezier(new Vector(0, 160), new Vector(80, 0), new Vector(40, 260), new Vector(260, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        figure = approximation.polyline.close();
        atom2D = new Atom2D(new Atom(new Vector(300, 10), figure, 10, false, "bezier"), approximation);
        add(atom2D);
        atom2D = new Atom2D(new Atom(new Vector(300, 10), figure, 10, false, "bezier"), generatrix);
        add(atom2D);

        bezier = new CurveBezier(new Vector(0, 170), new Vector(200, 160), new Vector(280, 0), new Vector(240, 260), new Vector(460, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        figure = approximation.polyline.close();
        atom2D = new Atom2D(new Atom(new Vector(600, 10), figure, 10, false, "bezier"), approximation);
        add(atom2D);
        atom2D = new Atom2D(new Atom(new Vector(600, 10), figure, 10, false, "bezier"), generatrix);
        add(atom2D);
    }
}

class _3_TestPanel extends TestPanel {

    public _3_TestPanel(int width, int height, String name) {
        super(new Model(new Vector(), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        List<Vector> vectors = new ArrayList<>();
        Vector vector1 = new Vector(2, 3);
        Vector vector2 = new Vector(4, 0);
        Vector vector3 = new Vector(-2, 3);
        vectors.add(vector1);
        vectors.add(vector2);
        vectors.add(vector3);
        vectors.add(vector1);
        vectors.add(vector2.minus());
        vectors.add(vector3);
        vectors.add(vector1.minus());
        vectors.add(vector2.minus());
        vectors.add(vector3.minus());
        vectors.add(vector1.minus());
        vectors.add(vector2);
        vectors.add(vector3.minus());
        Figure star;
        Vector singularPoint;
        double scale = 15;
        double theta = Math.PI;
        Figure newStar;
        List<Frame2D> frames;
        Animation2D expansion;
        Atom atom;
        Atom2D atom2D;
        double t;
        double step;

        star = new Figure(new Vector(6, 0), vectors);
        singularPoint = star.center();
        newStar = star.clone();
        newStar.scale(singularPoint, scale);
        frames = new ArrayList<>();
        t = 0;
        step = 0.01;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(star, newStar, t), randColor())));
            t += step;
        }
        expansion = new Animation2D(frames);
        atom = new Atom(new Vector(vector2.x * 1.5 * scale + 100, vector1.y * 2 * scale + 100), star, 10, false, "Expansion");
        atom2D = new Atom2D(atom, expansion);
        add(atom2D);

        star = new Figure(new Vector(6 + 10, 10), vectors);
        singularPoint = new Vector(5, 5);
        newStar = star.clone();
        newStar.scale(singularPoint, scale);
        frames = new ArrayList<>();
        t = 0;
        step = 0.01;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(star, newStar, t), randColor())));
            t += step;
        }
        expansion = new Animation2D(frames);
        atom = new Atom(new Vector(vector2.x * 4.5 * scale + 100, 100), star, 10, false, "Expansion");
        atom2D = new Atom2D(atom, expansion);
        add(atom2D);

        star = new Figure(new Vector(6, 0), vectors);
        star.scale(star.center(), scale);
        frames = new ArrayList<>();
        t = 0;
        step = 0.01;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.rotate(star, star.center(), t, theta), randColor())));
            t += step;
        }
        expansion = new Animation2D(frames);
        atom = new Atom(new Vector(vector2.x * 12 * scale + 100, vector1.y * 2 * scale + 100), star, 10, false, "Expansion");
        atom2D = new Atom2D(atom, expansion);
        add(atom2D);
    }
}