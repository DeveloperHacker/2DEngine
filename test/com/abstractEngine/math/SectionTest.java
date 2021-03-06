package com.abstractEngine.math;

import org.junit.Test;

public class SectionTest {
    @Test
    public void mainMethods() {
        boolean catchIllegalArgumentException = false;
        try {
            Section section1 = new Section(2, 1, 8, 5);
            Section section2 = new Section(new Vector(2, 1), new Vector(8, 5));
            Section section3 = new Section(section1);
            assert (section1.equals(section2));
            assert (section1.equals(section3));
            assert (Section.intersection(section1, section2));
            Section section4 = new Section(5, 2, 4, 4);
            Section section5 = new Section(7, 3, 7, 3);
            assert (Section.intersection(section1, section4));
            assert (!Section.intersection(section1, section5));
        } catch (IllegalArgumentException ignored) {
            catchIllegalArgumentException = true;
        }
        assert (!catchIllegalArgumentException);
    }
}
