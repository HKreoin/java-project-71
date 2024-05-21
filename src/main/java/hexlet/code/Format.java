package hexlet.code;

import java.util.List;

class Format {

    public static String reflect(List<String> list, String format) {
        return switch (format) {
            case "stylish" -> stylish(list);
            default -> throw new IllegalArgumentException("Unexpected value: " + format);
        };
    }

    private static String stylish(List<String> list) {
        return String.join("\n", list);
    }

}
