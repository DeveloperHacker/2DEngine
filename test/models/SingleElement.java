package models;

import com.graphicEngine.Model;
import com.abstractEngine.math.Vector;
import com.graphicEngine.Atom2D;

public class SingleElement extends Model {

    private Atom2D atom;

    public SingleElement(Vector pos, Atom2D atom, String name) {
        super(pos, name);
        this.atom = atom;
        addElement(atom);
    }

    public Atom2D getAtom() {
        return atom;
    }
}
