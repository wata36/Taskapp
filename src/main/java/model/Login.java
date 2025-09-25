package model;

public class Login {
	private String name;
	private String password;
	//ログインエラー用
	private String errorMsg;

	public Login() {
	}

	public Login(String name, String passward) {
		this.name = name;
		this.password = passward;
	}

	public Login(String name, String passward, String errorMsg) {
		this.name = name;
		this.password = passward;
		this.errorMsg = errorMsg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassward(String passward) {
		this.password = passward;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

}
