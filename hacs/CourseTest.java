package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(1, testCourse.assignmentList.size());
    }

    @Test
    void testToString() {
        assertEquals("SER421", testCourse.toString());
    }

    @Test
    void accept() {
        testCourse.accept(new ReminderVisitor());
        assertTrue(testCourse.isAccepted);
    }
}