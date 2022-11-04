/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ListIteratorTest {
    ArrayList<Object> testList = new ArrayList<>();
    ListIterator testIterator = new ListIterator(testList);
    @Test
    void hasNext() {
        testList.add("skundur1");
        Assertions.assertTrue(testIterator.hasNext());
    }

    @Test
    void next() {
        testList.add("skundur1");
        Assertions.assertNotEquals(null, testIterator.next());
    }

    @Test
    void remove() {
        testList.add("skundur1");
        testIterator.next();
        testIterator.remove();
        Assertions.assertTrue(testIterator.theList.isEmpty());
    }
}