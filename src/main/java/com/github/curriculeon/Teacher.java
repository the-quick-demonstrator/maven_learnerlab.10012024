package com.github.curriculeon;

public interface Teacher {
    default void teach(Learner learner, double numberOfHoursToTeach) {
        learner.learn(numberOfHoursToTeach);
    }

    default void lecture(Learner[] learners, double numberOfHoursToTeach) {
        double numberOfHoursPerLearner = numberOfHoursToTeach / learners.length;
        for (int i = 0; i < learners.length; i++) {
            teach(learners[i], numberOfHoursPerLearner);
        }
    }
}
