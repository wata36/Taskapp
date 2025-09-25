package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskDAO {

	public boolean create(Task task) {

		try (Connection conn = DBManager.getConnection()) {
			//　 　　　　SELECT文を準備　INSERT文
			String sql = "INSERT INTO `tasks` (user_id, tasks) VALUES (?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, task.getUserId());
			pStmt.setString(2, task.getTasks());

			//			SQLを実行し、更新された行数
			int result = pStmt.executeUpdate();
			//			登録が成功すればtrueを返す
			return result > 0;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Task> findAll(int userID) {
		List<Task> taskList = new ArrayList<>();
		try (Connection conn = DBManager.getConnection()) {
			String sql = "SELECT task_id, tasks FROM tasks WHERE user_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, userID);

			//SQL文を実行
			ResultSet rs = pStmt.executeQuery();

			//SELECT文の結果をArrayListに格納
			while (rs.next()) {
				int taskId = rs.getInt("task_id");
				String taskContent = rs.getString("tasks");
				Task task = new Task(taskId, taskContent);
				taskList.add(task);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return taskList;
	}

	public void delete(int taskId) {

		try (Connection conn = DBManager.getConnection()) {
			String sql = "DELETE FROM tasks WHERE task_id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, taskId);

			pStmt.executeUpdate(); // SQLを実行
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
