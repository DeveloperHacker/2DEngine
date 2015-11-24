package worlds;

import com.abstractEngine.World;
import com.abstractEngine.math.*;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Object;
import com.graphicEngine.*;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class TestPanel extends JPanel {

    protected Timer paintClock, updateClock;
    protected ActionListener paintClockListener, updateClockListener;
    public static final Color backgroundColor = Color.WHITE;
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

    public void add(Object2D object) {
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
        Figure _1_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _2_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _3_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _4_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _5_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _6_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _7_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _8_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Object _1_object = new Object(new com.abstractEngine.math.Point(width() / 4 - _1_mask.width() / 2, 200), _1_mask, 10, new Vector(0, 0), true, "1");
        Object _2_object = new Object(new com.abstractEngine.math.Point(width() * 3 / 4 - _2_mask.width() / 2, 200), _2_mask, 10, new Vector(0, 0), true, "2");
        Object _3_object = new Object(new com.abstractEngine.math.Point(width() / 4 - _3_mask.width() * 3 / 2 - 1, 300), _3_mask, 10, new Vector(0, 0), true, "3");
        Object _4_object = new Object(new com.abstractEngine.math.Point(width() * 3 / 4 + _4_mask.width() / 2 + 1, 300), _4_mask, 10, new Vector(0, 0), true, "4");
        Object _5_object = new Object(new com.abstractEngine.math.Point(width() / 4 - _5_mask.width() / 2, 500), _5_mask, 10, new Vector(0, 0), false, "5");
        Object _6_object = new Object(new com.abstractEngine.math.Point(width() * 3 / 4 - _6_mask.width() / 2, 500), _6_mask, 10, new Vector(0, 0), false, "6");
        Object _7_object = new Object(new com.abstractEngine.math.Point(width() / 4 - _7_mask.width() * 3 / 2 - 1, 500 + _7_mask.height()), _7_mask, 10, new Vector(0, 0), false, "7");
        Object _8_object = new Object(new com.abstractEngine.math.Point(width() * 3 / 4 + _8_mask.width() / 2 + 1, 500 + _8_mask.height()), _8_mask, 10, new Vector(0, 0), false, "8");
        Object2D _1_object2D = new Object2D(_1_object, new Frame2D(new Figure2D(_1_mask, Color.BLUE)));
        Object2D _2_object2D = new Object2D(_2_object, new Frame2D(new Figure2D(_2_mask, Color.GREEN)));
        Object2D _3_object2D = new Object2D(_3_object, new Frame2D(new Figure2D(_3_mask, Color.RED)));
        Object2D _4_object2D = new Object2D(_4_object, new Frame2D(new Figure2D(_4_mask, Color.MAGENTA)));
        Object2D _5_object2D = new Object2D(_5_object, new Frame2D(new Figure2D(_5_mask, Color.ORANGE)));
        Object2D _6_object2D = new Object2D(_6_object, new Frame2D(new Figure2D(_6_mask, Color.YELLOW)));
        Object2D _7_object2D = new Object2D(_7_object, new Frame2D(new Figure2D(_7_mask, Color.BLACK)));
        Object2D _8_object2D = new Object2D(_8_object, new Frame2D(new Figure2D(_8_mask, Color.CYAN)));
        this.add(_1_object2D);
        this.add(_2_object2D);
        this.add(_3_object2D);
        this.add(_4_object2D);
        this.add(_5_object2D);
        this.add(_6_object2D);
        this.add(_7_object2D);
        this.add(_8_object2D);
    }
}

class _2_TestPanel extends TestPanel {

    public _2_TestPanel(int width, int height) {
        super(new World(), width, height);
    }

    @Override
    protected void initTest() {
        final int scale = 40;
        java.util.List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(1.5, 2.5).mul(scale));
        vectors.add(new Vector(1.5, 2.5).mul(scale));
        vectors.add(new Vector(-3, 0).mul(scale));
        vectors.add(new Vector(-3, 0).mul(scale));
        vectors.add(new Vector(1.5, -2.5).mul(scale));
        vectors.add(new Vector(1.5, -2.5).mul(scale));
        Figure triangle = new Figure(new com.abstractEngine.math.Point(0, 0), vectors);
        triangle.setPos(new com.abstractEngine.math.Point(triangle.width() / 2, 0));
        vectors.clear();
        vectors.add(new Vector(3, 0).mul(scale));
        vectors.add(new Vector(-1.5, 2.5).mul(scale));
        vectors.add(new Vector(-1.5, 2.5).mul(scale));
        vectors.add(new Vector(-1.5, -2.5).mul(scale));
        vectors.add(new Vector(-1.5, -2.5).mul(scale));
        vectors.add(new Vector(3, 0).mul(scale));
        Figure invertedTriangle = new Figure(new com.abstractEngine.math.Point(0, 30), vectors);
        invertedTriangle.setPos(new com.abstractEngine.math.Point(invertedTriangle.width() / 2, 0));
        java.util.List<Frame2D> frames = new ArrayList<>();
        double t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, invertedTriangle, t), Color.MAGENTA)));
            t += 0.01;
        }
        t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(invertedTriangle, triangle, t), Color.MAGENTA)));
            t += 0.01;
        }
        Animation2D animation = new Animation2D(frames);
        Figure mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), triangle.width(), triangle.height());
        Object2D object = new Object2D(new com.abstractEngine.math.Point(width() / 2 - triangle.width() / 2, height() / 2 - triangle.height() / 2), mask, 10, false, "triangle", animation);
        this.add(object);
    }
}

