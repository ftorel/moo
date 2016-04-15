package Model;


public class UserManager {

	private static UserManager sharedInstance; 
    
    public static UserManager sharedInstance(){
		return initInstance();
	}
    
    public User currentUser;
	
	private UserManager() {
		// TODO Auto-generated constructor stub
	}
	
	private static UserManager initInstance(){
		if ( sharedInstance == null ){
			sharedInstance = new UserManager();
		}
		return sharedInstance;
	}
}

