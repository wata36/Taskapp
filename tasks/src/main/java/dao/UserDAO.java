package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Login;
import model.UserAccount;

public class UserDAO {
	//	ユーザーログインの確認処理
	public UserAccount findByLogin(Login login) {
		UserAccount account = null;
		//		DBManagerからgetc()メソッドでSQL接続　成功すれば
		try (Connection conn = DBManager.getConnection()) {

			// SELECT文を準備
			String sql = "SELECT USER_ID, USER_NAME FROM users WHERE USER_NAME = ? AND PASSWORD = ?;";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, login.getName());
			pStmt.setString(2, login.getPassword());

			// SELECT文を実行し、結果表（ResultSet）を取得
			ResultSet rs = pStmt.executeQuery();

			// 結果表に格納されたレコードの内容を表示
			if (rs.next()) {
				int userId = rs.getInt("USER_ID");
				String name = rs.getString("USER_NAME");
				account = new UserAccount(userId, name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

}
