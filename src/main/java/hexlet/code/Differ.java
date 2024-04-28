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

    public static Map<String, Object> getData(String filePath) throws Exception {
        Path p = Paths.get(filePath);
        ObjectMapper objectMapper = new ObjectMapper();
        var file = objectMapper.readValue(Files.readString(p), new TypeReference<Map<String, Object>>(){});
        return file;
    }

    public static String generate(Map<String, Object> file1, Map<String, Object> file2){
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
