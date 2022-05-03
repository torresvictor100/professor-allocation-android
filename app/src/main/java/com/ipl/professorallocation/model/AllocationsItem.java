package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalTime;

public class AllocationsItem implements Serializable {

	@SerializedName("end")
	private LocalTime endHour;

	@SerializedName("professor")
	private Professor professor;

	@SerializedName("day")
	private String dayOfWeek;

	@SerializedName("start")
	private LocalTime startHour;

	@SerializedName("course")
	private Course course;

	@SerializedName("id")
	private int id;

	public void setEndHour(LocalTime endHour){
		this.endHour = endHour;
	}

	public LocalTime getEndHour(){
		return endHour;
	}

	public void setProfessor(Professor professor){
		this.professor = professor;
	}

	public Professor getProfessor(){
		return professor;
	}

	public void setDayOfWeek(String dayOfWeek){
		this.dayOfWeek = dayOfWeek;
	}

	public String getDayOfWeek(){
		return dayOfWeek;
	}

	public void setStartHour(LocalTime startHour){
		this.startHour = startHour;
	}

	public LocalTime getStartHour(){
		return startHour;
	}

	public void setCourse(Course course){
		this.course = course;
	}

	public Course getCourse(){
		return course;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"AllocationsItem{" + 
			"endHour = '" + endHour + '\'' + 
			",professor = '" + professor + '\'' + 
			",dayOfWeek = '" + dayOfWeek + '\'' + 
			",startHour = '" + startHour + '\'' + 
			",course = '" + course + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}