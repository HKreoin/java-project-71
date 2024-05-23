package hexlet.code;

import hexlet.code.parser.ParserFactory;

import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2, String format) throws Exception {
        var file1 = new ParserFactory().createParser(filepath1).getData();
        var file2 = new ParserFactory().createParser(filepath2).getData();
        var map = new TreeMap<String, Object>();
        var result = new LinkedHashMap<String, Object>();
        map.putAll(file1);
        map.putAll(file2);
        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (hasKeyAndEquals(file1, file2, key)) {
                result.put("  " + key, value);
            } else {
                if (file1.containsKey(key)) {
                    result.put("- " + key, file1.get(key));
                }
                if (file2.containsKey(key)) {
                    result.put("+ " + key, file2.get(key));
                }
            }
        }
        return Formatter.reflect(result, format);
    }
    public static boolean hasKeyAndEquals(Map<String, Object> map1, Map<String, Object> map2, String key) {
        if (map1.containsKey(key) && map2.containsKey(key)) {
            if (map1.get(key) == null) {
                return map2.get(key) == null;
            }
            if (map2.get(key) == null) {
                return false;
            }
            return map1.get(key).equals(map2.get(key));
        }
        return false;
    }
}
