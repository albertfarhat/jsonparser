package aust.csi.json.parser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;

public class Main {

    public static void main(String[] args) {
        System.out.println("Json Parser System");
        JSONObject person = CreatePerson("Albert","Beirut",45);
        System.out.println(person);
        SaveToFile("person.json",person);
       /*JSONArray array = new JSONArray();
        array.put("Opel");
        array.put("Mercedes");
        person.put("carsCollection", array);
        System.out.println(person);*/

    }

    private static void SaveToFile(String fileName, JSONObject value) {
        String filePath = "D:\\Source\\Java\\TEMP\\"+fileName;
        Path path =  Paths.get(filePath);
        try
        {
            if(!Files.exists(path)){
                path =  Files.createFile(path);
            }
            Files.write(path,value.toString().getBytes(StandardCharsets.UTF_8) );
        }catch (Exception exception){
         System.out.println(exception);
        }
    }

    private static JSONObject CreatePerson(String name,String city, int age){
        Person person = new Person(name,city,age);
        System.out.println(person);
        person.addCar(new Car("BMW","X5",2010));
        person.addCar(new Car("Mercedes","Coupe",2015));
        return new JSONObject(person);
    }
}
