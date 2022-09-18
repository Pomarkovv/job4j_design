package ru.job4j.serialization.json;

public class Cv {
    public final String biography;
    public Cv(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Cv{"
                +
                "biography='"
                + biography
                + '\''
                +
                '}';
    }
}
