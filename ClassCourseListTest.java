/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassCourseListTest {
    ClassCourseList testCourseList = new ClassCourseList();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void initializeFromFile() {
        testCourseList.initializeFromFile();
        Assertions.assertEquals(3,testCourseList.size());
    }

    @Test
    void findCourseByCourseName() {
        String testCourseName = "SER515";
        testCourseList.initializeFromFile();
        Assertions.assertEquals(testCourseName, testCourseList.findCourseByCourseName((testCourseName)).toString());
    }
}