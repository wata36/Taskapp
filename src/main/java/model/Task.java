package model;

import java.io.Serializable;

public class Task implements Serializable {

	private int taskId;
	private int userId;
	private String tasks;

	public Task() {
	}

	public Task(int taskId, int userId, String tasks) {
		super();
		this.taskId = taskId;
		this.userId = userId;
		this.tasks = tasks;
	}

	public Task(int taskId, String tasks) {
		this.taskId = taskId;
		this.tasks = tasks;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTasks() {
		return tasks;
	}

	public void setTasks(String tasks) {
		this.tasks = tasks;
	}

}
