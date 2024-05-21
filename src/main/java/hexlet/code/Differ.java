package hexlet.code;

import hexlet.code.parser.ParserFactory;

import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

class Differ {

    public static Map<String, Object> generate(String filepath1, String filepath2) throws Exception {
        var file1 = new ParserFactory().createParser(filepath1).getData();
        var file2 = new ParserFactory().createParser(filepath2).getData();
        var map = new TreeMap<String, Object>();
        var result = new LinkedHashMap<String, Object>();
        map.putAll(file1);
        map.putAll(file2);
        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var value = entry.getValue();
            if (value == null) {
                entry.setValue("null");
            }
            if (file1.containsKey(key) && file1.get(key) == null) {
                file1.put(key, "null");
            }
            if (file2.containsKey(key) && file2.get(key) == null) {
                file2.put(key, "null");
            }
            System.out.println(file2.get(key));
            if (file1.containsKey(key) & file2.containsKey(key) && file1.get(key).equals(file2.get(key))) {
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
        return result;
    }
}
