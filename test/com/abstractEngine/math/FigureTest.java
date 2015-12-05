package com.abstractEngine.math;

import org.junit.Test;

import java.util.ArrayList;

public class FigureTest {

    @Test
    public void mainMethods() {
        boolean catchIllegalArgumentException = false;
        try {
            ArrayList<Vector> vectors = new ArrayList<>();
            vectors.add(new Vector(4, 0));
            vectors.add(new Vector(0, 4));
            vectors.add(new Vector(-4, 0));
            vectors.add(new Vector(0, -4));
            Figure _1 = new Figure(new Vector(2, 2), vectors);
            Figure _2 = new Figure(_1);
            assert (_1.equals(_2));
            assert (_1.isInside(new Vector(4, 4)));
            assert (!_1.isInside(new Vector(0, 1)));
            vectors.remove(vectors.size() - 1);
            vectors.add(new Vector(1, -1));
            vectors.add(new Vector(-1, -3));
            assert(!new Figure(new Vector(2, 2), vectors).convex());
            vectors.remove(vectors.size() - 1);
            vectors.remove(vectors.size() - 1);
            boolean check = false;
            try {
                new Figure(new Vector(2, 2), vectors);
            } catch (IllegalArgumentException exp) {
                check = true;
                System.out.println(exp.toString());
            }
            assert (check);
            assert (!_1.vectors().equals(vectors));
        } catch (IllegalArgumentException ignored) {
            catchIllegalArgumentException = true;
        }
        assert (!catchIllegalArgumentException);
    }

    @Test
    public void intersectionTest() {
        boolean catchIllegalArgumentException = false;
        try {
            ArrayList<Vector> vectors_1 = new ArrayList<>();
            vectors_1.add(new Vector(5, 2));
            vectors_1.add(new Vector(-2, 4));
            vectors_1.add(new Vector(-4, -3));
            vectors_1.add(new Vector(1, -3));
            Figure _1 = new Figure(new Vector(2, 2), vectors_1);
            ArrayList<Vector> vectors_2 = new ArrayList<>();
            vectors_2.add(new Vector(2, 1));
            vectors_2.add(new Vector(-1, 1));
            vectors_2.add(new Vector(-1, -2));
            Figure _2 = new Figure(new Vector(3, 4), vectors_2);
            assert (Figure.intersection(_1, _2));
            Figure _3 = new Figure(new Vector(5, 8), vectors_2);
            assert (Figure.intersection(_1, _3));
            Figure _4 = new Figure(new Vector(6, 8), vectors_2);
            assert (!Figure.intersection(_1, _4));
        } catch (IllegalArgumentException ignored) {
            catchIllegalArgumentException = true;
        }
        assert (!catchIllegalArgumentException);
    }
}