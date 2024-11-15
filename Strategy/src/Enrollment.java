import java.util.*;
public class Enrollment {
    // course id is key, value is student ids
    private HashMap<String, ArrayList<String>> _enroll;
    public Enrollment(){
        _enroll = new HashMap<String, ArrayList<String>>();
    }
    public void dropCourse(String c){
        if (_enroll.containsKey(c))
            _enroll.remove(c);
    }
    public void addStudentToCourse(String id, String c){
        ArrayList<String> t = _enroll.get(c);
        if (t == null)  // course not in enroll
            t = new ArrayList<String>();
        t.add(id);
        _enroll.put(c, t);
    }
    public boolean dropStudentFromCourse(String id, String c){
        // drops a student from a course
        ArrayList<String> t = _enroll.get(c);
        if (t == null)  return false;
        boolean removed = t.remove(id);
        // check if last student removed
        if (_enroll.get(c) == null || _enroll.get(c).isEmpty())
            _enroll.remove(c);
        return removed;
    }
    public void dropStudentFromAllCourses(String id){
        boolean found = false;
        Set keys = _enroll.keySet();
        Iterator itr = keys.iterator();
        while (itr.hasNext()) {
            dropStudentFromCourse(id, (String)itr.next());
        }
    }
    public String toString(){
        String s = "Enrollment:\n";
        Set keys = _enroll.keySet();
        Iterator itr = keys.iterator();
        while (itr.hasNext()) {
            String k = (String)itr.next();
            ArrayList<String> t = _enroll.get(k);
            s += (k + " ");
            for (int j=0; j<t.size(); j++)
                s += (t.get(j) + " ");
            s += "\n";
        }
        return s;
    }
}
