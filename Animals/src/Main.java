import java.util.*;
import java.io.*;

abstract class Animal {
    private String _name;
    private String _breed;
    private int _age;
    public Animal() {
        System.out.println("in Animal default");
    }

    public Animal(String s1, String s2, int x){
        System.out.println("in Animal n-arg");
        _name = s1;
        _breed = s2;
        _age = x;
    }

    public void setName(String n) {_name = n;}
    public void setBreed(String b){_breed = b;}
    public void setAge(int x){_age = x;}
    public String getName() {return _name;}
    public String getBreed() {return _breed;}
    public int getAge(){return _age;}
    public abstract boolean equals(Animal a);
//    public void print(){
//        System.out.print(_name + " " + _breed + " " + _age);
//    }
}

class Dog extends Animal {
    private boolean _guard;
    public Dog() {System.out.println("in Dog default");}
    public Dog(String s1, String s2, int x, boolean g){
        super(s1, s2, x);
        System.out.println("in Dog n-arg");
        _guard = g;
    }

    public void setGuard(boolean g) {_guard = g;}
    public boolean getGuard(){return _guard;}
    public boolean equals(Animal a){ //Abstract method
        Dog d = (Dog) a;
        if(getName().equals(d.getName())
                && getBreed().equals(d.getBreed())
                && getAge() == d.getAge() && _guard == d._guard)
            return true;
        else
            return false;
    }

//    public void print(){
//        super.print();
//        System.out.println(_guard);
//    }
}

class Cat extends Animal {
    private boolean _indoor;
    public Cat() {System.out.println("in Cat default");}
    public Cat(String s1, String s2, int x, boolean i){
        super(s1, s2, x);
        System.out.println("in Cat n-arg");
        _indoor = i;
    }

    public void setIndoor(boolean i) {_indoor = i;}
    public boolean getIndoor(){return _indoor;}
    public boolean equals(Animal a){ //Abstract method
        Cat d = (Cat) a;
        if(getName().equals(d.getName())
                && getBreed().equals(d.getBreed())
                && getAge() == d.getAge() && _indoor == d._indoor)
            return true;
        else
            return false;
    }
//    public void print(){
//        super.print();
//        System.out.println(_indoor);
//    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();

        animals.add(new Cat("Jason", "calico", 2, false));
        animals.add(new Dog("John", "German Shepard", 6, true));
        animals.add(new Dog("Spot", "Dalmatian", 7, false));

        //Way to print items out but shouldn't bc print methods should mot be in a class, only for testing
//        for(int i = 0; i <animals.size(); i++){
//            animals.get(i).print();
//        }

        //Correct way to print out items without putting print methods in the classes
        for(int i = 0; i < animals.size(); i++){
            System.out.print(animals.get(i).getName() + " ");
            System.out.print(animals.get(i).getBreed() + " ");
            System.out.print(animals.get(i).getAge() + " ");
            if (animals.get(i) instanceof Dog)
                System.out.println(((Dog) animals.get(i)).getGuard());
            else
                System.out.println(((Cat) animals.get(i)).getIndoor());
        }

    }
}