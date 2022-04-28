package com.ipl.professorallocation.model.curso;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Curso{

	@SerializedName("allocations")
	private List<AllocationsItem> allocations;

	@SerializedName("name")
	private String name;

	@SerializedName("sigla")
	private String sigla;


	@SerializedName("id")
	private int id;

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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public String getSigla(){
		return sigla;
	}

	public void setSigla(String sigla){ this.sigla = sigla; }

	@Override
 	public String toString(){
		return name;
	}
}