package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;

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
        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            resultMap.put(key, value);
            if (value instanceof String) {
                resultMap.put(key, "'" + value + "'");
            } else if (value instanceof List || value instanceof Map) {
                resultMap.put(key, "[complex value]");
            } else {
                resultMap.put(key, value);
            }
        }

        for (var entry: resultMap.entrySet()) {
            var key = entry.getKey();
            if (key.charAt(0) == '-') {
                builder.append("Property '");
                builder.append(key.substring(2));
                if (resultMap.containsKey("+ " + key.substring(2))) {
                    builder.append("' was updated. From ");
                    builder.append(resultMap.get("- " + key.substring(2)));
                    builder.append(" to ");
                    builder.append(resultMap.get("+ " + key.substring(2)));
                } else {
                    builder.append("' was removed");
                }
                builder.append("\n");
            } else if (key.charAt(0) == '+' && !resultMap.containsKey("- " + key.substring(2))) {
                builder.append("Property '");
                builder.append(key.substring(2));
                builder.append("' was added with value: " + resultMap.get("+ " + key.substring(2)));
                builder.append("\n");
            }
        }
        return builder.toString().substring(0, builder.toString().length() - 1);
    }

}
