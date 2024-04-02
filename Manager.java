import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

// Using Singleton pattern
public class Manager {
    private static Manager instance;
    private static FirebaseSystem firebase;
    
    private Manager(){}
    
    public static Manager getInstance() throws IOException { 
        if(instance == null ) {
            instance = new Manager();
            firebase = new FirebaseSystem();
        }
        return instance;
    }
    public static FirebaseSystem getFirebase() {
        return firebase;
    }
    // Users
    public static void addUser(Users user) {
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
    public static void removeUser(Users user) {
        firebase.delete(user);
    }
    public static void readUser(Users user) {
        firebase.read(user);
    }      
    public static void readAllUsers() {
        firebase.read_map(firebase.usersManager);
    }
    public static int getNumOfUsers() {
        return firebase.usersManager.size();
    }

    // Drivers 
    public static void addDriver(Drivers driver) {
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
    public static void removeDriver(Drivers driver) {
        firebase.delete(driver);
    }
    public static void readDriver(Drivers driver) {
        firebase.read(driver);
    }      
    public static void readAllDrivers() {
        firebase.read_map(firebase.driversManager);
    }
    public static Drivers gerBestDriver(Vehicles.Type type) {
       Drivers best_driver = (Drivers)firebase.get_best_object(type, firebase.driversManager);
       if(best_driver.getExperiences() != 0) {
           return best_driver;
       }
       throw new IllegalArgumentException("No suitbale driver to choose");
    }

    // Vehicles
    public static void addVehicle(Vehicles vehicle) {
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
    public static void removeVehicle(Vehicles vehicle) {
        firebase.delete(vehicle);
    }
    public static void readVehicle(Vehicles vehicle) {
        firebase.read(vehicle);
    }      
    public static void readAllVehicles() {
        firebase.read_map(firebase.vehiclesManager);
    }
    public static Vehicles getBestVehicle(Vehicles.Type type) {
       Vehicles best_vehicle = (Vehicles)firebase.get_best_object(type, firebase.vehiclesManager);
       if(best_vehicle.getKm_before_maintenace() != Double.POSITIVE_INFINITY) {
           return best_vehicle;
       }
       throw new IllegalArgumentException("No suitbale vehicle to choose");
    }
    public static void editVehicle() {

    }

    // Trip
    public static void makePlan() {
            // Planning and optimizing routes
    }

    public static void calculateCosts() {
            // Calculate expected costs
    }

    // Helper method

    // Create Map from Object which has its Class name and all of its variables included.
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