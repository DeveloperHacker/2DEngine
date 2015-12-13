package com.abstractEngine.object;

import com.abstractEngine.math.Figure;
import com.abstractEngine.math.Vector;

public class Atom {
    private Vector pos;
    private Figure mask;
    private double mass;
    private Vector speed;
    private final boolean movable;
    private final String name;

    public Atom(Atom atom, boolean movable) {
        this(atom.pos, atom.mask, atom.mass, atom.speed, movable, atom.name);
    }

    public Atom(Atom atom) {
        this(atom.pos, atom.mask, atom.mass, atom.speed, atom.movable, atom.name);
    }

    public Atom(Vector pos, Figure mask, double mass, Vector speed, boolean movable, String name) {
        this.pos = pos;
        this.mask = mask;
        this.mass = mass;
        this.speed = speed;
        this.name = name;
        this.movable = movable;
    }

    public Atom(Vector pos, Figure mask, double mass, boolean movable, String name) {
        this(pos, mask, mass, new Vector(), movable, name);
    }

    public void set(Figure mask) {
        this.mask = mask;
    }

    public void moveTo(Vector pos) {
        this.pos = pos;
    }

    public void set(double mass) {
        this.mass = mass;
    }

    public void set(Vector speed) {
        this.speed = speed;
    }

    public Figure mask() {
        return mask;
    }

    public Vector pos() {
        return pos;
    }

    public double mass() {
        return mass;
    }

    public Vector speed() {
        return speed;
    }

    public String name() {
        return name;
    }

    public boolean movable() {
        return movable;
    }

    public boolean clash(Atom atom, double xDamping, double yDamping) {

        boolean intersection = Figure.intersection(new Figure(pos.add(mask.pos()), mask),
                new Figure(atom.pos.add(atom.mask.pos()), atom.mask));
        if (mask().convex() && atom.mask().convex()) {
            if (intersection) {
                Vector n = new Vector((mask.center().add(pos)).rem(atom.mask.center().add(atom.pos)));
                Vector i = new Vector(1, 0);
                Vector j = new Vector(0, 1);
                double cos = n.cos(i);
                double sin = n.minus().cos(j.minus());
                Vector V01 = new Vector(speed.x * cos + speed.y * sin, -speed.x * sin + speed.y * cos);
                Vector V02 = new Vector(atom.speed.x * cos + atom.speed.y * sin, -atom.speed.x * sin + atom.speed.y * cos);
                double V1y = V01.y * yDamping;
                double V2y = V02.y * yDamping;
                if (movable && atom.movable) {
                    double V1x = ((mass - atom.mass) * V01.x + 2 * atom.mass * V02.x) / (mass + atom.mass) * xDamping;
                    double V2x = (2 * mass * V01.x + (atom.mass - mass) * V02.x) / (mass() + atom.mass) * xDamping;
                    set(new Vector(V1x * cos - V1y * sin, V1x * sin + V1y * cos));
                    atom.set(new Vector(V2x * cos - V2y * sin, V2x * sin + V2y * cos));
                } else if (movable) {
                    double V1x = -V01.x * xDamping;
                    set(new Vector(V1x * cos - V1y * sin, V1x * sin + V1y * cos));
                } else if (atom.movable) {
                    double V2x = -V02.x * xDamping;
                    atom.set(new Vector(V2x * cos - V2y * sin, V2x * sin + V2y * cos));
                }
            }
        }
        return intersection;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) return true;
        if (!(o instanceof Atom)) return false;
        Atom atom = (Atom) o;
        return atom.mask.equals(mask);
    }

    @Override
    public int hashCode() {
        int result;
        result = mask.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "['Speed = " + speed + "', 'Position = " + pos + "', 'Mask = " + mask + "', 'Mass = " + mass + "']";
    }
}
