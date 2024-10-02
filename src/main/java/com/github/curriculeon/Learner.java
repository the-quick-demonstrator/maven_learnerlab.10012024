package com.github.curriculeon;

public interface Learner {
    default void learn(double numberOfHours) {
        setTotalStudyTime(getTotalStudyTime() + numberOfHours);
    }

    void setTotalStudyTime(double totalStudyTime);

    double getTotalStudyTime();
}
