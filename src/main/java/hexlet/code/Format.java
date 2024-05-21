package hexlet.code;

import java.util.Map;
import java.util.stream.Collectors;

class Format {

    public static String reflect(Map <String, Object> map, String format) {
        return switch (format) {
            case "stylish" -> stylish(map);
            default -> throw new IllegalArgumentException("Unexpected value: " + format);
        };
    }

    private static String stylish(Map<String, Object> map) {
        return map.keySet().stream()
            .map(key -> key + ": " + map.get(key))
            .collect(Collectors.joining("\n  ", "{\n  ", "\n}"));
    }

}
