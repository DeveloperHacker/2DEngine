package com.gameEngine.math;

import org.junit.Test;

public class VectorTest {
    @Test
    public void mainMethods() {
        try {
            Vector vector1 = new Vector(10, 6);
            Vector vector2 = new Vector(new Point(10, 6));
            Vector vector3 = new Vector(-6, 10);
            Vector vector4 = new Vector(0, 10);
            assert (vector1.equals(vector1));
            assert (vector1.equals(vector2));
            assert (vector4.abs() == 10);
            assert (Vector.cos(vector1, vector4) <= 0.5 + Vector.EPSILON
                    && Vector.cos(vector1, vector4) >= 0.5 - Vector.EPSILON);
            assert (Vector.cos(vector1, vector3) <= 0 + Vector.EPSILON
                    && Vector.cos(vector1, vector3) >= 0 - Vector.EPSILON);
            assert (Vector.vectorMul(vector1, vector3) == 136);
            assert (Vector.scalarMul(vector1, vector3) == 0);
            assert (Vector.scalarMul(vector1, vector4) == 60);
            assert (Vector.add(vector1, vector4).equals(new Vector(10, 16)));
            assert (Vector.rem(vector1, vector4).equals(new Vector(10, -4)));
            assert (Vector.add(vector1, vector3).equals(new Vector(4, 16)));
            assert (Vector.rem(vector1, vector3).equals(new Vector(16, -4)));
        } catch (Exception ignored) {
        }
    }
}
