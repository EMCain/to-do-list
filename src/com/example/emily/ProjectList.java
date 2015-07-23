package com.example.emily;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;


public class ProjectList {
	private List<Project> theProjects;
	public Project mDefaultProject;
	
	public ProjectList() {
		theProjects = new ArrayList<Project>();
		mDefaultProject = new Project("Uncategorized Tasks");
		theProjects.add(mDefaultProject);
	}
	
	public List<Project> getProjectList() {
		return theProjects;
	}
	
	public void add(Project project) {
		theProjects.add(project);
	}
	
	public void createProject(String name){
		Project project = new Project(name);
		theProjects.add(project);
	}

	
	public Project getProject(int position) throws IOException{
		Project project = theProjects.get(position);
		if(position < 0) {
			throw new IOException("Project does not exist");
		}
		return project;
	}
	
	public Project getProject(String name) throws IOException{
		int i = 0;
		int position = -1;
		for (Project project : theProjects){
			if (project.getName().equals(name)){
				position = i;
			} else {
				i++;
			}
		}
		return getProject(position);
	}
	
	public void remove(Project project) {
		int index = theProjects.indexOf(project);
		if(index == 0) {
			System.out.println("Cannot delete 'uncategorized tasks' project, try again");
		}
		else {
			theProjects.remove(project);
		}
	}
	
	public void remove(int position){
		Project project = theProjects.get(position);
		remove(project);
	}
	
	public void remove(String projName) {
		int position = theProjects.indexOf(projName);
		remove(position);
	}
	
}
