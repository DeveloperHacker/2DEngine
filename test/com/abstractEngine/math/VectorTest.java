package com.abstractEngine.math;

import org.junit.Test;

public class VectorTest {
    @Test
    public void mainMethods() {
        boolean catchIllegalArgumentException = false;
        try {
            Vector vector1 = new Vector(10, 6);
            Vector vector2 = new Vector(new Vector(10, 6));
            Vector vector3 = new Vector(-6, 10);
            Vector vector4 = new Vector(0, 10);
            assert (vector1.equals(vector2));
            assert (vector4.abs() == 10);
            assert (vector1.cos(vector4) <= 0.5 + Vector.EPSILON
                    && vector1.cos(vector4) >= 0.5 - Vector.EPSILON);
            assert (vector1.cos(vector3) <= 0 + Vector.EPSILON
                    && vector1.cos(vector3) >= 0 - Vector.EPSILON);
            assert (vector1.mul(vector3) == 136);
            assert (vector1.dot(vector3) == 0);
            assert (vector1.dot(vector4) == 60);
            assert (vector1.add(vector4).equals(new Vector(10, 16)));
            assert (vector1.rem(vector4).equals(new Vector(10, -4)));
            assert (vector1.add(vector3).equals(new Vector(4, 16)));
            assert (vector1.rem(vector3).equals(new Vector(16, -4)));
        } catch (IllegalArgumentException ignored) {
            catchIllegalArgumentException = true;
        }
        assert (!catchIllegalArgumentException);
    }
}
