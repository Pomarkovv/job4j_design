package ru.job4j.serialization.json;

import java.util.Arrays;

public class Programmer {
    private final boolean sex;
    private final int age;
    private final Cv cv;
    private final String[] statuses;

    public Programmer(boolean sex, int age, Cv cv, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.cv = cv;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return "Programmer{"
                + "sex=" + sex
                + ", age=" + age
                + ", cv=" + cv
                + ", statuses=" + Arrays.toString(statuses)
                + '}';
    }
}
