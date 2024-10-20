import java.util.*;
import java.io.*;

class Dog {
    private String _name;
    private String _breed;
    private int _age;
    private String _color;

    public Dog() {
        _name = "";
        _breed = "";
        _age = 0;
        _color = "";
    }

    public Dog(String s1, String s2, int x) {
        _name = s1;
        _breed = s2;
        _age = x;
    }

    public Dog(String s1, String s2, int x, String c) {
        _name = s1;
        _breed = s2;
        _age = x;
        _color = c;
    }

    public Dog(Dog d){
        _name = d._name;
        _breed = d._breed;
        _age = d._age;
        _color = d._color;
    }

    public void setName(String n) {
        _name = n;
    }

    public void setBreed(String b) {
        _breed = b;
    }

    public void setAge(int x) {
        _age = x;
    }

    public void setColor(String c) {
        _color = c;
    }

    public String getName() {
        return _name;
    }

    public String getBreed() {
        return _breed;
    }

    public int getAge() {
        return _age;
    }

    public String get_color() {
        return _color;
    }
}

class Daycare {
    private ArrayList<Dog> _dogs;

    private int _next;

    private static Daycare _uniqueInstance;

    private int find(String n) {
        //non-exhaustive search of name in the ArrayList
        boolean found = false;
        int i = 0;
        while (i < _dogs.size() && !found) {
            if (_dogs.get(i).getName().equals(n))
                found = true;
            else
                i++;
        }
        if (!found)
            return -1;
        else
            return i;
    }

    private Daycare() {
        _dogs = new ArrayList<Dog>();
        _next = 0;
    }

    private Daycare(int size) {
        _dogs = new ArrayList<Dog>(size);
        _next = 0;
    }

    public static Daycare getInstance() {
        System.out.println("In getInstance()");
        if (_uniqueInstance == null)
            _uniqueInstance = new Daycare();
        return _uniqueInstance;
    }

    public static Daycare getInstance(int size) {
        System.out.println("In getInstance(size)");
        if (_uniqueInstance == null)
            _uniqueInstance = new Daycare(size);
        return _uniqueInstance;
    }

    //    public void addDog(String n, String b, int a){
//        Dog t = new Dog(n, b, a); //passing in primitive data types therefore main never has to create a dog object
//        _dogs.add(t);
//    }
    public void addDog(Dog d) {
        _dogs.add(d);
    }

    public boolean removeDog(String n) {
        int idx = find(n);
        if (idx == -1) {
            System.out.println("Not removed");
            return false;
        }
        else {
            _dogs.remove(idx);
            System.out.println("Removed");
            return true;
        }
    }

    public boolean modifyAge(String n, int a) {
        int idx = find(n);
        if (idx == -1)
            return false;
        else {
            _dogs.get(idx).setAge(a);
            return true;
        }
    }

    public int findAge(String name) {
        int idx = find(name);
        if (idx == -1)
            return -1;
        else
            return _dogs.get(idx).getAge();
    }

    public String getName(int idx) {
        if (idx >= 0 && idx <= _dogs.size())
            return _dogs.get(idx).getName();
        else
            return "";
    }

    public int getAge(int idx) {
        if (idx >= 0 && idx <= _dogs.size())
            return _dogs.get(idx).getAge();
        else
            return -1;
    }

    public int size() {
        return _dogs.size();
    }

    //Iterator methods
    public void start(){
        _next = 0;
    }

    public boolean hasNext(){
        if(_next > _dogs.size() - 1)
            return false;
        else
            return true;
    }

    public Dog next(){
        //create a copy that is returned
        Dog d = new Dog(_dogs.get(_next));
        _next++;
        return d;
        //return _dogs.get(_next++);
    }

    public void print() {
        for (int i = 0; i < _dogs.size(); i++) {
            System.out.println(_dogs.get(i).getName() + " " + _dogs.get(i).getBreed() + " " + _dogs.get(i).getAge());
        }
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        //testing default constructor
        Daycare d = Daycare.getInstance();
        //Testing add dog on empty container
        d.addDog(new Dog("Fido", "German Shepard", 6));
        //Testing n-arg constructor
        Daycare d2 = Daycare.getInstance(5);
        d2.addDog(new Dog("Chaser", "Poodle", 8));
        d2.print();
        d.print();
        //Testing adding to non-empty container
        d.addDog(new Dog("Harry", "Golden Retriever", 8));
        d.addDog(new Dog("Super", "Poodle", 2));
        d.start();
        while(d.hasNext()){
            System.out.println(d.next().getName());
        }

        d.start();
        d.next().setAge(8);
        d.print();

        int x = 202;
        String y = String.valueOf(x);
        System.out.println(y);
//
//        //Testing size method
//        System.out.println(d.size());
//        //Modify age method with name in there
//        System.out.println(d.modifyAge("Harry", 9));
//        //Modify age without name in there
//        System.out.println(d.modifyAge("Barney", 2));
//        //Find age with name in there
//        System.out.println(d.findAge("Fido"));
//        //Find age without name in there
//        System.out.println(d.findAge("Barney"));
//        //Get Name out of bounds
//        System.out.println(d.getName(20));
//        //Get name in bounds
//        System.out.println(d.getName(0));
//        //Get age in bounds
//        System.out.println(d.getAge(0));
//        //Get age out of bounds
//        System.out.println(d.getAge(30));
//        //Remove dog that is in there
//        System.out.println(d.removeDog("Harry"));
//        //Remove dog that doesn't exist
//        System.out.println(d.removeDog("Bolt"));
//        //New dog default constructor
//        Dog doggy = new Dog();
//        //Set name for dog class
//        doggy.setName("Barney");
//        //Set age for dog class
//        doggy.setAge(23);
//        //Set breed for dog class
//        doggy.setBreed("Lab");
//        //Get name for dog class
//        System.out.println(doggy.getName());
//        //Get breed for dog class
//        System.out.println(doggy.getBreed());
//        //Get age for dog class
//        System.out.println(doggy.getAge());
    }
}
