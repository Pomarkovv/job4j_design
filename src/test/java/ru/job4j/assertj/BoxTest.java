package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 20);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube");
    }

    @Test
    void numberOfVerticesIs4() {
        Box box = new Box(4, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isNotZero()
                .isGreaterThan(0)
                .isEqualTo(4);
    }

    @Test
    void numberOfVerticesIs8() {
        Box box = new Box(8, 10);
        int rsl = box.getNumberOfVertices();
        assertThat(rsl).isNotZero()
                .isGreaterThan(0)
                .isEqualTo(8);
    }

    @Test
    void thenVertIsMinusOneWhenFalse() {
        Box box = new Box(-1, 10);
        boolean rsl = box.isExist();
        assertThat(rsl).isFalse();
    }

    @Test
    void thenVertIs4AndEdgeIs10AreaWas173() {
        Box box = new Box(4, 10);
        double ar = box.getArea();
        assertThat(ar).isEqualTo(173.2d, withPrecision(0.006d));
    }

    @Test
    void thenVertIs8AndEdgeIs10AreaWas600() {
        Box box = new Box(8, 10);
        double ar = box.getArea();
        assertThat(ar).isEqualTo(600);
    }
}