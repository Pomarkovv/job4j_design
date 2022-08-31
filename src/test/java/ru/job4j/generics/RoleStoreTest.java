package ru.job4j.generics;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RoleStoreTest {

    @Test
    void whenAddAndFindThenUsernameIsIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Role result = store.findById("1");
        assertThat(result.getUsername()).isEqualTo("Ivan");
    }

    @Test
    void whenSecondElChangedOnIvan() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        store.add(new Role("2", "Alex"));
        store.replace("2", store.findById("1"));
        assertThat(store.findById("2").getUsername()).isEqualTo("Ivan");
    }

    @Test
    void whenSearchElAndIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Role result = store.findById("10");
        assertThat(result).isNull();
    }

    @Test
    void whenDeleteAndReturnFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Boolean result = store.delete("2");
        assertThat(result).isFalse();
    }

    @Test
    void whenDeleteAndReturnTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Boolean result = store.delete("1");
        assertThat(result).isTrue();
    }

    @Test
    void whenReplaceNotOkIsFalse() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Boolean result = store.replace("2", new Role("3", "Petr"));
        assertThat(result).isFalse();
    }

    @Test
    void whenReplaceOkIsTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Ivan"));
        Boolean result = store.replace("1", new Role("3", "Petr"));
        assertThat(result).isTrue();
    }



}