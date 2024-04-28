/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package hexlet.code;

import java.util.Map;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;

class AppTest {
    @Test void getDataTest() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String content = "src/test/resources/test.json";
        Path p = Paths.get(content);
        Map<String, Object> testMap =  Map.of("name", "Jeff", "age", 22, "hobby", "programming");
        if (Files.notExists(p)) {
            Files.createFile(p);
        }
        var data = objectMapper.writeValueAsBytes(testMap);
        Files.write(p, data);
        var actual = Differ.getData(content);

        assertEquals("Jeff", actual.get("name"));
        assertEquals(22, actual.get("age"));
        assertEquals("programming", actual.get("hobby"));
    }

    @Test void generateTest() throws IOException {
        Map<String, Object> map1 = Map.of(
            "host", "hexlet.io",
            "timeout", 50,
            "proxy", "123.234.53.22",
            "follow", false);
        Map<String, Object> map2 = Map.of(
            "timeout", 20,
            "verbose", true,
            "host", "hexlet.io");
        List<String> listExpected = List.of(
            "{",
            "  - follow: false",
            "    host: hexlet.io",
            "  - proxy: 123.234.53.22",
            "  - timeout: 50",
            "  + timeout: 20",
            "  + verbose: true",
            "}");
        String expected = String.join("\n", listExpected);
        assertEquals(expected, Differ.generate(map1, map2));
    }
}
