import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

// Using Singleton pattern
public class Manager {
	private static Manager instance;
	private static FirebaseSystem firebase;

	private Manager() {
	}
	public static Manager getInstance() throws IOException {
            if (instance == null) {
                instance = new Manager();
                firebase = new FirebaseSystem();
            }
            return instance;
	}

	// Users
	public void addUser(Users user) {
            try {
                if(firebase.check_duplicated_user(user)) {
                    System.out.println("Account had been signed");
                    return ;
                }
                firebase.add(user);  
            } catch (IllegalAccessException ex) {
                System.out.println("Failed to add uset!");
                return ;
            }
            System.out.println("New account have been signed succesfully");
	}

	public void removeUser(Users user) {
            firebase.delete(user);
	}

	public void readUserData() {
            firebase.read_user_data();
	}
        
        public static int getNumOfUsers() {
            return firebase.usersManager.size();
        }
        
        // Drivers 
        public void addDriver(Drivers driver) {
            try {
                firebase.add(driver);
            } catch (IllegalAccessException e) {
                System.out.println("Failed to add driver!");
                return;
            }
            System.out.println("Drivers added successfully!");
        }
        
        public static int getNumOfDrivers() {
            return firebase.driversManager.size();
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
        
        public static int getNumOfVehicles() {
            return firebase.vehiclesManager.size();
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
        // Lay gia tri tu 1 field cu the
        public static Object getFieldValue(Object object, String fieldName) {
            try {
                Field field = object.getClass().getDeclaredField(fieldName);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        }    
}