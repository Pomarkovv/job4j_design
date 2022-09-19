package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "cv")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cv {

    @XmlAttribute
    public String biography;

    public Cv() {

    }
    public Cv(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Cv{"
                +
                "biography:'"
                + biography
                + '\''
                +
                '}';
    }
}
