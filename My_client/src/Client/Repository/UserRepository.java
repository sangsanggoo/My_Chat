package Client.Repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class UserRepository {
	private static UserRepository instance;
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	List<User> userlist = new ArrayList<>();
}
