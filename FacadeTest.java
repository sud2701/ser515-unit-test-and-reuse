/**
 * @author Sudheer Reddy Kunduru
 * @version 1.0
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void createUser() {
        testUserInfoItem.userType = 0;
        testFacade.createUser(testUserInfoItem);
        Assertions.assertEquals(testFacade.thePerson.getClass(), Student.class);
    }

    @Test
    void createCourseList() {
        testFacade.createCourseList();
        Assertions.assertEquals(3, testFacade.theCourseList.size());
    }

    @Test
    void attachCourseToUser() throws Exception {
        testUserInfoItem.userType = 0;
        testUserInfoItem.strUserName = "pepe";
        testFacade.createUser(testUserInfoItem);
        testFacade.createCourseList();
        testFacade.attachCourseToUser();
        testCourseList = testFacade.thePerson.courseList;
        Assertions.assertEquals(0, testCourseList.size());
    }

}