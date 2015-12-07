package com.abstractEngine;

import com.abstractEngine.math.Vector;
import com.graphicEngine.Atom2D;
import com.graphicEngine.Screen;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Model extends ModelElement{
    protected List<Atom2D> atoms;

    public Model(Vector pos, String name) {
        super(name);
        this.atoms = new ArrayList<>();
        this.pos = pos;
    }

    public void add(Atom2D atom) {
        this.atoms.add(atom);
    }

    public void remove(Atom2D atom) {
        this.atoms.remove(atom);
    }

    public Atom2D atom(int index) {
        return atoms.get(index);
    }

    public List<Atom2D> atoms() {
        return atoms;
    }

    public void update() {
    }

    @Override
    public void show(Graphics graphics, Screen screen, Vector parentPos) {
        for (Atom2D atom : atoms) {
            atom.show(graphics, screen, parentPos.add(pos));
        }
    }
}
