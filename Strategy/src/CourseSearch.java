public class CourseSearch implements SearchBehavior<Course, String>{
    public boolean search(Course obj, String v){
        return obj.getNumber().equals(v);
    }
}