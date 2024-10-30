import java.util.*;

class Test {
    private int _x;
    public Test() {_x = 0;}
    public Test(int a) {_x = a;}
    public void setX(int a) {_x = a;}
    public int getX() {return _x;}
    public boolean equals(Object t){
        if(this == t)
            return true;
        if(t == null)
            return false;
        if(t instanceof Test)
            return _x == ((Test) t)._x;
        return false;
    }
}

class Test2 {
    private int _y;
    public Test2() {_y = 0;}
    public Test2(int a) {_y = a;}
    public void setY(int a) {_y = a;}
    public int getY() {return _y;}
}

class Stuff<T> {
    private ArrayList<T> _thing;
    public Stuff(){_thing = new ArrayList<T>();}
    public Stuff(int size){_thing = new ArrayList<T>(size);}
    public void addItem(T t){
        _thing.add(t);
    }

    public T removeItem(int idx){
        if(idx >= 0 && idx < _thing.size()) {
            T temp = _thing.remove(idx);
            return temp;
        }
        else
            return null;

    }

    //This method will search for an item in the ArrayList to find if the contents are equal to one another
    public boolean findItem(T item){
        int i = 0;
        boolean found = false;
        while(i < _thing.size() && !found){
            if(_thing.get(i).equals(item)){
                found = true;
            }
            else{
                i++;
            }
        }
        return found;
    }

    public void printItem(){

    }

//    public T getThing() {return _thing;}
//    public void setThing(T t){_thing = t;}
    public void print(){
        if(_thing != null)
            System.out.println("Type: " + _thing.getClass().getName() + ", Value: " + _thing);
        else
            System.out.println("Null member variable");
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test(5);
        Test2 test2 = new Test2(5);
        Stuff<Test> stuff = new Stuff<>();
        Stuff<Test> stuff2 = new Stuff<>(5);
        stuff.addItem(new Test(5));
        System.out.println(stuff.findItem(test));


    }
}