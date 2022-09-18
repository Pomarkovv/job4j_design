package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Programmer programmer = new Programmer(true, 20, new Cv("bla bla bla"), new String[] {"Siberian Federal University", "alone"});
        final Gson json = new GsonBuilder().create();
        System.out.println(json.toJson(programmer));

        final String programmerJson =
                "{"
                        + "\"sex\":true,"
                        + "\"age\":30,"
                        + "\"cv\":"
                        + "{"
                        + "\"biography\":\"Bla! bla bla !!!\""
                        + "},"
                        + "\"statuses\":"
                        + "[\"Moscow federal university\",\"alone\"]"
                        + "}";
        final Programmer programmerMod = json.fromJson(programmerJson, Programmer.class);
        System.out.println(programmerMod);
    }
}
