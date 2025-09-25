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
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      ユーザー情報を取得		
		HttpSession session = request.getSession();
		UserAccount loginUser = (UserAccount) session.getAttribute("loginUser");

		if (loginUser == null) {
			response.sendRedirect("LoginServlet");
			return;
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/tasks.jsp");
		dispatcher.forward(request, response);
	}	
 
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        String nextPage = "WEB-INF/jsp/tasks.jsp";
        
        switch(action) {
        case "add" ->{
 //     タスク名を取得
        String tasks = request.getParameter("tasks");
        
//      
        }
	}

}
