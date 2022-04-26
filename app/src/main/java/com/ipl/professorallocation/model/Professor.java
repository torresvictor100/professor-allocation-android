package com.ipl.professorallocation.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Professor{

	@SerializedName("allocations")
	private List<AllocationsItem> allocations;

	@SerializedName("name")
	private String name;

	@SerializedName("cpf")
	private String cpf;

	@SerializedName("id")
	private int id;

	@SerializedName("department")
	private Department department;

	public void setAllocations(List<AllocationsItem> allocations){
		this.allocations = allocations;
	}

	public List<AllocationsItem> getAllocations(){
		return allocations;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getCpf(){
		return cpf;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDepartment(Department department){
		this.department = department;
	}

	public Department getDepartment(){
		return department;
	}

	@Override
 	public String toString(){
		return 
			"Professor{" + 
			"allocations = '" + allocations + '\'' + 
			",name = '" + name + '\'' + 
			",cpf = '" + cpf + '\'' + 
			",id = '" + id + '\'' + 
			",department = '" + department + '\'' + 
			"}";
		}
}