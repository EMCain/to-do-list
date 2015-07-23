package com.example.emily;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Project {
	private String mName;
	private Date mCreationDate;
	private Date mLastModified;
	private List<Task> tasksOfProject;
	
	public Project(String name){ 
		mName = name;
		mCreationDate = new Date();
		mLastModified = new Date();
		tasksOfProject = new ArrayList<Task>();
	}

	public void createTask(String taskName){
		Task theTask = new Task(taskName, this);
		mLastModified = new Date();
		tasksOfProject.add(theTask);
	}
	
	public Task get(int position) {
		Task task = tasksOfProject.get(position);
		return task;
	}
	
	public Task get(String name) {
		int i = 0;
		int position = -1;
		for (Task task : tasksOfProject){
			if (!task.getName().equals(name)){
				i++;
			} else {
				position = i;
			}
		}
		return tasksOfProject.get(position);
	}
	
	public void removeTask(Task task){
		int index = tasksOfProject.indexOf(task);
		tasksOfProject.remove(index);
	}
	
	public void removeTask(String name){
		Task task = get(name);
		removeTask(task);
	}
	
	public String getName(){
		return mName;
	}
	
	public Date getCreationDate(){
		return mCreationDate;
	}
	
	public Date getLastModified(){
		return mLastModified;
	}
	
	public List<Task> taskList() {
		return tasksOfProject;
	}
	
	@Override
	public String toString() {
		String theString;
		theString = "Project " + mName + " has tasks ";
		int count = tasksOfProject.size()-1;
		
		
		if(count > 1){
			for(int i = 0; i < count ; i++){
				theString = theString + tasksOfProject.get(i).getName() + ", ";
			}
			theString = theString + "and " + tasksOfProject.get(count).getName() + ".";
		} else if (count == 1) {
			for(int i = 0; i < count ; i++){
				theString = theString + tasksOfProject.get(i).getName();
			}
			theString = theString + " and " + tasksOfProject.get(count).getName() + ".";
		} else if (count == 0) {
			theString = "Project " + mName + " has task " + tasksOfProject.get(0).getName() + ". ";
		}
		else {
			theString = "Project " + mName + " has no tasks.";
 		}
		return theString;
	}
	
}
