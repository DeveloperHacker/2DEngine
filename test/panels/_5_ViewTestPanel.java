package panels;

import com.abstractEngine.math.*;
import com.graphicEngine.Frame2D;
import com.graphicEngine.Polyline2D;
import com.graphicEngine.Screen;

import java.awt.*;

public class _5_ViewTestPanel extends ViewTestPanel {

    public _5_ViewTestPanel(int width, int height) {
        super(new Frame2D(), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        Curve nurbs;
        Polyline2D approximation;
        Polyline2D generatrix;
        Color randColor1 = randColor();
        Color randColor2 = randColor();

        nurbs = new Nurbs(new Vector(50, 250), new Vector(150, 50), new Vector(300, 300), 1, 1.0 / 2.0, 1);
        approximation = new Polyline2D(nurbs.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(nurbs.getGuidePolyline(), randColor());
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(10, 200)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(10, 200)));
        add(approximation);
        add(generatrix);

        nurbs = new Nurbs(new Vector(150, 50), new Vector(300, 300), new Vector(500, 150), 1.0 / 2.0, 1, 10);
        approximation = new Polyline2D(nurbs.toPolyline(0.01), randColor());
        generatrix = new Polyline2D(nurbs.getGuidePolyline(), randColor());
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(60, 200)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(60, 200)));
        add(approximation);
        add(generatrix);

        nurbs = new Nurbs(new Vector(50, 250), new Vector(150, 50), new Vector(300, 300), 1, 1.0 / 2.0, 1);
        approximation = new Polyline2D(nurbs.toPolyline(0.01), randColor1);
        generatrix = new Polyline2D(nurbs.getGuidePolyline(), randColor2);
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(500, 50)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(500, 50)));
        add(approximation);
        add(generatrix);

        nurbs = new Nurbs(new Vector(150, 50), new Vector(300, 300), new Vector(500, 150), 1.0 / 2.0, 1, 10);
        approximation = new Polyline2D(nurbs.toPolyline(0.01), randColor1);
        generatrix = new Polyline2D(nurbs.getGuidePolyline(), randColor2);
        approximation.polyline.moveTo(approximation.polyline.pos().add(new Vector(500, 50)));
        generatrix.polyline.moveTo(generatrix.polyline.pos().add(new Vector(500, 50)));
        add(approximation);
        add(generatrix);
    }
}
