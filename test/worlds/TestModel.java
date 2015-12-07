package worlds;

import com.abstractEngine.Model;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Screen;

public class TestModel extends Model {

    private int width;
    private int height;
    private Vector G;

    public TestModel(Vector pos, int width, int height, Vector G, String name) {
        super(pos, name);
        this.width = width;
        this.height = height;
        this.G = G;
    }

    @Override
    public void update() {
        final double maxSpeed = 20;
        final double damping = 0.98;
        Vector pos;
        for (Atom2D atom : atoms) {
            if (atom.atom.movable()) {
                atom.atom.set(atom.atom.speed().add(G));
//                if (atom.pos().y <= 0) {
//                    if (atom.speed().y() < 0)
//                        atom.setSpeed(new Vector(atom.speed().x(), -atom.speed().y())/*.mul(damping)*/);
//                }
                if (atom.atom.pos().y >= height - atom.atom.mask().height()) {
                    if (atom.atom.speed().y > 0)
                        atom.atom.set(new Vector(atom.atom.speed().x, -atom.atom.speed().y).mul(damping));
                }
                if (atom.atom.pos().x <= 0) {
                    if (atom.atom.speed().x < 0)
                        atom.atom.set(new Vector(-atom.atom.speed().x, atom.atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.atom.pos().x >= width - atom.atom.mask().width()) {
                    if (atom.atom.speed().x > 0)
                        atom.atom.set(new Vector(-atom.atom.speed().x, atom.atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.atom.speed().abs() > maxSpeed)
                    atom.atom.set(atom.atom.speed().mul(maxSpeed / atom.atom.speed().abs()));
            }
        }
        for (int i = 0; i < atoms.size() - 1; i++) {
            for (int j = i + 1; j < atoms.size(); j++) {
                atoms.get(i).atom.clash(atoms.get(j).atom, 1, 1);
            }
        }
        for (Atom2D atom : atoms) {
            if (atom.atom.movable()) {
                atom.atom.moveTo(atom.atom.pos().add(atom.atom.speed()));
            }
        }
    }
}