import java.util.*;
public class AllCourses implements Subject{
    private AllItems<Course> _courses;
    private ArrayList<Observer> _observers;

    public AllCourses(){
        _courses = new AllItems<Course>();
        _observers = new ArrayList<Observer>();
    }

    public void subscribe(Observer obs){
        _observers.add(obs);
    }

    public void unsubscribe(Observer obs){
        _observers.remove(obs);
    }

    //Student id is the parameter of this function but this can vary
    public void notifyObservers(String courseID){
        for(Observer obs : _observers)
            obs.update(courseID);
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
    public void removeCourse(String cnum) {
        int i = _courses.findItem(cnum, new CourseSearch());
        if (i != -1){
            _courses.removeItem(i);
            notifyObservers(cnum);
        }
    }
    public String toString(){
        String s = "Courses:\n";
        for (int i=0; i<_courses.size(); i++)
            s += (_courses.get(i).toString() + "\n");
        return s;
    }
}
