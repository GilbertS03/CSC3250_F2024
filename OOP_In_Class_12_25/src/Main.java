class Test {
    private int _x;
    public Test() {_x = 0;}
    public Test(int a) {_x = a;}
    public void setX(int a) {_x = a;}
    public int getX() {return _x;}
}

class Test2 {
    private int _y;
    public Test2() {_y = 0;}
    public Test2(int a) {_y = a;}
    public void setY(int a) {_y = a;}
    public int getY() {return _y;}
}

class Stuff<T> {
    private T _thing;
    public Stuff() {_thing = null;}
    public Stuff(T t){_thing = t;}
    public T getThing() {return _thing;}
    public void setThing(T t){_thing = t;}
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
        Test2 test2 = new Test2();
        Stuff<Test> stuff = new Stuff<>();
        stuff.print();
        stuff.setThing(test);
        stuff.print();
        System.out.println(stuff.getThing().getX());
    }
}