package ru.job4j.collection.job_sort;

import java.util.Comparator;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class JobTest {

    @Test
    public void whenComparatorByNameAscAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, Matchers.greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDescAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, Matchers.lessThan(0));
    }

    @Test
    public void whenComparatorByNameAscAndPriorityDesc() {
        Comparator<Job> cmpNamePriority = new JobAscByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, Matchers.greaterThan(0));
    }

    @Test
    public void whenComparatorByNameDescAndPriorityAsc() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobAscByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Assert.assertThat(rsl, Matchers.lessThan(0));
    }

}