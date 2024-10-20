import java.util.*;

class Door{
    private boolean _open;
    public Door(){
        System.out.println("In default constructor of Door");
        _open = false;
    }
    public Door(boolean n){
        System.out.println("In 1-arg constructor of Door");
        _open = n;
    }
    public boolean isOpen(){return _open;}

    public void open(){
        _open = true;
    }

    public void close(){
        _open = false;
    }

    public String toString(){
        if(_open)
            return "true";
        else
            return "false";
    }
}

class LockedDoor extends Door{
    private boolean _locked;
    public LockedDoor(){
        super();
        System.out.println("In default constructor of LockedDoor");
        _locked = false;
    }
    public LockedDoor(boolean x){
        System.out.println("In 1-arg constructor of LockedDoor");
        _locked = x;
    }
    public LockedDoor(boolean n, boolean m){
        super(n);
        System.out.println("In 2-arg constructor of LockedDoor");
        _locked = m;
    }
    public boolean is_locked(){return _locked;}

    public void open(){
         if(!_locked)
             super.open();
    }
    public void lock(){
        _locked = true;
    }

    public void unlock(){
        _locked = false;
    }

    public String toString(){
        String s = super.toString();
        if(_locked) return s = s + " true";
        return s = s + " false";
    }

}

class SafeDoor extends LockedDoor{
    private int _pin;
    public SafeDoor(){
        super();
        System.out.println("In default constructor of SafeDoor");
        _pin = 0;
    }
    public SafeDoor(boolean x, boolean y, int z){
        super(x, y);
        _pin = z;
        System.out.println("In 3-arg constructor of SafeDoor");
    }
    public void open(){}
    public void open(int x){
        if(x == _pin){
            super.unlock();
            super.open();
        }
    }

    public String toString(){
        String s = super.toString() + " " + _pin;
        return s;
    }

}

public class Main {
    public static void main(String[] args) {
        SafeDoor sd = new SafeDoor();
        sd.lock();
        sd.open(0);
        System.out.println(sd.toString());
    }
}
