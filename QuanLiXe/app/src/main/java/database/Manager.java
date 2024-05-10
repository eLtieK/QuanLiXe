package database;

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

    public static FirebaseSystem getFirebase() {
        return firebase;
    }

    // Users
    public static void addUser(Users user) {
        try {
            if (firebase.check_duplicated(user.getName())) {
                System.out.println("Account had been signed");
                return;
            }
            firebase.add(user);
        } catch (IllegalAccessException ex) {
            System.out.println("Failed to add uset!");
            return;
        }
        System.out.println("New account have been signed succesfully");
    }

    public static boolean checkLogin(String username, String password) {
        return firebase.check_login_user(username, password);
    }

    public static boolean checkDuplicated(String username) {
        return firebase.check_duplicated(username);
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
    public static int getNewDriverId() {
        if (firebase.driversManager.isEmpty()) {
            return 0;
        }
        return firebase.get_id(firebase.driversManager);
    }

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
        if (firebase.is_object_in_trip(driver.getId(), firebase.driversManager)) {
            System.out.println("Id: " + driver.getId() + ", this driver is in a trip");
            return;
        }
        firebase.delete(driver);
    }

    public static void removeAllDrivers() {
        if (!firebase.tripManager.isEmpty()) {
            System.out.println("some drivers are in a trip");
            return;
        }
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
        if (firebase.driversManager.isEmpty()) {
            throw new Exception("No driver to get");
        }
        return (Drivers) firebase.get_object(firebase.driversManager, id);
    }

    public static int getBestDriver(Vehicles.Type type) {
        Drivers best_driver = (Drivers) firebase.get_best_object(type, firebase.driversManager);
        if (best_driver.getExperiences() != 0) {
            return best_driver.getId();
        }
       return -1;
    }

    public static boolean checkDriverInTrip(int id) {
        return firebase.is_object_in_trip(id, firebase.driversManager);
    }

    public static boolean checkValidDriver(int id) throws Exception {
        return firebase.is_has_object(firebase.driversManager, id);
    }

    // Vehicles
    public static int getNewVehicleId() {
        if(firebase.vehiclesManager.isEmpty()){
            return 0;
        }
        return firebase.get_id(firebase.vehiclesManager);
    }

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
        if (firebase.is_object_in_trip(vehicle.getId(), firebase.vehiclesManager)) {
            System.out.println("Id: " + vehicle.getId() + ", this vehicle is in a trip");
            return;
        }
        firebase.delete(vehicle);
    }

    public static void removeAllVehicles() {
        if (!firebase.tripManager.isEmpty()) {
            System.out.println("some vehicles are in a trip");
            return;
        }
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
        if (firebase.vehiclesManager.isEmpty()) {
            throw new Exception("No vehicle to get");
        }
        return (Vehicles) firebase.get_object(firebase.vehiclesManager, id);
    }

    public static int getBestVehicle(Vehicles.Type type) {
        Vehicles best_vehicle = (Vehicles) firebase.get_best_object(type, firebase.vehiclesManager);
        if (best_vehicle.getKm_before_maintenace() < Long.MAX_VALUE) {
            return best_vehicle.getId();
        }
        return -1;
    }

    public static boolean checkVehicleInTrip(int id) {
        return firebase.is_object_in_trip(id, firebase.vehiclesManager);
    }

    public static boolean checkValidVehicle(int id) throws Exception {
        return firebase.is_has_object(firebase.vehiclesManager, id);
    }

    public static void editVehicle() {

    }

    // Trips
     public static Trips getTrip(int id) throws Exception {
        if (firebase.tripManager.isEmpty()) {
            throw new Exception("No trip to get");
        }
        return (Trips) firebase.get_object(firebase.tripManager, id);
    }
    public static boolean checkValidTrip(int id) throws Exception {
        return firebase.is_has_object(firebase.tripManager, id);
    }
    public static int getNewTripId() {
        if(firebase.tripManager.isEmpty()){
            return 0;
        }
        return firebase.get_id(firebase.tripManager);
    }

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
        if (!trip.is_trip_done()) {
            return;
        }
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
        if (!trip.trip_on_ready()) {
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
