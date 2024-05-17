package telran.streams.students;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.IntSummaryStatistics;
import java.util.stream.Stream;

public class Colledge implements Iterable<Student> {
    Student[] students;

    public Colledge(Student[] students) {
        this.students = Arrays.copyOf(students, students.length);
    }

    private class ColledgeIterator implements Iterator<Student> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < students.length;
        }

        @Override
        public Student next() {
            return students[index++];
        }
    }

    @Override
    public Iterator<Student> iterator() {
        return new ColledgeIterator();
    }

    public Stream<Student> stream() {
        return Arrays.stream(students);
    }

    public static Student[] sortStudents(Colledge col) {
        return col.stream()
                .sorted(Comparator
                        .comparingDouble((Student s) -> Arrays.stream(s.marks()).average().orElse(0))
                        .thenComparingInt(Student::hours)
                        .reversed())
                .toArray(Student[]::new);
    }

    public static IntSummaryStatistics getHoursStatistics(Colledge col) {
        return col.stream()
                .mapToInt(Student::hours)
                .summaryStatistics();
    }

    public static IntSummaryStatistics getMarksStatistics(Colledge col) {
        return col.stream()
                .flatMapToInt(s -> Arrays.stream(s.marks()))
                .summaryStatistics();
    }
}
