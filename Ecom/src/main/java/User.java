
public class User {

	public User(String username, String password, String email, String mobilenumber, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobilenumber = mobilenumber;
		this.gender = gender;
	}
	protected String username;
	protected String password;
	protected String email;
	protected String mobilenumber;
	protected String gender;
	public String getUsername() {
		return username;
	}
	public void setName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

}
