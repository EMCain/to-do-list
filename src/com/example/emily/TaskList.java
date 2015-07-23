package com.example.emily;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
	private List<Task> mTasks;
	
	public TaskList() {
		mTasks = new ArrayList<Task>();
	}
	
	public void addTask(Task task) {
		mTasks.add(task);
	}
	
	public Task getTask(int index){
		Task task = mTasks.get(index);
		return task;
	}
	
	public int getTaskCount(){
		return mTasks.size();
	}
	
	public void removeTask(Task task){
		mTasks.remove(task);
	}
}
