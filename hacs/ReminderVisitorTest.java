package hacs;

import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReminderVisitorTest {
    ReminderVisitor testReminderVisitor = new ReminderVisitor(new Reminder());
    @Test
    void visitFacade() {
    }

    @Test
    void testReminderVisitorReminder() {
        assertNotEquals(null, testReminderVisitor.m_Reminder);
    }

    @Test
    void visitAssignment() {
        Assignment testAssignment = new Assignment();
        testAssignment.assignmentName = "SER515";
        testAssignment.setDueDate(new Date());
        testReminderVisitor.visitAssignment(testAssignment);
    }
}