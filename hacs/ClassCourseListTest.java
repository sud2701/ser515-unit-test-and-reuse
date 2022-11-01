package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassCourseListTest {
    ClassCourseList testCourseList = new ClassCourseList();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeFromFile() throws Exception {
        testCourseList.initializeFromFile("CourseInfo.txt");
        assertEquals(3,testCourseList.size());
    }

    @Test
    void findCourseByCourseName() throws Exception {
        String testCourseName = "SER423";
        testCourseList.initializeFromFile("CourseInfo.txt");
        assertEquals(testCourseName, testCourseList.findCourseByCourseName((testCourseName)).toString());
    }
}