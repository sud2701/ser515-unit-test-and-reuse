/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionIteratorTest {
    Solution testSolution = new Solution();
    SolutionList testSolutionList = new SolutionList();
    SolutionIterator testSolutionIterator = new SolutionIterator(testSolutionList);
    @Test
    void moveToHead() {
        testSolutionList.add(testSolution);
        testSolutionIterator.moveToHead();
        assertEquals(-1,testSolutionIterator.currentSolutionNumber);
    }

    @Test
    void hasNext() {
        testSolutionList.add(testSolution);
        assertTrue(testSolutionIterator.hasNext());
    }

    @Test
    void next() {
        testSolutionList.add(testSolution);
        assertNotEquals(null,testSolutionIterator.next());
    }

    @Test
    void testNext() {
        testSolutionList.add(testSolution);
        assertNull(testSolutionIterator.next("Sudheer Reddy"));
    }

    @Test
    void remove() {
        testSolutionList.add(testSolution);
        assertTrue(testSolutionIterator.hasNext());
        testSolutionIterator.next();
        testSolutionIterator.remove();
        assertFalse(testSolutionIterator.hasNext());
    }
}