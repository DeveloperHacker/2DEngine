package com.graphicEngine;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;
import com.abstractEngine.object.Atom;

import java.awt.*;

public class Atom2D implements View {

    public final Atom atom;
    private View background;

    public Atom2D(Atom atom, View background) {
        this.atom = new Atom(atom);
        this.background = background;
    }

    public Atom2D(Atom2D object, View background) {
        this.atom =  object.atom;
        this.background = background;
    }

    public Atom2D(Vector pos, Figure mask, double mass, Vector speed, boolean movable, String name, View background) {
        atom = new Atom(pos, mask, mass, speed, movable, name);
        this.background = background;
    }

    public Atom2D(Vector pos, Figure mask, double mass, boolean movable, String name, View background) {
        atom = new Atom(pos, mask, mass, movable, name);
        this.background = background;
    }

    public void set(View background) {
        this.background = background;
    }

    public View background() {
        return background;
    }

    public String name() {
        return atom.name();
    }

    @Override
    public void show(Graphics graphics, Vector posScreen, int height, int width) {
        background.show(graphics, atom.pos().rem(posScreen), height, width);
        new Figure2D(atom.mask(), Color.WHITE).show(graphics, atom.pos().rem(posScreen), height, width);
//        graphics.setColor(Color.BLUE);
//        graphics.drawLine(0, 0, (int)(atom.pos().rem(posScreen).x), (int)(atom.pos().rem(posScreen).y));
    }
}
