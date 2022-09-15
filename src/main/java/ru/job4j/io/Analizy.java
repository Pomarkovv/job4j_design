package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            Boolean errorOnServer = true;
            while (read.ready()) {
                String line = read.readLine();
                if (errorOnServer && (line.startsWith("400") || line.startsWith("500"))) {
                    out.append(line.split(" ")[1]).append(';');
                    errorOnServer = false;
                } else if (!errorOnServer && !line.startsWith("400") && !line.startsWith("500")) {
                    out.append(line.split(" ")[1]).append(';').append(System.lineSeparator());
                    errorOnServer = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analizy = new Analizy();
        analizy.unavailable("./data/sourceLog", "./data/errLogs");
    }
}