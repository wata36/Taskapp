package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Task;
import model.UserAccount;
import service.TaskLogic;

/**
 * Servlet implementation class TaskServlet
 */
@WebServlet("/TaskServlet")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//      ユーザー情報を取得		
		HttpSession session = request.getSession();
		UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");
		//      ログインしているか確認
		if (loginUser == null) {
			response.sendRedirect("LoginServlet");
			return;
		}
		
		int userId = loginUser.getUserId();
	    TaskLogic taskLogic = new TaskLogic();
	    java.util.List<model.Task> taskList = taskLogic.findAll(userId);
	    request.setAttribute("taskList", taskList); // リストをJSPに渡す

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tasks.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String nextPage = "WEB-INF/jsp/tasks.jsp";

		// ユーザー情報（userId）を取得
        HttpSession session = request.getSession();
        UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");

		// ログインチェック（必須）
        if (loginUser == null) {
        	response.sendRedirect("LoginServlet");
        	return;
        }
        TaskLogic taskLogic = new TaskLogic(); 

        switch (action) {
		case "add" -> {
			// タスク名を取得
			String tasks = request.getParameter("tasks");

			int userId = loginUser.getUserId();
			System.out.println("DEBUG: ログインユーザーID: " + userId);
			
			Task task = new Task(userId, tasks);

			boolean isSuccess = taskLogic.create(task);

			if (!isSuccess) {
				request.setAttribute("errorMsg", "タスクの登録に失敗しました。内容を確認してください。");
			}
		}

		case "delete" -> {
			// 1. 削除対象のタスクIDを取得
			String taskIdStr = request.getParameter("taskId");

			// 2. IDが有効な数値かチェック
			if (taskIdStr != null && !taskIdStr.isEmpty()) {
				try {
					int taskId = Integer.parseInt(taskIdStr);

					// 3. TaskLogicを呼び出して削除を実行
					taskLogic.delete(taskId);

				} catch (NumberFormatException e) {
					// IDが数値でない場合の処理
					request.setAttribute("errorMsg", "無効なタスクIDが指定されました。");
				}
			} else {
				request.setAttribute("errorMsg", "削除対象のタスクが特定できませんでした。");
			}
		}
		default -> {
			request.setAttribute("errorMsg", "無効な操作が指定されました。");
		}
	} 

	// 処理後、タスク一覧を再表示するために doGet に処理を委譲
	doGet(request, response);
}
}
