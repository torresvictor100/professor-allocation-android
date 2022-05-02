package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

import java.time.LocalTime;

public class AllocationRequest {
    @SerializedName("courseId")
    private int courseId;
    @SerializedName("day")
    private String dayOfWeek;
    @SerializedName("start")
    private LocalTime startHour;
    @SerializedName("end")
    private LocalTime endHour;
    @SerializedName("professorId")
    private int professorId;

    public AllocationRequest(int courseId, String dayOfWeek, LocalTime startHour, LocalTime endHour, int professorId) {
        this.courseId = courseId;
        this.dayOfWeek = dayOfWeek;
        this.startHour = startHour;
        this.endHour = endHour;
        this.professorId = professorId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalTime getStartHour() {
        return startHour;
    }

    public void setStartHour(LocalTime startHour) {
        this.startHour = startHour;
    }

    public LocalTime getEndHour() {
        return endHour;
    }

    public void setEndHour(LocalTime endHour) {
        this.endHour = endHour;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }
}
