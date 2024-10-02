package com.github.curriculeon;

public class Student extends Person implements Learner {
    private double totalStudyTime;

    public Student(Long id, String name) {
        super(id, name);
    }

    @Override
    public final void setTotalStudyTime(double totalStudyTime) {
        this.totalStudyTime = totalStudyTime;
    }
    @Override
    public double getTotalStudyTime() {
        return totalStudyTime;
    }
}
