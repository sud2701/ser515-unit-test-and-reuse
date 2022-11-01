package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {
    Instructor testInstructor = new Instructor();
    Course testCourse = new Course("SER423",0);
    @Test
    void createCourseMenu() {
        CourseMenu courseMenu = testInstructor.createCourseMenu(testCourse,0);
        Assertions.assertEquals(courseMenu.getClass(), HighLevelCourseMenu.class);
    }

    @Test
    void showMenu() {
        Assertions.assertEquals(1,testInstructor.type);
    }
}