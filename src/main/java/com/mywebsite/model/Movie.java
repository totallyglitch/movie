package com.mywebsite.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.mywebsite.common.Constants;

@Entity
@Table(name = Constants.TableNames.T_MOVIE)
public class Movie extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int rowId;
	
	@Column(name = "Name")
	private String name;
	
	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return "Movie";
	}
	
	@Override
	public String getTableName() {
		return Constants.TableNames.T_MOVIE;
	}
}
