
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

// Using Singleton pattern
public class Manager {
	private static Manager instance;
	private static ManagementSystem firebase;

	private Manager() {
	}

	public static Manager getInstance() throws IOException {
		if (instance == null) {
			instance = new Manager();
			firebase = new ManagementSystem();
		}
		return instance;
	}

	// Users
	public void addUser(Users user) {
		firebase.save_user_data(user);
	}

	public void removeUser(String username, String password) {
		firebase.delete_user_data(username, password);
	}

	public void readUserData() {
		firebase.read_user_data();
	}

	// Vehicles
	public void addVehicle(Vehicles vehicle) {
		try {
			firebase.add(vehicle);
		} catch (IllegalAccessException e) {
			System.out.println("Failed to add object!");
			return;
		}
		System.out.println("Vehicle added successfully!");

	}

	public void removeVehicle() {

	}

	public void editVehicle() {

	}

	// Trip
	public void makePlan() {
		// Planning and optimizing routes
	}

	public void calculateCosts() {
		// Calculate expected costs
	}

	// Helper method
	
	// Create  Map from Object which has its Class name and all of its variables included.
	public static Map<String, Object> getObjectFieldsMap(Object obj) throws IllegalAccessException {
		Map<String, Object> objectMap = new HashMap<>();
		Class<?> classObj = obj.getClass();
		Field[] fields = classObj.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(obj);
			objectMap.put(field.getName(), value);
		}

		return objectMap;
	}
}
