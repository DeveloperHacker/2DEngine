package com.abstractEngine;

import com.abstractEngine.object.Atom;

import java.util.ArrayList;
import java.util.List;

public class World {
    protected List<Atom> atoms;

    public World() {
        atoms = new ArrayList<>();
    }

    public void add(Atom atom) {
        atoms.add(atom);
    }

    public void remove(Atom atom) {
        atoms.remove(atom);
    }

    public void update() {
    }
}
