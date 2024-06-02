package hexlet.code.parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class JsonParser extends Parser {

    private Path path;

    public JsonParser(Path path) {
        this.path = path;
    }

    @Override
    public Map<String, Object> getData() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(Files.readString(path), new TypeReference<Map<String, Object>>() { });
    }
}