class _3_TestPanel extends TestPanel {

    public _3_TestPanel(int width, int height) {
        super(new World(), width, height);
    }

    @Override
    protected void initTest() {
        java.util.List<Vector> vectors = new ArrayList<>();
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, 5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(3, -5).mul(10));
        vectors.add(new Vector(-6, 0).mul(40));
        Figure triangle = new Figure(new com.abstractEngine.math.Point(0, 0), vectors);
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
        Figure figure = new Figure(new com.abstractEngine.math.Point(0, 0), vectors);
        java.util.List<Frame2D> frames = new ArrayList<>();
        double t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(triangle, figure, t), Color.RED)));
            t += 0.01;
        }
        t = 0;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.transform(figure, triangle, t), Color.RED)));
            t += 0.01;
        }
        Animation2D animation = new Animation2D(frames);
        Figure mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), triangle.width(), triangle.height());
        Object2D object = new Object2D(new com.abstractEngine.math.Point(width() / 2 - triangle.width() / 2, height() / 2 - triangle.height() / 2), mask, 10, false, "triangle", animation);
        this.add(object);
    }
}

class _4_TestPanel extends TestPanel {

    public _4_TestPanel(int width, int height) {
        super(new TestWorld(width, height), width, height);
    }

    @Override
    protected void initTest() {
        Figure _1_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _2_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _3_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _4_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _5_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _6_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _7_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Figure _8_mask = new com.abstractEngine.math.Rectangle(new com.abstractEngine.math.Point(0, 0), 50, 50);
        Object _1_object = new Object(new com.abstractEngine.math.Point(width() / 9 - _1_mask.width() / 2, height() / 2 - _1_mask.height() / 2), _1_mask, 10, new Vector(-5, 0), true, "1");
        Object _2_object = new Object(new com.abstractEngine.math.Point(width() * 2 / 9 - _2_mask.width() / 2, height() / 2 - _2_mask.height() / 2), _2_mask, 10, new Vector(0, 0), true, "2");
        Object _3_object = new Object(new com.abstractEngine.math.Point(width() * 3 / 9 - _3_mask.width() / 2, height() / 2 - _3_mask.height() / 2), _3_mask, 10, new Vector(0, 0), true, "3");
        Object _4_object = new Object(new com.abstractEngine.math.Point(width() * 4 / 9 - _4_mask.width() / 2, height() / 2 - _4_mask.height() / 2), _4_mask, 10, new Vector(0, 0), true, "4");
        Object _5_object = new Object(new com.abstractEngine.math.Point(width() * 5 / 9 - _5_mask.width() / 2, height() / 2 - _5_mask.height() / 2), _5_mask, 10, new Vector(0, 0), true, "5");
        Object _6_object = new Object(new com.abstractEngine.math.Point(width() * 6 / 9 - _6_mask.width() / 2, height() / 2 - _6_mask.height() / 2), _6_mask, 10, new Vector(0, 0), true, "6");
        Object _7_object = new Object(new com.abstractEngine.math.Point(width() * 7 / 9 - _7_mask.width() / 2, height() / 2 - _7_mask.height() / 2), _7_mask, 10, new Vector(0, 0), true, "7");
        Object _8_object = new Object(new com.abstractEngine.math.Point(width() * 8 / 9 - _8_mask.width() / 2, height() / 2 - _8_mask.height() / 2), _8_mask, 10, new Vector(0, 0), true, "8");
        Object2D _1_object2D = new Object2D(_1_object, new Frame2D(new Figure2D(_1_mask, Color.BLUE)));
        Object2D _2_object2D = new Object2D(_2_object, new Frame2D(new Figure2D(_2_mask, Color.GREEN)));
        Object2D _3_object2D = new Object2D(_3_object, new Frame2D(new Figure2D(_3_mask, Color.RED)));
        Object2D _4_object2D = new Object2D(_4_object, new Frame2D(new Figure2D(_4_mask, Color.MAGENTA)));
        Object2D _5_object2D = new Object2D(_5_object, new Frame2D(new Figure2D(_5_mask, Color.ORANGE)));
        Object2D _6_object2D = new Object2D(_6_object, new Frame2D(new Figure2D(_6_mask, Color.YELLOW)));
        Object2D _7_object2D = new Object2D(_7_object, new Frame2D(new Figure2D(_7_mask, Color.BLACK)));
        Object2D _8_object2D = new Object2D(_8_object, new Frame2D(new Figure2D(_8_mask, Color.CYAN)));
        this.add(_1_object2D);
        this.add(_2_object2D);
        this.add(_3_object2D);
        this.add(_4_object2D);
        this.add(_5_object2D);
        this.add(_6_object2D);
        this.add(_7_object2D);
        this.add(_8_object2D);
    }
}
