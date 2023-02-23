package repository;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
@Data
public class RoomRepository {
	private RoomRepository() {};
	private static RoomRepository instance;
	public static RoomRepository getInstance() {
		if(instance == null) {
			instance = new RoomRepository();
		}
		
		return instance;
	};
	private List<Room> roomliList = new ArrayList<>();
}
