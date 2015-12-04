package worlds;

import com.abstractEngine.World;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;

public class TestWorld extends World {

    private int width;
    private int height;

    public TestWorld(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        final Vector G = new Vector(0, 0.2);
        final double maxSpeed = 20;
        final double damping = 0.98;
        for (Atom atom : atoms) {
            if (atom.movable()) {
                atom.set(atom.speed().add(G));
                if (atom.pos().y <= 0) {
//                    if (atom.speed().y() < 0)
//                        atom.setSpeed(new Vector(atom.speed().x(), -atom.speed().y())/*.mul(damping)*/);
                }
                if (atom.pos().y >= height - atom.mask().height()) {
                    if (atom.speed().y > 0)
                        atom.set(new Vector(atom.speed().x, -atom.speed().y).mul(damping));
                }
                if (atom.pos().x <= 0) {
                    if (atom.speed().x < 0)
                        atom.set(new Vector(-atom.speed().x, atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.pos().x >= width - atom.mask().width()) {
                    if (atom.speed().x > 0)
                        atom.set(new Vector(-atom.speed().x, atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.speed().abs() > maxSpeed)
                    atom.set(atom.speed().mul(maxSpeed / atom.speed().abs()));
            }
        }
        for (int i = 0; i < atoms.size() - 1; i++) {
            for (int j = i + 1; j < atoms.size(); j++) {
                atoms.get(i).clash(atoms.get(j), 1, 1);
            }
        }
        for (Atom atom : atoms) {
            if (atom.movable()) {
                atom.set(atom.pos().add(atom.speed()));
            }
        }
    }
}


class TestWorldWeightlessness extends World {

    private int width;
    private int height;

    public TestWorldWeightlessness(int width, int height) {
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public void update() {
        final Vector G = new Vector(0, 0.2);
        final double maxSpeed = 20;
        final double damping = 0.9;
        for (Atom atom : atoms) {
            if (atom.movable()) {
//                atom.setSpeed(Vector.add(atom.speed(), G));
                if (atom.pos().y <= 0) {
//                    if (atom.speed().y() < 0)
//                        atom.setSpeed(new Vector(atom.speed().x(), -atom.speed().y())/*.mul(damping)*/);
                }
                if (atom.pos().y >= height - atom.mask().height()) {
                    if (atom.speed().y > 0)
                        atom.set(new Vector(atom.speed().x, -atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.pos().x <= 0) {
                    if (atom.speed().x < 0)
                        atom.set(new Vector(-atom.speed().x, atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.pos().x >= width - atom.mask().width()) {
                    if (atom.speed().x > 0)
                        atom.set(new Vector(-atom.speed().x, atom.speed().y)/*.mul(damping)*/);
                }
                if (atom.speed().abs() > maxSpeed)
                    atom.set(atom.speed().mul(maxSpeed / atom.speed().abs()));
            }
        }
        for (int i = 0; i < atoms.size() - 1; i++) {
            for (int j = i + 1; j < atoms.size(); j++) {
                atoms.get(i).clash(atoms.get(j), 1, 1);
            }
        }
        for (Atom atom : atoms) {
            if (atom.movable()) {
                atom.set(atom.pos().add(atom.speed()));
            }
        }
    }
}

