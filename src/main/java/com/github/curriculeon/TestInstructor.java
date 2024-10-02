package com.github.curriculeon;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class TestInstructor {
    // given
    private void testLecture(final double numberOfHours, final double... preStudyTimes) {
        final Instructor instructor = new Instructor(null, null);
        final Learner[] learners = new Student[preStudyTimes.length];
        final double expectedNumberOfHoursPerStudent = numberOfHours/learners.length;
        final double[] expectedPostStudyTimes = new double[preStudyTimes.length];
        for (int i = 0; i < learners.length; i++) {
            final Student learner = new Student(null, null);
            Assert.assertEquals(0, learner.getTotalStudyTime(), 0.0001);
            learner.learn(preStudyTimes[i]);
            Assert.assertEquals(preStudyTimes[i], learner.getTotalStudyTime(), 0.0001);
            final double expectedPostStudyTime = learner.getTotalStudyTime() + expectedNumberOfHoursPerStudent;
            learners[i] = learner;
            expectedPostStudyTimes[i] = expectedPostStudyTime;
        }

        // when
        instructor.lecture(learners, numberOfHours);

        // then
        for (int i = 0; i < learners.length; i++) {
            final Learner learner = learners[i];
            final double expectedStudyTime = expectedPostStudyTimes[i];
            final double actualStudyTime = learner.getTotalStudyTime();
            Assert.assertEquals(expectedStudyTime, actualStudyTime, 0.0);
        }
    }

    @Test
    public void testLecture1() {
        //given
        testLecture(15, 0.0, 17.0, 12.0, 11.0, 89.0, 100.0);
    }
    @Test
    public void testLecture2() {
        //given
        testLecture(20, 0.0, 25.0, 16.0, 39.0, 17.5, 167.0);
    }

    private Learner testTeach(final Double preStudyTime, final double numberOfHours) {
        final Instructor instructor = new Instructor(null, null);
        final Learner learner = new Student(null, null);
        final double expectedStudyTime = learner.getTotalStudyTime() + numberOfHours;
        learner.learn(preStudyTime);

        // when
        instructor.teach(learner, numberOfHours);

        // then
        final double actualStudyTime = learner.getTotalStudyTime();
        Assert.assertEquals(expectedStudyTime, actualStudyTime);
        return learner;
    }

    @Test
    public void testTeachWithPreTaughtLearner1() {
        // given
        testTeach(10.0, 15);
    }

    @Test
    public void testTeachWithPreTaughtLearner() {
        // given
        testTeach(null, 10);
    }
}
