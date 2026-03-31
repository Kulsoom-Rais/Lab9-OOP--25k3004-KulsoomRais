package Task10;
interface Assignment {
    void giveAssignment();
}
interface Quiz {
    void conductQuiz();
}
class GuestInstructor {
    private String name;

    public GuestInstructor(String name) {
        this.name = name;
    }

    public void teachOnce() {
        System.out.println(name + " is delivering a guest lecture.");
    }
}
abstract class Course {
    protected String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public abstract void startCourse();
}
class ProgrammingCourse extends Course implements Assignment, Quiz {

    public ProgrammingCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void startCourse() {
        System.out.println(courseName + " has started (Programming Course).");
    }

    @Override
    public void giveAssignment() {
        System.out.println("Programming assignment given.");
    }

    @Override
    public void conductQuiz() {
        System.out.println("Programming quiz conducted.");
    }
}
class TheoryCourse extends Course implements Assignment {

    public TheoryCourse(String courseName) {
        super(courseName);
    }

    @Override
    public void startCourse() {
        System.out.println(courseName + " has started (Theory Course).");
    }

    @Override
    public void giveAssignment() {
        System.out.println("Theory assignment given.");
    }
}

public class Main10 {
        public static void main(String[] args) {

            Course c1 = new ProgrammingCourse("OOP in Java");
            Course c2 = new TheoryCourse("Software Engineering");

            c1.startCourse();
            ((ProgrammingCourse)c1).giveAssignment();
            ((ProgrammingCourse)c1).conductQuiz();

            c2.startCourse();
            ((TheoryCourse)c2).giveAssignment();

            // Guest Instructor (one-time use)
            GuestInstructor guest = new GuestInstructor("Dr. Kulsoom");
            guest.teachOnce();
        }

}
