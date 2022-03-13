package aust.csi.json.parser;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private List<Car> cars;
    private String name;
    private String city;
    private int age;

    public List<Car> getCars() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car) ;
    }

    public Person(String name, String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
        cars = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Person{" +
                "cars=" + cars +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
