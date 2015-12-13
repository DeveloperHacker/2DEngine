package panels;

import com.abstractEngine.math.Curve;
import com.abstractEngine.math.CurveBezier;
import com.abstractEngine.math.Vector;
import com.graphicEngine.Frame2D;
import com.graphicEngine.Polyline2D;
import com.graphicEngine.Screen;

public class _1_ViewTestPanel extends ViewTestPanel {

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
