/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {
    Assignment testAsssignment = new Assignment();
    Course testCourse = new Course("SER421", 0);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addAssignment() {
        testCourse.addAssignment(testAsssignment);
        Assertions.assertEquals(1, testCourse.assignmentList.size());
    }

    @Test
    void testToString() {
        Assertions.assertEquals("SER421", testCourse.toString());
    }

    @Test
    void accept() {
        testCourse.accept(new ReminderVisitor());
        Assertions.assertTrue(testCourse.isAccepted);
    }
}