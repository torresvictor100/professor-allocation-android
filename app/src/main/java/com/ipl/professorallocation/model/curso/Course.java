package com.ipl.professorallocation.model.curso;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Course{

	@SerializedName("allocations")
	private List<Object> allocations;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setAllocations(List<Object> allocations){
		this.allocations = allocations;
	}

	public List<Object> getAllocations(){
		return allocations;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
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
			"Course{" + 
			"allocations = '" + allocations + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			"}";
		}
}