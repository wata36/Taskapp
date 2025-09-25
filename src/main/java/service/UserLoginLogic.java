package service;

import dao.UserDAO;
import model.Login;
import model.UserAccount;

public class UserLoginLogic {
public UserAccount execute(Login login) {
	UserDAO dao =new UserDAO();
	UserAccount account = dao.findByLogin(login);
	System.out.println(account);
    return account;
}

}
