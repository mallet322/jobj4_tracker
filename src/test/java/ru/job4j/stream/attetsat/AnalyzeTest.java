package ru.job4j.stream.attetsat;

import java.util.List;
import java.util.stream.Stream;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class AnalyzeTest {

    @Test
    public void whenSinglePupil() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100)))
                )
        );
        Assert.assertThat(average, Matchers.is(100D));
    }

    @Test
    public void whenPupilAverage() {
        double average = Analyze.averageScore(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60)))
                )
        );
        Assert.assertThat(average, Matchers.is(80D));
    }

    @Test
    public void whenListOfPupilAverage() {
        List<Tuple> average = Analyze.averageScoreBySubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                                    new Subject("Lang", 60))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                                    new Subject("Lang", 30)))
                )
        );
        Assert.assertThat(average, Matchers.is(List.of(
                new Tuple("Ivanov", 80),
                new Tuple("Petrov", 45D)
        )));
    }

    @Test
    public void whenListOfSubjectAverage() {
        List<Tuple> average = Analyze.averageScoreByPupil(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                                    new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                                    new Subject("Lang", 60)))
                )
        );
        Assert.assertThat(average, Matchers.is(List.of(
                new Tuple("Math", 80D),
                new Tuple("Lang", 80D)
        )));
    }

    @Test
    public void whenBestPupil() {
        Tuple best = Analyze.bestStudent(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                                    new Subject("Lang", 100))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                                    new Subject("Lang", 60)))
                )
        );
        Assert.assertThat(best, Matchers.is(new Tuple("Ivanov", 200D)));
    }

    @Test
    public void whenBestSubject() {
        Tuple best = Analyze.bestSubject(
                Stream.of(
                        new Pupil("Ivanov", List.of(new Subject("Math", 100),
                                                    new Subject("Lang", 40))),
                        new Pupil("Petrov", List.of(new Subject("Math", 60),
                                                    new Subject("Lang", 60)))
                )
        );
        Assert.assertThat(best, Matchers.is(new Tuple("Math", 160D)));
    }

}