package com.ipl.professorallocation.model;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Department{

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("area")
	private String area;

	@SerializedName("sigla")
	private String sigla;


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

	public String getArea(){ return area;}

	public void setArea(String area){ this.area = area; }

	public String getSigla(){return  sigla;}

	public void setSigla(){ this.sigla = sigla; }


	@Override
 	public String toString(){
		return name;
		}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Department that = (Department) o;
		return id == that.id ;
	}

}

