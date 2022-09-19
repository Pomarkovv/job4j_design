package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlRootElement(name = "programmer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Programmer {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    private static Cv cv;
    private String[] statuses;

    public Programmer(boolean sex, int age, Cv cv, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.cv = cv;
        this.statuses = statuses;
    }

    public boolean isSex() {
        return this.sex;
    }

    public int getAge() {
        return this.age;
    }

    public static String jsonCv() {
        return cv.biography;
    }

    public String[] getStatuses() {
        return this.statuses;
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

    public static void main(String[] args) {
        JSONObject jsonBiography = new JSONObject("{\"biography\":\"bla bla bla!\"}");

        List<String> list = new ArrayList<>();
        list.add("SIberian Federal University");
        list.add("alone");
        JSONArray jsonStatuses = new JSONArray(list);

        final Programmer programmer = new Programmer(false, 20, new Cv("bla bla bla!"), new String[] {"Siberian Federal University", "alone"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", programmer.isSex());
        jsonObject.put("age", programmer.getAge());
        jsonObject.put("biography", jsonBiography);
        jsonObject.put("statuses", programmer.statuses);

        System.out.println(jsonObject.toString());

        System.out.println(new JSONObject(programmer).toString());
    }
}
