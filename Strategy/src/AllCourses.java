import java.util.*;
public class AllCourses{
    private AllItems<Course> _courses;
    public AllCourses(){
        _courses = new AllItems<Course>();
    }
    public void addCourse(String id, int c){
        _courses.addItem(new Course(id, c));
    }
    public boolean courseExists(String cnum){
        if(_courses.findItem(cnum, new CourseSearch()) != -1)
            return true;
        else
            return false;
    }
    public int findCourse(String cnum){
        return _courses.findItem(cnum, new CourseSearch());
    }
    public void removeCourse(String cnum){
        int i = _courses.findItem(cnum, new CourseSearch());
        if (i != -1)
            _courses.removeItem(i);
    }
    public String toString(){
        String s = "Courses:\n";
        for (int i=0; i<_courses.size(); i++)
            s += (_courses.get(i).toString() + "\n");
        return s;
    }
}
