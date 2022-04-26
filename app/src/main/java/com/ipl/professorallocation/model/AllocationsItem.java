package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

public class AllocationsItem{

	@SerializedName("endHour")
	private String endHour;

	@SerializedName("professor")
	private Professor professor;

	@SerializedName("dayOfWeek")
	private String dayOfWeek;

	@SerializedName("startHour")
	private String startHour;

	@SerializedName("course")
	private Course course;

	@SerializedName("id")
	private int id;

	public void setEndHour(String endHour){
		this.endHour = endHour;
	}

	public String getEndHour(){
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

	public void setStartHour(String startHour){
		this.startHour = startHour;
	}

	public String getStartHour(){
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