package com.example.emily;

import java.util.Date;

public class Task {
	private String mName;
	private Project mProject;
	private Date mCreationDate;
	
	public Task(String name, Project project){
		mName = name;
		mProject = project;
		mCreationDate = new Date();	
	}
	
	public String getName() {
		return mName;
	}
	
	public Project getProject() {
		return mProject;
	}
	
	public Date getCreationDate() {
		return mCreationDate;
	}
	
}