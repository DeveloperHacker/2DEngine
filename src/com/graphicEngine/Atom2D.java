package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.abstractEngine.physics.Atom;

import java.awt.*;

public class Atom2D extends ModelElement {

    private final Atom atom;
    private View background;

    public Atom2D(Atom atom, View background) {
        super(atom.pos(), atom.name());
        this.atom = new Atom(atom);
        this.background = background;
    }

    public Atom2D(Atom2D atom, View background) {
        super(atom.pos(), atom.atom.name());
        this.atom = atom.atom;
        this.background = background;
    }

    public Atom2D(Vector pos, Figure mask, double mass, Vector speed, boolean movable, View background, String name) {
        super(pos, name);
        atom = new Atom(pos, mask, mass, speed, movable, name);
        this.background = background;
    }

    public Atom2D(Vector pos, Figure mask, double mass, boolean movable, View background, String name) {
        super(pos, name);
        atom = new Atom(pos, mask, mass, movable, name);
        this.background = background;
    }

    public void set(View background) {
        this.background = background;
    }

    public View background() {
        return background;
    }

    public Atom getAtom() {
        return atom;
    }

    @Override
    public void drawOutline(Graphics graphics, Screen screen, Vector parentPos) {
        Vector pos = atom.pos().add(parentPos);
//        new Figure2D(atom.mask(), Color.WHITE).drawOutline(graphics, screen, getPosition);
//        graphics.setColor(Color.BLUE);
//        graphics.drawLine((int) (parentPos.x), (int) (parentPos.y), (int)(getPosition.x), (int)(getPosition.y));
        background.drawOutline(graphics, screen, pos);
    }
}
