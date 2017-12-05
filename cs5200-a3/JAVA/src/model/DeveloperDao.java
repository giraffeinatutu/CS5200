package model;
import entities.*;
import java.util.*;

public interface DeveloperDao {
	int createDeveloper(Developer developer);
	Collection<Developer> findAllDevelopers();
	Developer findDeveloperById(int developerId);
	Developer findDeveloperByUsername(String username);
	Developer findDeveloperByCredentials(String username, String password);
	int updateDeveloper(int developerId, Developer developer);
	int deleteDeveloper(int developerId);
}