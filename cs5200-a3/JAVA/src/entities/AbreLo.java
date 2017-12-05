package entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;
import utils.*;

public class AbreLo {

	// Connect to Database
	final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/hw3_riley_caitlin_fall_2017";
	final static String USER = "root";
	final static String PASS = "12345";
    public static Connection conn = null;


	public static void main(String[] args) {
		
					System.out.println("Connecting to a selected database...");
//					Developer developer = new Developer();
//					developer.setUsername("alice");
//					developer.setPassword("alice");
//					developer.setFirstName("Alice");
//					developer.setLastName("Wonder");
//					developer.setType("Developer");
//					developer.setEmail("alice@wonder.com");
//					developer.setDob("2017-10-01");
//					developer.setDeveloperkey("4321rewq");
//					
//					DeveloperDaoImp d = new model.DeveloperDaoImp();
//					d.createDeveloper(developer);
					
					WebsiteDaoImp w = new model.WebsiteDaoImp();
					Website site = new Website();
					site.setName("Facebook");
					site.setDescription("an online social media and social networking service");
					site.setCreated("2017-10-01");
					site.setUpdated("2017-10-01");
					site.setVisits(1234234);
					
//					WebsiteDaoImp w = new model.WebsiteDaoImp();
//					System.out.println(w.findAllWebsites());
					
//					RoleDaoImp p = new model.RoleDaoImp();
//					p.assignWebsiteRole(1, 1, "owner");

//					RoleDaoImp p = new model.RoleDaoImp();
//					p.assignPageRole(1,1,"editor");
					
					
			System.out.println("Operation Successfull woohoo...");

	
	}

}
