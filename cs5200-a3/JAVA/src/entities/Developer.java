package entities;

public class Developer extends Person {
	protected int developerId;
	protected String developerKey;
	
	
	public Developer() {

	}
	
	public Developer(int id, String key, String user, String pass, String first, 
			String last, String email, String type, String dob){
		this.developerId = id;
		this.developerKey = key;
		super.id = id;
		super.username = user;
		super.password = pass;
		super.firstName = first;
		super.lastName = last; 
		super.type = type; 
		super.email = email; 
		super.dob = dob;
		
	}

	public Developer(int id, String user, String pass, String first, String last, String email, String dob,
			String key) {
		this.developerId = id;
		this.developerKey = key;
		super.id = id;
		super.username = user;
		super.password = pass;
		super.firstName = first;
		super.lastName = last; 
		super.email = email; 
		super.dob = dob;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.developerId = id;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperkey(String developerKey) {
		this.developerKey = developerKey;
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

	public void setEmail(String email) {
		super.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		super.dob = dob;
	}
}