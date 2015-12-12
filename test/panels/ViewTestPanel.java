package panels;

import com.abstractEngine.math.*;
import com.abstractEngine.math.Vector;
import com.graphicEngine.*;

import java.awt.*;
import java.util.*;
import java.util.List;

abstract class ViewTestPanel extends TestPanel {
    protected Frame2D frame2D;

    public ViewTestPanel(Frame2D frame2D, Screen screen) {
        super(screen);
        this.frame2D = frame2D;

        initTest();
    }

    protected void initTest() {
    }

    public void add(View view) {
        frame2D.add(view);
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
        frame2D.show(graphics, screen, new com.abstractEngine.math.Vector());
    }
}

class _1_ViewTestPanel extends ViewTestPanel {

    public _1_ViewTestPanel(int width, int height) {
        super(new Frame2D(), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        Curve bezier;
        Polyline2D approximation;
        Polyline2D generatrix;

        bezier = new CurveBezier(new Vector(80, 0), new Vector(40, 260), new Vector(260, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(10, 200)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(10, 200)));
        add(approximation);
        add(generatrix);

        bezier = new CurveBezier(new Vector(0, 160), new Vector(80, 0), new Vector(40, 260), new Vector(260, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(300, 200)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(300, 200)));
        add(approximation);
        add(generatrix);

        bezier = new CurveBezier(new Vector(0, 170), new Vector(200, 160), new Vector(280, 0), new Vector(240, 260), new Vector(460, 220));
        approximation = new Polyline2D(bezier.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(bezier.generatrix(), randColor());
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(600, 200)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(600, 200)));
        add(approximation);
        add(generatrix);
    }
}

class _2_ViewTestPanel extends ViewTestPanel {

    public _2_ViewTestPanel(int width, int height) {
        super(new Frame2D(), new Screen(new Vector(), width, height));
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
        double t;
        double step;

        star = new Figure(new Vector(100, 300), vectors);
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
        add(expansion);

        star = new Figure(new Vector(300, 10), vectors);
        singularPoint = new Vector(300, 10);
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
        add(expansion);

        star = new Figure(new Vector(600, 200), vectors);
        star.scale(star.center(), scale);
        frames = new ArrayList<>();
        t = 0;
        step = 0.01;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.rotate(star, star.center(), t, theta), randColor())));
            t += step;
        }
        expansion = new Animation2D(frames);
        add(expansion);

        star = new Figure(new Vector(800, 400), vectors);
        star.scale(star.pos(), scale);
        frames = new ArrayList<>();
        t = 0;
        step = 0.005;
        theta = Math.PI * 2;
        while (t <= 1) {
            frames.add(new Frame2D(new Figure2D(Animation2D.rotate(star, star.center(), t, theta), randColor())));
            t += step;
        }
        expansion = new Animation2D(frames);
        add(expansion);
    }
}