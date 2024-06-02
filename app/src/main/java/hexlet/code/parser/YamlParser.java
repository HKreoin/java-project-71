package hexlet.code.parser;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlParser extends Parser {
    private Path path;

    public YamlParser(Path path) {
        this.path = path;
    }

    @Override
    public Map<String, Object> getData() throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        var file = mapper.readValue(Files.readString(path), new TypeReference<Map<String, Object>>() { });
        return file;
    }
}
