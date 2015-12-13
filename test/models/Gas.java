package models;

import com.graphicEngine.Model;
import com.abstractEngine.ModelElement;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;

public class Gas extends Model {

    private int width;
    private int height;
    private Vector G;

    public Gas(Vector pos, int width, int height, Vector G, String name) {
        super(pos, name);
        this.width = width;
        this.height = height;
        this.G = G;
    }

    public void addElement(SingleElement element) {
        addElement(element);
    }

    @Override
    public void update() {
        final double maxSpeed = 20;
        final double yDamping = 1;
        final double xDamping = 1;
        Atom atom;
        for (ModelElement element : elements) {
            atom = ((SingleElement) element).getAtom().getAtom();
            if (atom.movable()) {
                atom.set(atom.speed().add(G));
                if (element.pos().add(atom.pos()).y <= 0) {
                    if (atom.speed().y < 0) {
                        atom.set(new Vector(atom.speed().x, -atom.speed().y).mul(xDamping));
                    }
                }
                if (element.pos().add(atom.pos()).y >= height - atom.mask().height()) {
                    if (atom.speed().y > 0) {
                        atom.set(atom.speed().rem(G));
                        atom.set(new Vector(atom.speed().x, -atom.speed().y).mul(xDamping));
                    }
                }
                if (element.pos().add(atom.pos()).x <= 0) {
                    if (atom.speed().x < 0) {
                        atom.set(new Vector(-atom.speed().x, atom.speed().y).mul(yDamping));
                    }
                }
                if (element.pos().add(atom.pos()).x >= width - atom.mask().width()) {
                    if (atom.speed().x > 0) {
                        atom.set(new Vector(-atom.speed().x, atom.speed().y).mul(yDamping));
                    }
                }
                if (atom.speed().abs() > maxSpeed) {
                    atom.set(atom.speed().mul(maxSpeed / atom.speed().abs()));
                }
            }
        }
        Atom atomI;
        Atom atomJ;
        Vector posI;
        Vector posJ;
        for (int i = 0; i < elements.size() - 1; i++) {
            for (int j = i + 1; j < elements.size(); j++) {
                atomI = ((SingleElement) elements.get(i)).getAtom().getAtom();
                posI = atomI.pos();
                atomI.moveTo(elements.get(i).pos().add(posI));
                atomJ = ((SingleElement) elements.get(j)).getAtom().getAtom();
                posJ = atomJ.pos();
                atomJ.moveTo(elements.get(j).pos().add(posJ));
                atomI.clash(atomJ, xDamping, yDamping);
                atomI.moveTo(posI);
                atomJ.moveTo(posJ);
            }
        }
        for (ModelElement element : elements) {
            atom = ((SingleElement) element).getAtom().getAtom();
            if (atom.movable()) {
                element.moveTo(element.pos().add(atom.speed()));
            }
        }
    }
}