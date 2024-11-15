public class StudentSearch implements SearchBehavior<Student, String>{
    public boolean search(Student obj, String v){
        return obj.getID().equals(v);
    }
}