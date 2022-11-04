/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class ReminderVisitorTest {
    ReminderVisitor testReminderVisitor = new ReminderVisitor(new Reminder());
    @Test
    void visitFacade() {
    }

    @Test
    void testReminderVisitorReminder() {
        Assertions.assertNotEquals(null, testReminderVisitor.m_Reminder);
    }

    @Test
    void visitAssignment() {
        Assignment testAssignment = new Assignment();
        testAssignment.assignmentName = "SER515";
        testAssignment.setDueDate(new Date());
        testReminderVisitor.visitAssignment(testAssignment);
    }
}