import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StudentTest {
    Student testStudent = new Student();
    Course testCourse = new Course("SER421",0);
    @Test
    void createCourseMenu() {
        CourseMenu courseMenu = testStudent.createCourseMenu(testCourse,0);
        Assertions.assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    @Test
    void showMenu() {
        Assertions.assertEquals(0, testStudent.type);
    }
}