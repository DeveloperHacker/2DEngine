package com.gameEngine.math;
import org.junit.Test;
import java.util.ArrayList;

public class FigureTest {

    @Test
    public void mainMethods() {
        try {
            ArrayList<Vector> vectors = new ArrayList<Vector>();
            vectors.add(new Vector(4, 0));
            vectors.add(new Vector(0, 4));
            vectors.add(new Vector(-4, 0));
            vectors.add(new Vector(0, -4));
            Figure _1 = new Figure(new Point(2, 2), vectors, "_1");
            Figure _2 = new Figure(_1, "_2");
            assert (_1.equals(_2));
            assert (_1.isInside(new Point(4, 4)));
            assert (!_1.isInside(new Point(0, 1)));
            vectors.remove(vectors.size() - 1);
            vectors.add(new Vector(1, -1));
            vectors.add(new Vector(-1, -3));
            boolean check = false;
            try {
                Figure _3 = new Figure(new Point(2, 2), vectors, "_3");
            } catch (Exception exp) { check = true; }
            assert (check);
            check = false;
            vectors.remove(vectors.size() - 1);
            vectors.remove(vectors.size() - 1);
            try {
                Figure _3 = new Figure(new Point(2, 2), vectors, "_3");
            } catch (Exception exp) { check = true; }
            assert (check);
            assert (!_1.vectors.equals(vectors));
        } catch (Exception ignored) {}
    }

    @Test
    public void intersectionTest() {
        try {
            ArrayList<Vector> vectors_1 = new ArrayList<Vector>();
            vectors_1.add(new Vector(5, 2));
            vectors_1.add(new Vector(-2, 4));
            vectors_1.add(new Vector(-4, -3));
            vectors_1.add(new Vector(1, -3));
            Figure _1 = new Figure(new Point(2, 2), vectors_1, "_1");
            ArrayList<Vector> vectors_2 = new ArrayList<Vector>();
            vectors_2.add(new Vector(2, 1));
            vectors_2.add(new Vector(-1, 1));
            vectors_2.add(new Vector(-1, -2));
            Figure _2 = new Figure(new Point(3, 4), vectors_2, "_2");
            assert(Figure.intersection(_1, _2));
            Figure _3 = new Figure(new Point(5, 8), vectors_2, "_3");
            assert(Figure.intersection(_1, _3));
            Figure _4 = new Figure(new Point(6, 8), vectors_2, "_4");
            assert(!Figure.intersection(_1, _4));
        } catch (Exception ignored) {}
    }
}