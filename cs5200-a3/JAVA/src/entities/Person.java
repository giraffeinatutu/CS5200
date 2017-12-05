package entities;
import java.util.Collection;

public class Person {
		protected int id;
		protected String firstName;
		protected String lastName;
		protected String username;
		protected String password;
		protected String type;
		protected String email;

		protected String dob;
		
		Collection<User> users;
		Collection<Developer> developers;
		
		
		public Person() {
			super();
		}
		
		public Person(int id, String user, String pass, String first, 
				String last, String email, String type, String dob) {
			super();
			this.id = id;
			this.username = user;
			this.password = pass;
			this.firstName = first;
			this.lastName = last;
			this.type = type;
			this.email = email;
			this.dob = dob;
		}
		
		// use optional boolean to give result if succeed
		boolean addUser(User u) {
			return users.add(u);	
		}

		// use optional boolean to give result if succeed
		boolean removeUser(User u) {
			return users.remove(u);
		}
		
		// use optional boolean to give result if succeed
		boolean addDeveloper(Developer d) {
			return developers.add(d);	
		}

		// use optional boolean to give result if succeed
		boolean removeDeveloper(Developer d) {
			return developers.remove(d);
		}
		
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
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

		public String getDob() {
			return dob;
		}

		public void setDob(String dob) {
			this.dob = dob;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}


}