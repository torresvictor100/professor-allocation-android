package com.ipl.professorallocation.model.curso;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Department{

	@SerializedName("name")
	private String name;

	@SerializedName("professors")
	private List<Object> professors;

	@SerializedName("id")
	private int id;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setProfessors(List<Object> professors){
		this.professors = professors;
	}

	public List<Object> getProfessors(){
		return professors;
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
			"Department{" + 
			"name = '" + name + '\'' + 
			",professors = '" + professors + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}