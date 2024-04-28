package hexlet.code;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

class Differ {

    public static Map<String, Object> getData(String content) throws Exception {
        Path p = Paths.get(content);
        ObjectMapper objectMapper = new ObjectMapper();
        var result = objectMapper.readValue(Files.readString(p), new TypeReference<Map<String, Object>>(){});
        return result;
    }

    public static String generate(Map<String, Object> map1, Map<String, Object> map2){
        var treeMap = new TreeMap<String, Object>();
        List<String> list = new ArrayList<>(); 
        treeMap.putAll(map1);
        treeMap.putAll(map2);

        treeMap.forEach((k, v) -> {
            if (map1.containsKey(k) && map2.containsKey(k)) {
                if (map1.get(k).equals(map2.get(k))) {
                    list.add("    " + k + ": " + v);
                } else {
                    list.add("  - " + k + ": " + map1.get(k));
                    list.add("  + " + k + ": " + v);
                }
            } else if (map1.containsKey(k)) {
                list.add("  - " + k + ": " + map1.get(k));
            } else if (map2.containsKey(k)) {
                list.add("  + " + k + ": " + v);
            }
        });
        list.add(0, "{");
        list.add("}");
        String result = String.join("\n", list);
        return result;
    }
}
