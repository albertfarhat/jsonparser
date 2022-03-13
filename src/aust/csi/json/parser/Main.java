package aust.csi.json.parser;
import aust.csi.json.parser.libs.Car;
import aust.csi.json.parser.libs.FileManager;
import aust.csi.json.parser.libs.Person;
import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;

public class Main {
    private static final String _fileName  = "person.json";
    private static JSONArray _persons = new JSONArray();

    public static void main(String[] args) {
        System.out.println("Json Parser System");
        _persons = FileManager.loadFromFile(_fileName);
        for (Object object: _persons) {
            System.out.println("LoadedObject= "+ object);
        }
        _persons.put(createPerson("Albert","Beirut",15));
        FileManager.saveToFile(_fileName,_persons);
    }

    private static JSONObject createPerson(String name,String city, int age){
        Person person = new Person(name,city,age);
        System.out.println(person);
        person.addCar(new Car("BMW","X5",2010));
        person.addCar(new Car("Mercedes","Coupe",2015));
        return new JSONObject(person);
    }
}
