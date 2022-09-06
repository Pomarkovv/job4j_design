package ru.job4j.set;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class SimpleSetTest {

    @Test
    void whenAddNonNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
    }

    @Test
    void whenAddNull() {
        Set<Integer> set = new SimpleSet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAdd3ThenFalse() {
        Set<Integer> set = new SimpleSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        assertThat(set.add(3)).isFalse();
    }
}