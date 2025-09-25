package service;

import java.util.List;

import dao.TaskDAO;
import model.Task;

//タスク空ではないか？　
//削除するタスクがログイン中のユーザーのものか？
public class TaskLogic {
	
//タスクが空かnullの場合の処理	
	public boolean execute(Task task) {
		TaskDAO tdao = new TaskDAO();
		if (task.getTasks() != null || task.getTasks().isEmpty()) {
			return false;
		}
			boolean result = tdao.create(task);
			return result;
		}
	
//タスク取得リスト処理	
	public List<Task> execute(){
		TaskDAO dao =new TaskDAO();
		List<Task> tasklist =dao.findAll();
		return tasklist;
	}
//削除メソッド	
	public void delete(int taskId) {
		TaskDAO dao =new TaskDAO();
		dao.delete(taskId);
	}
	
	}

