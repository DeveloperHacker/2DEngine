package panels;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.RightFigure;
import com.abstractEngine.math.Vector;
import com.graphicEngine.*;

import java.awt.*;
import java.awt.List;
import java.util.*;

public class _2_ViewTestPanel extends ViewTestPanel {

    public _2_ViewTestPanel(int width, int height) {
        super(new Frame2D(), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 100;
        double scale = 3;
        Color randColor = randColor();
        Color randColor2 = randColor();
        Color randColor3 = randColor();
        Figure hexagon = new RightFigure(new Vector(), 6, radius);
        java.util.List<Vector> triangleVectors = new ArrayList<>();
        java.util.List<Vector> rightFigureVectors = new RightFigure(new Vector(), 3, radius / scale).vectors();
        for (Vector vector : rightFigureVectors) {
            triangleVectors.add(vector);
            triangleVectors.add(vector);
        }
        Figure triangle = new Figure(triangleVectors);
        hexagon.moveTo(hexagon.pos().rem(new Vector(hexagon.minX(), hexagon.minY())).add(new Vector(10, 10)));
        triangle.moveTo(triangle.pos().add(hexagon.center().rem(triangle.center())));
        java.util.List<Frame2D> frames = new ArrayList<>();
        Figure temp;
        java.util.List<View> views = new ArrayList<>();
        double theta = Math.PI * 4;
        double alpha = Math.PI * 3 / 4;
        double step = 0.01;
        double end = 1;
        Vector FirstRotatePoint = new Vector(hexagon.minX(), hexagon.minY()).add(new Vector(3 * radius, 0));
        Vector SecondRotatePoint = new Vector(hexagon.minX(), hexagon.minY()).add(new Vector(3 * radius, 5 * radius));
        double t = 0;
        do {
            temp = Animation2D.transform(hexagon, triangle, t);
            temp = Animation2D.rotate(temp, temp.center(), t, theta);
            if (t <= end / 2) {
                temp = Animation2D.rotate(temp, FirstRotatePoint, t, -alpha);
                views.add(new Section2D(FirstRotatePoint, temp.center(), randColor2));
            } else {
                temp = Animation2D.rotate(temp, FirstRotatePoint, end / 2, -alpha);
                temp = Animation2D.rotate(temp, SecondRotatePoint, t - end / 2, alpha);
                views.add(new Section2D(SecondRotatePoint, temp.center(), randColor3));
            }
            views.add(new Figure2D(temp, randColor));
            frames.add(new Frame2D(views));
            views = new ArrayList<>();
            if (t >= end) {
                step = -step;
                frames.get(0).set(50);
                frames.get(frames.size() - 1).set(50);
            }
            t += step;
        } while (t > 0);
        Animation2D animation2D = new Animation2D(frames);
        add(animation2D);
    }
}
