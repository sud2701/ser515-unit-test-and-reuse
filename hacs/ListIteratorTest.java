package hacs;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListIteratorTest {
    ArrayList<Object> testList = new ArrayList<>();
    ListIterator testIterator = new ListIterator(testList);
    @Test
    void hasNext() {
        testList.add("skundur1");
        assertTrue(testIterator.hasNext());
    }

    @Test
    void next() {
        testList.add("skundur1");
        assertNotEquals(null, testIterator.next());
    }

    @Test
    void remove() {
        testList.add("skundur1");
        testIterator.next();
        testIterator.remove();
        assertTrue(testIterator.theList.isEmpty());
    }
}