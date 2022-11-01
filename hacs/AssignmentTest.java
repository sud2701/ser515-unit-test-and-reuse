package hacs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    Assignment testAssignment = new Assignment();
    Solution testSolution = new Solution();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void setDueDate() {
        Date testDueDate = new Date();
        testAssignment.setDueDate(testDueDate);
        Assertions.assertEquals(String.valueOf(testDueDate),testAssignment.getDueDateString());
    }

    @org.junit.jupiter.api.Test
    void setAssignmentSpecification() {
        String specification = "SER 515 Unit Test and Reuse Assignment";
        testAssignment.setAssignmentSpecification(specification);
        Assertions.assertEquals(specification,testAssignment.assignmentSpecification);
    }

    @org.junit.jupiter.api.Test
    void isOverDue() {
        assertTrue(testAssignment.isOverDue());
    }

    @Test
    void addSolution() {
        testAssignment.addSolution(testSolution);
        assertEquals(testSolution,testAssignment.getSolutionList().get(0));
    }

    @org.junit.jupiter.api.Test
    void testAddSolution() {
        testAssignment.addSolution();
        assertFalse(testAssignment.getSolutionList().isEmpty());
    }

    @org.junit.jupiter.api.Test
    void submitSolution() {
        testAssignment.submitSolution();
    }

    @org.junit.jupiter.api.Test
    void getSolutionList() {
        assertEquals(0,testAssignment.getSolutionList().size());
    }

    @org.junit.jupiter.api.Test
    void getSolution() {
        testSolution.theAuthor = "Sudheer Reddy Kunduru";
        testAssignment.addSolution(testSolution);
        String result = testAssignment.getSolution("Sudheer Reddy Kunduru").theAuthor;
        assertEquals("Sudheer Reddy Kunduru", result);
    }

    @org.junit.jupiter.api.Test
    void getSuggestedSolution() {
        assertEquals(testAssignment.getSuggestedSolution().getClass(), new Solution().getClass());
    }

    @org.junit.jupiter.api.Test
    void getSolutionIterator() {
        SolutionIterator testSolutionIterator = testAssignment.getSolutionIterator();
        assertEquals(true,testSolutionIterator.solutionlist.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        String name = "SER 515 Unit Test Assignment";
        testAssignment.assignmentName = name;
        assertEquals(name, testAssignment.toString());
    }

    @org.junit.jupiter.api.Test
    void getDueDateString() {
        Date testDueDate = new Date();
        testAssignment.setDueDate(testDueDate);
        DateFormat testDateFormat = DateFormat.getDateInstance(DateFormat.SHORT);
        assertEquals(testDateFormat.format(testDueDate), testAssignment.getDueDateString());
    }

    @org.junit.jupiter.api.Test
    void accept() {
        testAssignment.accept(new ReminderVisitor());
        assertEquals(true, testAssignment.isAccepted);
    }
}