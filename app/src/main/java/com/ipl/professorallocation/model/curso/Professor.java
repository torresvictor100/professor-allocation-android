package com.ipl.professorallocation.model.curso;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Professor{

	@SerializedName("allocations")
	private List<Object> allocations;

	@SerializedName("cpf")
	private String cpf;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("department")
	private Department department;

	public void setAllocations(List<Object> allocations){
		this.allocations = allocations;
	}

	public List<Object> getAllocations(){
		return allocations;
	}

	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	public String getCpf(){
		return cpf;
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
			",cpf = '" + cpf + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",department = '" + department + '\'' + 
			"}";
		}
}