import java.util.*;
public class Main {
    public static int menu(Scanner scan){
        System.out.println("1. Add student");
        System.out.println("2. Add course");
        System.out.println("3. Add enrollment");
        System.out.println("4. Remove student");
        System.out.println("5. Remove course");
        System.out.println("6. Remove enrollment");
        System.out.println("7. Print all");
        System.out.println("8. Exit");
        int choice = 0;
        try {
            choice = Integer.parseInt(scan.nextLine());
        }
        catch(Exception e){
            System.out.println("error reading input");
        }
        return choice;
    }
    public static void processChoice(int choice, AllStudents students, AllCourses courses,
                                     Enrollment enrollment, Scanner scan) {
        switch (choice) {
            case 1 -> { // add student
                System.out.println("Enter student id to add");
                students.addStudent(scan.nextLine());
            }
            case 2 -> { // add course
                System.out.println("Enter course id to add");
                String c = scan.nextLine();
                System.out.println("Enter credits");
                int cr = Integer.parseInt(scan.nextLine());
                courses.addCourse(c, cr);
            }
            case 3 -> { // add enrollment
                System.out.println("Enter student id to add");
                String id = scan.nextLine();
                System.out.println("Enter course id to add");
                String c = scan.nextLine();
                enrollment.addStudentToCourse(id, c);
            }
            case 4 -> { // remove student
                System.out.println("Enter student id to remove");
                String id = scan.nextLine();
                students.removeStudent(id);
                enrollment.dropStudentFromAllCourses(id);
            }
            case 5 -> { // remove course
                System.out.println("Enter course id to remove");
                String c = scan.nextLine();
                courses.removeCourse(c);
                enrollment.dropCourse(c);
            }
            case 6 -> { // remove enrollment
                System.out.println("Enter student id to remove");
                String id = scan.nextLine();
                System.out.println("Enter course id to remove");
                String c = scan.nextLine();
                enrollment.dropStudentFromCourse(id, c);
            }
            case 7 -> {
                System.out.println(students.toString());
                System.out.println(courses.toString());
                System.out.println(enrollment.toString());
            }
            default -> System.out.println("Invalid choice - try again");
        }
    }

    public static void main(String[] args) {
        AllStudents students = new AllStudents();
        AllCourses courses = new AllCourses();
        Enrollment enrollment = new Enrollment(students);
        Scanner scan = new Scanner(System.in);
        int choice = menu(scan);
        while (choice != 8){
            processChoice(choice, students, courses, enrollment, scan);
            choice = menu(scan);
        }
    }
}