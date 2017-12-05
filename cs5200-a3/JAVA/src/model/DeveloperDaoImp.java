package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import entities.Developer;
import utils.ConnectMe;

public class DeveloperDaoImp implements DeveloperDao {

	// INSERTAR DEVELOPER
	// SQL:
	// INSERT INTO `hw2_riley_caitlin_fall_2017`.`Person`
	// (`id`, `username`, `password`, `firstName`, `lastName`, `Type`, `email`,
	// `dob`) VALUES (1, 'test', 'test', 'test', 'test', 'developer', 'test', NULL);
	// INSERT INTO `hw2_riley_caitlin_fall_2017`.`Developer` (`id`, `developerKey`)
	// VALUES (1, 'test');
	//
	public int createDeveloper(Developer developer) {
		try {
			String ADD_PERSON = "INSERT INTO Person (username, password, firstName, "
					+ "lastName, type, email, dob) VALUES (?,?,?,?,?,?,?)";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(ADD_PERSON);
			m.pstmt.setString(1, developer.getUsername());
			m.pstmt.setString(2, developer.getPassword());
			m.pstmt.setString(3, developer.getFirstName());
			m.pstmt.setString(4, developer.getLastName());			
			m.pstmt.setString(5, developer.getType());
			m.pstmt.setString(6, developer.getEmail());
			m.pstmt.setString(7, developer.getDob());
			m.pstmt.executeUpdate();
			
			String DEV_ID = "SELECT id FROM Person WHERE username = ?";
			PreparedStatement pst = m.conn.prepareStatement(DEV_ID);
			pst.setString(1, developer.getUsername());
			
			ResultSet rs = pst.executeQuery();
			System.out.println(rs);
			int ID = 0;
			while(rs.next()) {
				 ID = rs.getInt(1);
				System.out.println(ID);
			}

			String ADD_DEVELOPER = "INSERT INTO developer (id, developerKey) VALUES (?,?)";
			m.pstmt = m.conn.prepareStatement(ADD_DEVELOPER);
			m.pstmt.setInt(1, ID);
			m.pstmt.setString(2, developer.getDeveloperKey());
			m.pstmt.executeUpdate();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	// SELECCIONAR DEVELOPER
	// SQL:
	// select p.id, p.username, p.password, p.firstName, p.email, p.dob,
	// d.developerKey
	// FROM Person p JOIN Developer d ON p.id = d.id;
	//
	public Collection<Developer> findAllDevelopers() {
		final String FINDALLDEV = "select p.id, p.username, p.password,"
				+ " p.firstName, p.email, p.dob, d.developerKey FROM "
				+ "Person p RIGHT JOIN Developer d ON p.id = d.id";
		Collection<Developer> developers = new LinkedList<Developer>();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(FINDALLDEV);
			ResultSet rs = m.pstmt.executeQuery();
			while(rs.next()) {
				Developer d = new Developer();
				d.setId(rs.getInt("id"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				d.setFirstName(rs.getString("firstName"));
				d.setLastName(rs.getString("lastName"));
				d.setType(rs.getString("type"));
				d.setEmail(rs.getString("email"));
				d.setDob(rs.getString("dob"));
				d.setDeveloperkey(rs.getString("developerKey"));
				developers.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return developers;
	}

	// SELECCIONAR DEVELOPER byID
	// SQL:
	// select d.id, p.username, p.password, p.firstName, p.email, p.dob,
	// d.developerKey
	// FROM Person p JOIN Developer d ON p.id = d.id WHERE d.id = 1;
	//
	public Developer findDeveloperById(int developerId) {
		int i = developerId;
		Developer d = new Developer();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement("select p.id, p.username, p.password, p.firstName, "
					+ "p.email, p.dob, d.developerKey FROM Person p RIGHT JOIN Developer d ON"
					+ " p.id = d.id WHERE d.id = ?");
			m.pstmt.setInt(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			if (rs.next()) {
				d.setId(rs.getInt("id"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				d.setFirstName(rs.getString("firstName"));
				d.setLastName(rs.getString("lastName"));
				d.setType(rs.getString("type"));
				d.setEmail(rs.getString("email"));
				d.setDob(rs.getString("dob"));
				d.setDeveloperkey(rs.getString("developerKey"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	// SELECCIONAR DEVELOPER byUsername
	// SQL:
	// select d.id, p.username, p.password, p.firstName, p.email, p.dob,
	// d.developerKey FROM Person p JOIN Developer d ON p.id = d.id WHERE p.username = 1;
	//
	public Developer findDeveloperByUsername(String username) {
		String i = username;
		Developer d = new Developer();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement("select p.id, p.username, p.password, p.firstName, "
					+ "p.email, p.dob, d.developerKey FROM Person p RIGHT JOIN Developer d ON"
					+ " p.id = d.id WHERE p.username = ?");
			m.pstmt.setString(1, i);
			ResultSet rs = m.pstmt.executeQuery();
			if (rs.next()) {
				d.setId(rs.getInt("id"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				d.setFirstName(rs.getString("firstName"));
				d.setLastName(rs.getString("lastName"));
				d.setType(rs.getString("type"));
				d.setEmail(rs.getString("email"));
				d.setDob(rs.getString("dob"));
				d.setDeveloperkey(rs.getString("developerKey"));
			}
			rs.close();
			m.pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	// SELECCIONAR DEVELOPER Username y Password
	// SQL:
	// select d.id, p.username, p.password, p.firstName, p.email, p.dob,
	// d.developerKey FROM Person p JOIN Developer d ON p.id = d.id
	// WHERE p.username=? AND p.password=?;
	//
	public Developer findDeveloperByCredentials(String username, String password) {
		String p = password;
		String u = username;
		Developer d = new Developer();
		try {
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement("select p.id, p.username, p.password, p.firstName, "
					+ "p.lastName, p.type, p.email, p.dob, d.developerKey FROM Person p RIGHT JOIN "
					+ "Developer d ON p.id = d.id WHERE d.password = ? AND d.password = ?");
			m.pstmt.setString(1, p);
			m.pstmt.setString(2, u);
			ResultSet rs = m.pstmt.executeQuery();
			if (rs.next()) {
				d.setId(rs.getInt("id"));
				d.setUsername(rs.getString("username"));
				d.setPassword(rs.getString("password"));
				d.setFirstName(rs.getString("firstName"));
				d.setLastName(rs.getString("lastName"));
				d.setType(rs.getString("type"));
				d.setEmail(rs.getString("email"));
				d.setDob(rs.getString("dob"));
				d.setDeveloperkey(rs.getString("developerKey"));
			}
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return d;
	}

	// ACTUALIZAR-PERSON
	// SQL:
	// UPDATE `hw2_riley_caitlin_fall_2017`.`Person` SET
	// id = 1, username = riley, password = 123, firstName = cait, email = null, dob
	// = null,
	// WHERE id = 1;
	//
	public int updateDeveloper(int developerId, Developer developer) {
		int i = developerId;
		Developer d = new Developer();
		
		try {
			String UPDATE_PERSON = "UPDATE Person SET id = ?, username = ?, password = ?, "
					+ "firstName = ?, lastName = ?, type = ?, email = ?, dob = ?) WHERE id = ?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(UPDATE_PERSON);
			m.pstmt.setInt(1, i);
			m.pstmt.setObject(2, d);
			m.pstmt.executeQuery();
			m.pstmt.close();
			m.conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// BORRAR-PERSON
	// SQL:
	// DELETE FROM Person WHERE id=1
	//
	public int deleteDeveloper(int developerId) {
		try {
			String DELETE_PERSON = "DELETE FROM Person where id=?";
			ConnectMe m = ConnectMe.getThing();
			m.pstmt = m.conn.prepareStatement(DELETE_PERSON);
			m.pstmt.setInt(1, developerId);

			int rowsDeleted = m.pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");

				m.pstmt.close();
				m.conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
