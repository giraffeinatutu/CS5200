package entities;

public class User extends Person{
	private int id;
	private String userKey;
	
	public User() {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getUserkey(){
		return userKey;
	}

	public void setUserkey(String userKey){
		this.userKey=userKey;
	}
	
	public int getPersonId() {
		return super.id;
	}

	public void setPersonId(int id) {
		super.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		super.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		super.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		super.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		super.password = password;
	}

	public String getEmail() {
		return email;
	}
}

