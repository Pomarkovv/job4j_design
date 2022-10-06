package ru.job4j.io;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("PetrArsentev");
        assertThat(config.value("12")).isEqualTo("IvanPomarkov");
    }

    @Test
    void whenValueHasEqualSymbol() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("13")).isEqualTo("=Ivan");
    }

    @Test
    void noKey() {
        String path = "./data/no_key.properties";
        Config config = new Config(path);
        config.load();
        assertThatIllegalArgumentException();
    }

    @Test
    void noValues() {
        String path = "./data/no_value.properties";
        Config config = new Config(path);
        config.load();
        assertThatIllegalArgumentException();
    }
}