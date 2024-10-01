package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

public class TestStudent {
    // given
    private void testLearn(double numberOfHoursToLearn) {
        final Student student = new Student(null, null);
        final double preStudyTime = student.getTotalStudyTime();
        final double expectedTotalStudyTime = preStudyTime + numberOfHoursToLearn;
        Assert.assertNotEquals(expectedTotalStudyTime, preStudyTime);

        // when
        student.learn(numberOfHoursToLearn);

        // then
        Assert.assertEquals(expectedTotalStudyTime, student.getTotalStudyTime());
    }
    @Test
    public void testLearnWith10() {
        testLearn(10);
    }

    @Test
    public void testLearnWith15() {
        testLearn(15);
    }


    @Test
    public void testImplementation() {
        // given
        final Student student = new Student(null, null);

        // when
        final boolean isLearner = student instanceof Learner;

        // then
        Assert.assertTrue(isLearner);
    }
    @Test
    public void testInheritance() {
        // given
        final Student student = new Student(null, null);

        // when
        final boolean isPerson = student instanceof Person;

        // then
        Assert.assertTrue(isPerson);
    }
}
