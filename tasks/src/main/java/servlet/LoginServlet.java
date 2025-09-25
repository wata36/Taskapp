package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Login;
import model.UserAccount;
import service.UserLoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("top.jsp");
	      dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String nextPage = "";
//		分岐
		String next = request.getParameter("next");
		HttpSession session = request.getSession();
		System.out.println(next);
		
		switch(next) {
		case "login" ->{
//			フォーム入力したログイン名とパスワードの取得
			String name = request.getParameter("name");
			String password = request.getParameter("password");

			// ログイン処理の実行
		    Login login = new Login(name, password);
		    UserLoginLogic bo = new UserLoginLogic();
		    UserAccount account = bo.execute(login);
		    System.out.println(account);

		    // ログイン処理の成否によって処理を分岐
		    if (account != null) { // ログイン成功時
		    	    // セッションにユーザー情報保存
		    	    session.setAttribute("account", account);

		    	    // タスク管理画面へフォワード
		    	    nextPage = "WEB-INF/jsp/tasks.jsp";
		    } else { // ログイン失敗時
		      // エラーメッセージ
		     	login = new Login();
		     	login.setErrorMsg("ユーザー名またはパスワードが違います");
//				エラーメッセージをリクエストスコープに保存
		     	request.setAttribute("login",login);
		     	nextPage ="top.jsp";
				}
		}
		case "logout" ->{
			//セッション破棄してTOPへ戻す
			session.invalidate();
			nextPage ="top.jsp";
		}
		}
		//サーブレットからJSPに処理を渡して画面を表示
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(nextPage);
				dispatcher.forward(request,response);
	}

	}
