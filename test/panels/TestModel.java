package panels;

import com.abstractEngine.Model;
import com.abstractEngine.math.Vector;
import com.graphicEngine.Atom2D;

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
        final double yDamping = 1;
        final double xDamping = 1;
        Vector pos;
        for (Atom2D atom : atoms) {
            if (atom.atom.movable()) {
                atom.atom.set(atom.atom.speed().add(G));
                if (atom.atom.pos().y <= 0) {
                    if (atom.atom.speed().y < 0) {
                        atom.atom.set(new Vector(atom.atom.speed().x, -atom.atom.speed().y).mul(xDamping));
                    }
                }
                if (atom.atom.pos().y >= height - atom.atom.mask().height()) {
                    if (atom.atom.speed().y > 0) {
                        atom.atom.set(atom.atom.speed().rem(G));
                        atom.atom.set(new Vector(atom.atom.speed().x, -atom.atom.speed().y).mul(xDamping));
                    }
                }
                if (atom.atom.pos().x <= 0) {
                    if (atom.atom.speed().x < 0) {
                        atom.atom.set(new Vector(-atom.atom.speed().x, atom.atom.speed().y)/*.mul(xDamping)*/);
                    }
                }
                if (atom.atom.pos().x >= width - atom.atom.mask().width()) {
                    if (atom.atom.speed().x > 0) {
                        atom.atom.set(new Vector(-atom.atom.speed().x, atom.atom.speed().y)/*.mul(xDamping)*/);
                    }
                }
                if (atom.atom.speed().abs() > maxSpeed)
                    atom.atom.set(atom.atom.speed().mul(maxSpeed / atom.atom.speed().abs()));
            }
        }
        for (int i = 0; i < atoms.size() - 1; i++) {
            for (int j = i + 1; j < atoms.size(); j++) {
                atoms.get(i).atom.clash(atoms.get(j).atom, xDamping, yDamping);
            }
        }
        for (Atom2D atom : atoms) {
            if (atom.atom.movable()) {
                atom.atom.moveTo(atom.atom.pos().add(atom.atom.speed()));
            }
        }
    }
}