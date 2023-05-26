package day4;

public class LoginBean {
	private String id;
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean dbCheck() {
		if (id.equals("bae") && password.equals("123"))
			return true;
		else
			return false;
	}
}