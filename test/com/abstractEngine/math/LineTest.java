package com.abstractEngine.math;

import org.junit.Test;

public class LineTest {
    @Test
    public void mainMethods() {
        boolean catchIllegalArgumentException = false;
        try {
            Line line1 = new Line(-4, 6, 2);
            Line line2 = new Line(new Section(8, 5, 2, 1));
            Line line3 = new Line(-2, 3, 1);
            assert (line1.equals(line1));
            assert (line1.equals(line2));
            assert (line1.equals(line3));
            assert (line1.solve(new Point(6, 1)) < 0);
            assert (line1.solve(new Point(6, 1)) == line1.solve(6, 1));
            assert (Line.intersection(line1, line2));
            assert (Line.intersection(line1, new Line(new Section(5, 2, 4, 4))));
        } catch (IllegalArgumentException ignored) {
            catchIllegalArgumentException = true;
        }
        assert (!catchIllegalArgumentException);
    }
}
