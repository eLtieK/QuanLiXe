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
    public static void removeAllUsers() {
        firebase.delete_map(firebase.usersManager);
    }
    public static void readUser(Users user) throws Exception {
        firebase.read(user);
    }      
    public static void readAllUsers() throws Exception {
        try {
            firebase.read_map(firebase.usersManager);
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateUsers() throws IllegalAccessException {
        firebase.update_object(firebase.usersManager);
        System.out.println("Users updated successfully");
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
    public static void removeAllDrivers() {
        firebase.delete_map(firebase.driversManager);
    }
    public static void readDriver(Drivers driver) throws Exception {
        firebase.read(driver);
    }      
    public static void readAllDrivers() throws Exception {
        firebase.read_map(firebase.driversManager);
    }
    public static void updateDrivers() throws IllegalAccessException {
        firebase.update_object(firebase.driversManager);
        System.out.println("Drivers updated successfully");
    }
    public static Drivers getDriver(int id) throws Exception {
        if(firebase.driversManager.isEmpty()) {
            throw new Exception("No driver to get");
        }
        return (Drivers)firebase.get_object(firebase.driversManager, id);
    }
    public static Drivers getBestDriver(Vehicles.Type type) {
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
                System.out.println("Failed to add vehicle!");
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
    public static void removeAllVehicles() {
        firebase.delete_map(firebase.vehiclesManager);
    }
    public static void readVehicle(Vehicles vehicle) throws Exception {
        firebase.read(vehicle);
    }      
    public static void readAllVehicles() throws Exception {
        try {
            firebase.read_map(firebase.vehiclesManager);
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateVehicles() throws IllegalAccessException {
        firebase.update_object(firebase.vehiclesManager);
        System.out.println("Vehicles updated successfully");
    }
    public static Vehicles getVehicle(int id) throws Exception {
        if(firebase.vehiclesManager.isEmpty()) {
            throw new Exception("No vehicle to get");
        }
        return (Vehicles)firebase.get_object(firebase.vehiclesManager, id);
    }
    public static Vehicles getBestVehicle(Vehicles.Type type) {
       Vehicles best_vehicle = (Vehicles)firebase.get_best_object(type, firebase.vehiclesManager);
       if(best_vehicle.getKm_before_maintenace() < Long.MAX_VALUE) {
           return best_vehicle;
       }
       throw new IllegalArgumentException("No suitbale vehicle to choose");
    }
    public static void editVehicle() {

    }

    // Trips
    public static void addTrip(Trips trip) {
        try {
                firebase.add(trip);
        } catch (IllegalAccessException e) {
                System.out.println("Failed to add trip!");
                return;
        }
        System.out.println("Trip added successfully!");
    }
    public static void removeTrip(Trips trip) {
        firebase.delete(trip);
    }
    public static void removeAllTrip() {
        firebase.delete_map(firebase.tripManager);
    }
    public static void readTrip(Trips trip) throws Exception {
        firebase.read(trip);
    }
    public static void readAllTrip() throws Exception {
        try {
            firebase.read_map(firebase.tripManager);
        } catch (Exception ex) {
            Logger.getLogger(Manager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void updateTrips() throws IllegalAccessException {
        firebase.update_object(firebase.tripManager);
        System.out.println("Trips updated successfully");
    }
    public static void makeTrip(Trips trip) throws Exception {
        if(!trip.trip_on_ready()) {
            System.out.println("Trip is not ready");
        }
    }
    public static void makePlan() {
            // Planning and optimizing routes
    }

    public static void calculateCosts(Trips trip) throws Exception {
        System.out.println("Trip's cost is: " + trip.caculate_trip_cost());
    }
    public static int getNumOfTrips() {
        return firebase.tripManager.size();
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
    public static Map<String, Object> getMapFieldsMap(Map<String, ?> map) throws IllegalAccessException {
        Map<String, Object> resultMap = new HashMap<>();

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            Map<String, Object> value = getObjectFieldsMap(entry.getValue());

            resultMap.put(key, value);
        }

        return resultMap;
    }
    // Lay gia tri tu 1 field cu the
    public static Object getFieldValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }    
}