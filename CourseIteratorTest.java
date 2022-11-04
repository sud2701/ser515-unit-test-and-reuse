import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseIteratorTest {

    ClassCourseList testCourseList = new ClassCourseList();
    CourseIterator testCourseIterator = new CourseIterator(testCourseList);
    Course testCourse = new Course("SER421", 1);
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void hasNext() {
        testCourseList.add(testCourse);
        Assertions.assertTrue(testCourseIterator.hasNext());
    }

    @Test
    void next() {
        testCourseList.add(testCourse);
        Assertions.assertNotEquals(null, testCourseIterator.next());
    }

    @Test
    void remove() {
        testCourseList.add(testCourse);
        testCourseIterator.next();
        testCourseIterator.remove();
        Assertions.assertEquals(0, testCourseIterator.theCourseList.size());
    }

    @Test
    void testNext() {
        testCourseList.add(testCourse);
        Assertions.assertNotEquals(null, testCourseIterator.next("SER421"));
    }
}