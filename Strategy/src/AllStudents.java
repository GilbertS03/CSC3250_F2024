import java.util.*;
public class AllStudents {
    private AllItems<Student> _students;

    public AllStudents(){_students = new AllItems<Student>();}
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
        if (i != -1)
            _students.removeItem(i);
    }
    public String toString(){
        String s = "Students:\n";
        for (int i=0; i<_students.size(); i++)
            s += (_students.get(i).toString() + "\n");
        return s;
    }
}