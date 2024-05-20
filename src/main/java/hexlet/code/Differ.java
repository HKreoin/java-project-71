package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;

class Differ {

    public static String generate(Map<String, Object> file1, Map<String, Object> file2) {
        var treeMap = new TreeMap<String, Object>();
        List<String> list = new ArrayList<>();
        treeMap.putAll(file1);
        treeMap.putAll(file2);

        treeMap.forEach((k, v) -> {
            if (file1.containsKey(k) && file2.containsKey(k)) {
                if (file1.get(k).equals(file2.get(k))) {
                    list.add("    " + k + ": " + v);
                } else {
                    list.add("  - " + k + ": " + file1.get(k));
                    list.add("  + " + k + ": " + v);
                }
            } else if (file1.containsKey(k)) {
                list.add("  - " + k + ": " + file1.get(k));
            } else if (file2.containsKey(k)) {
                list.add("  + " + k + ": " + v);
            }
        });
        list.add(0, "{");
        list.add("}");
        String difference = String.join("\n", list);
        return difference;
    }
}
