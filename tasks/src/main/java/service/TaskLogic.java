package service;

import java.util.List;

import dao.TaskDAO;
import model.Task;

//タスク空ではないか？　
//削除するタスクがログイン中のユーザーのものか？
public class TaskLogic {

	//タスクが空かnullの場合の処理	
	public boolean create(Task task) {
		TaskDAO tdao = new TaskDAO();
		if (task == null || task.getTasks() == null || task.getTasks().isEmpty()) {
			return false;
		}
		boolean result = tdao.create(task);
		return result;
	}

	//タスク取得リスト処理	
	public List<Task> findAll(int userId) {
		TaskDAO dao = new TaskDAO();
		List<Task> tasklist = dao.findAll(userId);
		return tasklist;
	}

	//削除メソッド	
	public void delete(int taskId) {
		TaskDAO dao = new TaskDAO();
		dao.delete(taskId);
	}

}
