import java.util.*;
public class AllStudents implements Subject{
    private AllItems<Student> _students;
    private ArrayList<Observer> _observers;

    public AllStudents(){
        _students = new AllItems<Student>();
        _observers = new ArrayList<Observer>();
    }

    public void subscribe(Observer obs){
        _observers.add(obs);
    }

    public void unsubscribe(Observer obs){
        _observers.remove(obs);
    }
    //Student id is the parameter of this function but this can vary
    public void notifyObservers(String id){
        for(Observer obs : _observers)
            obs.update(id);
    }

    public void addStudent(String id){
        _students.addItem(new Student(id));
    }

    public boolean studentExists(String id){
        if(_students.findItem(id, new StudentSearch()) > -1)
            return true;
        else
            return false;
    }

    public int findStudent(String id){
        return _students.findItem(id, new StudentSearch());
    }

    public void removeStudent(String id){
        int i = _students.findItem(id, new StudentSearch());
        if (i != -1) {
            _students.removeItem(i);
            notifyObservers(id);
        }
    }

    public String toString(){
        String s = "Students:\n";
        for (int i=0; i<_students.size(); i++)
            s += (_students.get(i).toString() + "\n");
        return s;
    }

}