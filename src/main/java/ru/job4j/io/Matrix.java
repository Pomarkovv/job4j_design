package ru.job4j.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("matrix.txt")) {
            int[][] matrix = new int[9][9];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[i][j] = (i + 1) * (j + 1);
                    out.write(String.valueOf(matrix[i][j]).getBytes());
                    if (String.valueOf(matrix[i][j]).length() == 1) {
                        out.write(" ".getBytes());
                    }
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}