package panels;

import com.abstractEngine.math.Ellipse;
import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.abstractEngine.physics.Atom;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Ellipse2D;
import com.graphicEngine.Frame2D;
import com.graphicEngine.Screen;
import models.Gas;
import models.SingleElement;

public class _2_AtomTestPanel extends AtomTestPanel {

    public _2_AtomTestPanel(int width, int height, String name) {
        super(new Gas(new com.abstractEngine.math.Vector(), width, height, new com.abstractEngine.math.Vector(0, 0.2), name), new Screen(new com.abstractEngine.math.Vector(), width, height));
    }

    @Override
    protected void initTest() {
        double radius = 25;
        Ellipse circle = new Ellipse(new Vector(radius, radius), radius * 2, radius * 2);
        Figure mask = circle.toFigure(20);
        Atom atom;
        Atom2D atom2D;
        Vector pos;
        int quantityBalls = 10;
        for (int i = 1; i < quantityBalls; ++i) {
            pos = new Vector(width() * i / (quantityBalls + 1) - mask.width() / 2, height() / 2);
            atom = new Atom(new Vector(), mask, 10, new Vector(), true, "ball" + i);
            atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
            addElement(new SingleElement(pos, atom2D, atom2D.getAtom().name()));
        }
        pos = new Vector(width() * quantityBalls / (quantityBalls + 1) - mask.width() / 2, height() / 2);
        atom = new Atom(new Vector(), mask, 10, new Vector(-10, 0), true, "ball" + quantityBalls);
        atom2D = new Atom2D(atom, new Frame2D(new Ellipse2D(circle, randColor())));
        addElement(new SingleElement(pos, atom2D, atom2D.getAtom().name()));
    }
}
