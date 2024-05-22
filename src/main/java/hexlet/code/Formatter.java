package hexlet.code;

import java.util.Map;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import org.checkerframework.common.initializedfields.qual.EnsuresInitializedFields.List;

class Formatter {

    public static String reflect(Map<String, Object> map, String format) {
        return switch (format) {
            case "stylish" -> stylish(map);
            case "plain" -> plain(map);
            default -> throw new IllegalArgumentException("Unexpected value: " + format);
        };
    }

    private static String stylish(Map<String, Object> map) {
        return map.keySet().stream()
            .map(key -> key + ": " + map.get(key))
            .collect(Collectors.joining("\n  ", "{\n  ", "\n}"));
    }

    private static String plain(Map<String, Object> map) {
        var builder = new StringBuilder();
        var resultMap = new LinkedHashMap<String, Object>();
        map.keySet().stream()
            .map(key -> map.get(key) != null && map.get(key).getClass() == List.class
                ? resultMap.put(key, "[complex value]")
                : resultMap.put(key, map.get(key)))
            .toList();

        for (var entry: resultMap.entrySet()) {
            var key = entry.getKey();
            if (key.charAt(0) == '-') {
                if (resultMap.containsKey("+ " + key.substring(2))) {
                    builder.append("Property '" + key.substring(2)
                        + "' was updated. From " + resultMap.get("- " + key.substring(2))
                        + " to " + resultMap.get("+ " + key.substring(2)) + "\n");
                } else {
                    builder.append("Property '" + key.substring(2) + "' was removed\n");
                }
            } else if (key.charAt(0) == '+') {
                builder.append("Property '" + key.substring(2)
                    + "' was added with value: " + resultMap.get("+ " + key.substring(2)) + "\n");
            }
        }
        return builder.toString();
    }

}
