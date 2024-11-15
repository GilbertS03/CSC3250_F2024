public class Student {
    // _sid is a unique identifier for a student
    private String _sid;

    public Student(){}
    public Student(String d){_sid = d;}
    public void setID(String id){_sid = id;}
    public String getID(){return _sid;}
    public String toString(){return _sid;}
}