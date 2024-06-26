package hexlet.code.parser;

import java.nio.file.Path;
import java.nio.file.Paths;

public final class ParserFactory {
    public Parser createParser(String filepath) {
        Path path = Paths.get(filepath);
        String extension = getExtension(filepath);
        Parser parser = null;
        parser = switch (extension) {
            case "yaml" -> new YamlParser(path);
            case "yml" -> new YamlParser(path);
            case "json" -> new JsonParser(path);
            default -> throw new IllegalArgumentException("Illegal extension");
        };
        return parser;
    }

    public static String getExtension(String filepath) {
        int dotIndex = filepath.lastIndexOf('.') + 1;
        return filepath.substring(dotIndex);
    }
}
