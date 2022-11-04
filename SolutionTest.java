import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SolutionTest {
    Solution testSolution = new Solution();

    @Test
    void testToString() {
        testSolution.theAuthor = "Sudheer Reddy Kunduru";
        testSolution.solutionFileName = "Result";
        Assertions.assertEquals("Sudheer Reddy Kunduru Result Grade=0 not reported",testSolution.toString());
    }

    @Test
    void getGradeString() {
        Assertions.assertEquals("-1",testSolution.getGradeString());
    }

    @Test
    void getGradeInt() {
        Assertions.assertEquals(0,testSolution.getGradeInt());
    }

    @Test
    void setReported() {
        testSolution.setReported(true);
        Assertions.assertEquals(true,testSolution.isReported());
    }

    @Test
    void isReported() {
        testSolution.setReported(false);
        Assertions.assertEquals(false,testSolution.isReported());
    }
}