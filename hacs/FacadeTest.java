package hacs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FacadeTest {
    Facade testFacade = new Facade();
    ClassCourseList testCourseList = new ClassCourseList();
    UserInfoItem testUserInfoItem = new UserInfoItem();
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void login() {
    }

    @Test
    void addAssignment() {
    }

    @Test
    void viewAssignment() {
    }

    @Test
    void gradeSolution() {
    }

    @Test
    void reportSolutions() {
    }

    @Test
    void submitSolution() {
    }

    @Test
    void remind() {
    }

    @Test
    void createUser() {
        testUserInfoItem.userType = 0;
        testFacade.createUser(testUserInfoItem);
        assertEquals(testFacade.thePerson.getClass(), Student.class);
    }

    @Test
    void createCourseList() throws Exception {
        testFacade.createCourseList();
        assertEquals(3, testFacade.theCourseList.size());
    }

    @Test
    void attachCourseToUser() throws Exception {
        testUserInfoItem.userType = 0;
        testUserInfoItem.strUserName = "tutu";
        testFacade.createUser(testUserInfoItem);
        testFacade.createCourseList();
        testFacade.attachCourseToUser();
        testCourseList = testFacade.thePerson.courseList;
        assertEquals(2, testCourseList.size());
    }

    @Test
    void selectCourse() {
    }

    @Test
    void courseOperation() {
    }
}