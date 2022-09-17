package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Ivan Pomarkov";
        int age = 20;
        double dAge = 20.3;
        float fAge = 20.3f;
        Boolean isStudent = true;
        char symb = 'X';
        byte byteNum = 2;
        short shortNum = 10;

        LOG.debug("User info name : {}, age : {}, dAge : {}, fAge : {}, isStudent : {}, symb : {}, byteNum : {}, shortNum : {}", name, age, dAge, fAge, isStudent, symb, byteNum, shortNum);
    }
}