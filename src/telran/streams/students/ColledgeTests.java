package telran.streams.students;

import static org.junit.jupiter.api.Assertions.*;

import java.util.IntSummaryStatistics;

import org.junit.jupiter.api.Test;

class ColledgeTests {
    private static final String NAME1 = "Alice";
    private static final String NAME2 = "Bob";
    private static final String NAME3 = "Charlie";
    private static final int HOURS1 = 100;
    private static final int HOURS2 = 100;
    private static final int HOURS3 = 150;
    private static final int[] MARKS1 = {60, 70, 80};
    private static final int[] MARKS2 = {60, 60, 60};
    private static final int[] MARKS3 = {70, 80, 90};

    Student st1 = new Student(NAME1, HOURS1, MARKS1);
    Student st2 = new Student(NAME2, HOURS2, MARKS2);
    Student st3 = new Student(NAME3, HOURS3, MARKS3);
    Colledge colledge = new Colledge(new Student[] {st1, st2, st3});

    @Test
    void sortTest() {
        Student[] expected = {st3, st1, st2};
        assertArrayEquals(expected, Colledge.sortStudents(colledge));
    }

    @Test
    void summaryStatisticsHoursTest() {
        IntSummaryStatistics iss = Colledge.getHoursStatistics(colledge);
        assertEquals(100, iss.getMin());
        assertEquals(150, iss.getMax());
        assertEquals(350, iss.getSum());
    }

    @Test 
    void summaryStatisticsMarksTest() {
        IntSummaryStatistics iss = Colledge.getMarksStatistics(colledge);
        assertEquals(60, iss.getMin());
        assertEquals(90, iss.getMax());
    }
}
