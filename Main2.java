package Task2;

interface RecordedCourse {
    default void playVideo() {
        System.out.println("Playing recorded lecture...");
    }
}

interface LiveCourse {
    default void playVideo() {
        System.out.println("Streaming live session...");
    }
}
abstract class Course {
    String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    abstract void startCourse();
}
class HybridCourse extends Course implements RecordedCourse, LiveCourse {

    HybridCourse(String courseName) {
        super(courseName);
    }

    // חובה: resolve conflict between interfaces
    @Override
    public void playVideo() {
        System.out.println("Hybrid course video mode:");

        // Call both versions
        RecordedCourse.super.playVideo();
        LiveCourse.super.playVideo();
    }

    @Override
    void startCourse() {
        System.out.println("Starting hybrid course: " + courseName);
        System.out.println("Includes both live sessions and recorded content.");
    }
}


public class Main2 {
        public static void main(String[] args) {

            HybridCourse course = new HybridCourse("Advanced Java Programming");

            course.startCourse();
            System.out.println();
            course.playVideo();
        }

}
