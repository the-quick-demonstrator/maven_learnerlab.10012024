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
        final Map<Learner, Double> preStudyTimeMap = new HashMap<>();
        final double expectedNumberOfHoursPerStudent = numberOfHours/learners.length;
        for (int i = 0; i < learners.length; i++) {
            learners[i] = new Student(null, null);
            final Learner learner = learners[i];
            Assert.assertEquals(0, learner.getTotalStudyTime(), 0.0001);
            learner.learn(expectedNumberOfHoursPerStudent);
            preStudyTimeMap.put(learner, learner.getTotalStudyTime());
            Assert.assertEquals(preStudyTimes[i], learner.getTotalStudyTime(), 0.0001);
        }

        // when
        instructor.lecture(learners, numberOfHours);

        // then
        final Map<Learner, Double> postStudyTimeMap = new HashMap<>();
        for (int i = 0; i < learners.length; i++) {
            final Learner learner = learners[i];
            learner.learn(expectedNumberOfHoursPerStudent);
            final double postStudyTime = learner.getTotalStudyTime();
            postStudyTimeMap.put(learner, postStudyTime);
            final Double preStudyTime = preStudyTimeMap.get(learner);
            final double expectedStudyTime = preStudyTime + expectedNumberOfHoursPerStudent;
            final double actualStudyTime = preStudyTime + postStudyTime;
            Assert.assertEquals(expectedStudyTime, actualStudyTime);
        }
    }

    @Test
    public void testLecture() {
        //given
        int numberOfHours = 15;
        double[] preStudyTimes = {17.0, 12.0, 11.0, 89.0, 100.0};
        testLecture(15, preStudyTimes);
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
