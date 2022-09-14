package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class AnalizyTest {
    @Test
    void analizy(@TempDir Path tempDir) throws IOException {
        Analizy analizy = new Analizy();
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("400 11:56:01");
            out.println("500 12:56:01");
            out.println("200 10:56:01");
            out.println("400 10:56:01");
            out.println("200 10:56:01");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            assertThat(in.lines().toList()).contains("11:56:01;10:56:01");
        }

    }

}