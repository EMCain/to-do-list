package com.example.emily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ToDo {
	
	private BufferedReader mReader;
	private Map<String, String> mMenu;
	private Project mCurrentProject;
	private ProjectList mProjectList;
	
	public ToDo(){
		mReader = new BufferedReader(new InputStreamReader(System.in));
		mProjectList = new ProjectList();
		try{
			mCurrentProject = mProjectList.getProject(0);
		} catch(IOException ioe) {
			System.out.println("Error " + ioe);
		}
		mMenu = new HashMap<String, String>();
		mMenu.put("np", "Add a new project");
		mMenu.put("nt", "Add a new task");
		mMenu.put("lt", "list tasks in this project");
		mMenu.put("lp", "lists all projects");
		mMenu.put("cp", "change project");
		mMenu.put("dt", "destroy a task in this project");
		mMenu.put("dp", "destroy this project");
		mMenu.put("quit", "leave the program");
	}
	
	public String promptAction() throws IOException { 
		System.out.println("--------------------------------");
		System.out.println("What do you want to do?  ");
		for(Map.Entry<String, String> option : mMenu.entrySet()){
			System.out.printf("%s - %s %n", option.getKey(), option.getValue());
		}
		System.out.println("Please enter your choice here:  ");
		String choice = mReader.readLine().trim().toLowerCase();
		return choice;
		
	}
	
	public void setProject(String name){
		
		try{
			mCurrentProject = mProjectList.getProject(name);
		} catch(IOException ioe) {
			System.out.println("Error: " + ioe);
		}
	}
	
	public void run(){
		String choice = new String();
		System.out.println("--------------------------------");
		System.out.println("~~ Welcome to the To-Do List! ~~");
		do {
				try{
					choice = promptAction();
					switch(choice) {
					case("np"):
						System.out.println("What is the name of the project you want to create?");
						String projName = mReader.readLine().trim();
						mProjectList.createProject(projName);
						System.out.printf("Created project %s. %n", projName);
						setProject(projName);
						System.out.printf("Switched to project %s. %n", mCurrentProject.getName());
						break;
					case("nt"):
						System.out.printf("What task do you want to add to project %s? %n", mCurrentProject.getName());
						String taskName = mReader.readLine().trim();
						mCurrentProject.createTask(taskName);
						System.out.printf("Added task %s to project %s. %n", taskName, mCurrentProject.getName());
						break;
					case("lt"):
						System.out.println(mCurrentProject.toString());
						break;
					case("lp"):
						for(Project project : mProjectList.getProjectList()){
							System.out.println(project.toString());
						}
						break;
					case("cp"):
						System.out.printf("What project do you want to switch to? %n");
						String projChoice = mReader.readLine().trim();
						setProject(projChoice);
						System.out.printf("Set current project to %s. %n", mCurrentProject.getName());
						break;
					case("dt"):
						System.out.printf("What task in project %s do you want to destroy? %n", mCurrentProject.getName());
						String taskChoice = mReader.readLine().trim();
						mCurrentProject.removeTask(taskChoice);
						System.out.printf("Destroyed task %s in project %s. %n", taskChoice, mCurrentProject.getName());
						break;
					case("dp"):
						String theProject = mCurrentProject.getName();
						mProjectList.remove(mCurrentProject);
						try{
							mCurrentProject = mProjectList.getProject(0);
						} catch(IOException ioe) {
							System.out.println("Error " + ioe);
						}
						System.out.printf("Destroyed project %s. %n", theProject);
						break;
					case("quit") :
						System.out.println("--------------------------------");
						System.out.println("Thanks for using the To-Do List!");
						System.out.println("--------------------------------");
						break;
					default :
						System.out.printf("Unknown choice: '%s'. Please try again. %n", choice);
						
					
					}
				} catch(IOException ioe) {
					System.out.println("Problem with input");
					ioe.printStackTrace();
				}
			}
			while (!choice.equals("quit"));
	
	} 
	
				
	}
	

