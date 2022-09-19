package ru.job4j.serialization.json;

import javax.xml.bind.*;
import javax.xml.bind.annotation.*;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "programmer")
@XmlAccessorType(XmlAccessType.FIELD)
public class Programmer {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    private Cv cv;
    private String[] statuses;

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
