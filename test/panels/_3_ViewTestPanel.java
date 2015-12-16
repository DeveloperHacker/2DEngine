package panels;

import com.abstractEngine.math.*;
import com.abstractEngine.math.Vector;
import com.graphicEngine.*;

import java.awt.*;
import java.util.*;

public class _3_ViewTestPanel extends ViewTestPanel {

    public _3_ViewTestPanel(int width, int height) {
        super(new Frame2D(), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        add(new Line2D(new Section(new Vector(800, 100), new Vector(1000, 400)), randColor()));
        add(new Section2D(new Vector(1000, 100), new Vector(800, 400), randColor()));
        add(new Figure2D(new Ellipse(new Vector(200, 100), 300, 100).toFigure(5), randColor()));
        add(new Figure2D(new Ellipse(new Vector(200, 250), 300, 100).toFigure(10), randColor()));
        add(new Figure2D(new Ellipse(new Vector(200, 400), 300, 100).toFigure(15), randColor()));
        add(new Figure2D(new Ellipse(new Vector(200, 550), 300, 100).toFigure(20), randColor()));
        add(new Figure2D(new Ellipse(new Vector(500, 200), 100, 300).toFigure(5), randColor()));
        add(new Figure2D(new Ellipse(new Vector(650, 200), 100, 300).toFigure(10), randColor()));
        add(new Figure2D(new Ellipse(new Vector(550, 500), 100, 300).toFigure(15), randColor()));
        add(new Figure2D(new Ellipse(new Vector(700, 500), 100, 300).toFigure(20), randColor()));
    }
}
