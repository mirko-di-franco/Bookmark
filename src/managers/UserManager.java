package managers;

import entities.User;

public class UserManager {
	private static UserManager istance = new UserManager();
	private UserManager() {}
	
	
	public static UserManager getInstance() {
		return istance;
	}
	
	public User createUser(long id, String email, String password, String firstName, String lastName, int gender, String userType) {
		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		
		return user;
	}
}
