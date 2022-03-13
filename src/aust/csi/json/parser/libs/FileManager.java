package aust.csi.json.parser.libs;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileManager {

    private static final String _path = "D:\\Source\\Java\\TEMP\\";
    public static void saveToFile(String fileName, JSONArray value) {
        String filePath = _path +fileName;
        try
        {
            Path path =  Paths.get(filePath);
            if(!Files.exists(path)){
                path =  Files.createFile(path);
            }
            JSONObject obj = new JSONObject();
            obj.put("data",value);
            Files.write(path,obj.toString().getBytes(StandardCharsets.UTF_8) );
        }catch (Exception exception){
            System.out.println(exception);
        }
    }

    public static JSONArray loadFromFile(String fileName) {
        JSONArray result = new JSONArray();
        String filePath = _path+fileName;
        try
        {
            Path path =  Paths.get(filePath);
            if(!Files.exists(path)){
                return result;
            }

            var dataBytes = Files.readAllBytes(path);
            var data = new String(dataBytes, StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(data);
            return obj.getJSONArray("data");

        }catch (Exception exception){
            System.out.println(exception);
        }
        return result;
    }

}
