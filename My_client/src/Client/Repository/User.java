package Client.Repository;

import lombok.Data;

@Data
public class User {
	String name;
	public User(String name) {
		this.name = name;
		
	}
}
