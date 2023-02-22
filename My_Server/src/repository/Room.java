package repository;

import lombok.Data;
@Data
public class Room {
	String roomname;
	public Room(String roomname) {
		this.roomname = roomname;
	}
}
