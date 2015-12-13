package panels;

import com.abstractEngine.math.Ellipse;
import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Ellipse2D;
import com.graphicEngine.Frame2D;
import com.graphicEngine.Screen;
import models.Gas;
import models.SingleElement;

public class _1_AtomTestPanel extends AtomTestPanel {

    public _1_AtomTestPanel(int width, int height, String name) {
        super(new Gas(new Vector(), width, height, new Vector(0, 0.2), name), new Screen(new Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 1;
        double mass;
        Ellipse circle = new Ellipse(new Vector(radius / 2, radius / 2), radius, radius);
        Ellipse temp;
        Figure mask;
        Atom atom;
        Atom2D atom2D;
        Vector speed;
        Vector pos;
        int quantityBalls = 5;
        for (int i = 1; i < quantityBalls + 1; ++i) {
            mass  = Math.random() * 90 + 10;
            temp = new Ellipse(circle);
            temp.scale(mass);
            mask = temp.toFigure(20);
            speed = new Vector(Math.random() * 2 - 1, Math.random() * 2 - 1);
            pos = new Vector(width() * i / (quantityBalls + 1) - mask.width() / 2, height() / 2);
            atom = new Atom(new Vector(), mask, mass, speed, true, "ball" + i);
            atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(temp, randColor())));
            addElement(new SingleElement(pos, atom2D, atom2D.getAtom().name()));
        }
    }
}
