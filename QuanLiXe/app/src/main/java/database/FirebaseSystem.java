package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Admin
 */
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FirebaseSystem {

    private DatabaseReference myRef;
    public Map<String, Users> usersManager;
    public Map<String, Drivers> driversManager;
    public Map<String, Vehicles> vehiclesManager;
    public Map<String, Trips> tripManager;

    FirebaseSystem() throws IOException {
        init_Firebase();
        setup_Firebase_reference();
        load_data();
    }

    private void init_Firebase() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("credentials.json");

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                // The database URL depends on the location of the database
                .setDatabaseUrl("https://quanlixe-9970a-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build();
        FirebaseApp.initializeApp(options);
    }

    private void setup_Firebase_reference() {
        this.myRef = FirebaseDatabase.getInstance().getReference();
        this.usersManager = new HashMap<>();
        this.driversManager = new HashMap<>();
        this.vehiclesManager = new HashMap<>();
        this.tripManager = new HashMap<>();
    }

    private void load_data() { //load data tu firebase vao map usersManager
        DatabaseReference usersRef = this.myRef.child("Users");
        DatabaseReference vehiclesRef = this.myRef.child("Vehicles");
        DatabaseReference driversRef = this.myRef.child("Drivers");
        DatabaseReference tripsRef = this.myRef.child("Trips");

        tripsRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    try {
                        // Lặp qua từng child (mỗi chuyến đi)
                        String tripId = childSnapshot.getKey(); // Lấy ID của chuyến đi

                        String time_start = childSnapshot.child("time_start").getValue(String.class);
                        String date_start = childSnapshot.child("date_start").getValue(String.class);

                        String start_temp = childSnapshot.child("destination_start").getValue(String.class);
                        Trips.Destination destination_start = Trips.fromStringDestination(start_temp);

                        String end_temp = childSnapshot.child("destination_end").getValue(String.class);
                        Trips.Destination destination_end = Trips.fromStringDestination(end_temp);

                        String status_temp = childSnapshot.child("status").getValue(String.class);
                        Trips.Status status = Trips.fromStringStatus(status_temp);

                        int driver_id = childSnapshot.child("driver_id").getValue(Integer.class);
                        int vehicle_id = childSnapshot.child("vehicle_id").getValue(Integer.class);

                        int id = childSnapshot.child("id").getValue(Integer.class);

                        Trips trip = new Trips(time_start, date_start, destination_start, destination_end, status, vehicle_id, driver_id, id);
                        tripManager.put(tripId, trip); // Thêm chuyến đi vào Map với khóa là ID của chuyến đi
                    } catch (Exception ex) {
                        Logger.getLogger(FirebaseSystem.class.getName()).log(Level.SEVERE, null, ex);
                    }
                };
                System.out.println("Trips data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }

        });
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    String userId = childSnapshot.getKey();

                    String username = childSnapshot.child("username").getValue(String.class);
                    String phone_number = childSnapshot.child("phone_number").getValue(String.class);
                    String password = childSnapshot.child("password").getValue(String.class);
                    String email = childSnapshot.child("email").getValue(String.class);

                    Users user = new Users(username, password, phone_number, email);
                    usersManager.put(userId, user);
                }
                System.out.println("Users data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }

        });
        driversRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    String driverId = childSnapshot.getKey();

                    String name = childSnapshot.child("name").getValue(String.class);
                    String phone_number = childSnapshot.child("phone_number").getValue(String.class);
                    String address = childSnapshot.child("address").getValue(String.class);

                    String license_temp = childSnapshot.child("license").getValue(String.class);
                    Drivers.License license = Drivers.fromStringLicense(license_temp);

                    int experiences = childSnapshot.child("experiences").getValue(Integer.class); //years of experiences (can be int)

                    String status_temp = childSnapshot.child("status").getValue(String.class);
                    Drivers.Status status = Drivers.fromStringStatus(status_temp);

                    int performance = childSnapshot.child("performance").getValue(Integer.class);
                    int id = childSnapshot.child("id").getValue(Integer.class);
                    String date_start = childSnapshot.child("date_start").getValue(String.class);
                    String date_end = childSnapshot.child("date_end").getValue(String.class);

                    Drivers driver = new Drivers(name, phone_number, address, license, experiences, status, id, performance, date_start, date_end);
                    driversManager.put(driverId, driver);
                }
                System.out.println("Drivers data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }

        });
        vehiclesRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                for (DataSnapshot childSnapshot : snapshot.getChildren()) {
                    String vehicleId = childSnapshot.getKey();

                    int weight = childSnapshot.child("weight").getValue(Integer.class);
                    int size = childSnapshot.child("size").getValue(Integer.class);

                    String fuel_temp = childSnapshot.child("fuel").getValue(String.class);
                    Vehicles.Fuel fuel = Vehicles.fromStringFuel(fuel_temp);

                    String type_temp = childSnapshot.child("type").getValue(String.class);
                    Vehicles.Type type = Vehicles.fromStringType(type_temp);

                    String status_temp = childSnapshot.child("status").getValue(String.class);
                    Vehicles.Status status = Vehicles.fromStringStatus(status_temp);

                    int id = childSnapshot.child("id").getValue(Integer.class);
                    long all_km = childSnapshot.child("all_km").getValue(Long.class);
                    long km_before_maintenace = childSnapshot.child("km_before_maintenace").getValue(Long.class);
                    
                    String date_start = childSnapshot.child("date_start").getValue(String.class);
                    String date_end = childSnapshot.child("date_end").getValue(String.class);

                    Vehicles vehicle = new Vehicles(weight, size, fuel, type, id, status, all_km, km_before_maintenace, date_start, date_end);
                    vehiclesManager.put(vehicleId, vehicle);
                }
                System.out.println("Vehicles data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }

        });
    }

    public DatabaseReference getRef() {
        return this.myRef;
    }

    public boolean check_duplicated(String name) {
        if (usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for (Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if (userEntry.getValue().getName().equals(name)) { //so sanh 2 string giong nhau ko
                return true;
            }
        }
        return false;
    }

    public boolean check_login_user(String username, String password) { //check dang nhap
        if (usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for (Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if (userEntry.getValue().getName().equals(username)) { //so sanh 2 string giong nhau ko
                if (userEntry.getValue().getPassword().equals(password)) {
                    System.out.println("Login successfully");
                    return true;
                }
            }
        }
        System.out.println("Wrong password or username");
        return false;
    }

    // Add an object to Firebase, with Object class name as key and all of its variables as value.
    public void add(Object obj) throws IllegalAccessException { //can add all object (Users, Drivers, Vehicles)
        String className = obj.getClass().getSimpleName();
        DatabaseReference classRef = this.myRef.child(className); //toi duong dan nut 
        Map<String, Object> objectMap = Manager.getObjectFieldsMap(obj);
        String new_key = classRef.push().getKey();
        classRef.child(new_key).setValueAsync(objectMap);

        if (className.equals("Users")) {
            usersManager.put(new_key, (Users) obj);
        } else if (className.equals("Drivers")) {
            driversManager.put(new_key, (Drivers) obj);
        } else if (className.equals("Vehicles")) {
            vehiclesManager.put(new_key, (Vehicles) obj);
        } else if (className.equals("Trips")) {
            tripManager.put(new_key, (Trips) obj);
        } else {
            System.out.print("Data invalid");
        }
    }

    private String get_key(Object obj, Map<String, ?> temp_map) {
        String className = obj.getClass().getSimpleName();

        for (Map.Entry<String, ?> temp_entry : temp_map.entrySet()) { //duyet qua map
            Object data = temp_entry.getValue();
            if (className.equals("Users")) {
                Users user_data = (Users) data;
                String check_data = (String) Manager.getFieldValue(obj, "username");
                if (user_data.getName().equals(check_data)) {
                    return temp_entry.getKey();
                }
            } else if (className.equals("Drivers")) {
                Drivers driver_data = (Drivers) data;
                int check_data = (int) Manager.getFieldValue(obj, "id");
                if (driver_data.getId() == check_data) {
                    return temp_entry.getKey();
                }
            } else if (className.equals("Vehicles")) {
                Vehicles vehicle_data = (Vehicles) data;
                int check_data = (int) Manager.getFieldValue(obj, "id");
                if (vehicle_data.getId() == check_data) {
                    return temp_entry.getKey();
                }
            } else if (className.equals("Trips")) {
                Trips trip_data = (Trips) data;
                int check_data = (int) Manager.getFieldValue(obj, "id");
                if (trip_data.getId() == check_data) {
                    return temp_entry.getKey();
                }
            }
        }
        return "";
    }

    public void delete(Object obj) {
        String className = obj.getClass().getSimpleName();
        Map<String, ?> temp_map = null;
        if ("Users".equals(className)) {
            temp_map = usersManager;
        } else if ("Vehicles".equals(className)) {
            temp_map = vehiclesManager;
        } else if ("Drivers".equals(className)) {
            temp_map = driversManager;
        } else if ("Trips".equals(className)) {
            temp_map = tripManager;
        } else {
            System.out.println("Deleted fail");
            return;
        }
        String key = get_key(obj, temp_map);
        DatabaseReference classRef = this.myRef.child(className).child(key);
        classRef.removeValueAsync();
        temp_map.remove(key);
        System.out.println("Deleted succesfully key " + className + " " + key);
    }

    public void delete_map(Map<String, ?> map) {  //phai tao 1 list de chua data vi neu xoa data trong map luc dang duyet se bi xung dot du lieu
        String className = map.values().iterator().next().getClass().getSimpleName();
        List<Object> objsToRemove = new ArrayList<>();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Users")) {
                Users data = (Users) entry.getValue();
                objsToRemove.add(data);
            } else if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                objsToRemove.add(data);
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                objsToRemove.add(data);
            } else if (className.equals("Trips")) {
                Trips data = (Trips) entry.getValue();
                objsToRemove.add(data);
            }
        }

        for (Object obj : objsToRemove) {
            delete(obj);
        }
    }

    public void read(Object obj) throws Exception {
        String className = obj.getClass().getSimpleName();
        if (className.equals("Users")) {
            Users data = (Users) obj;
            System.out.println("Name: " + data.getName()
                    + ", Email: " + data.getEmail()
                    + ", Phone number: " + data.getPhonenumber());
        } else if (className.equals("Vehicles")) {
            Vehicles data = (Vehicles) obj;
            System.out.println("Id: " + data.getId()
                    + ", Type: " + data.getType().toString()
                    + ", Weight: " + data.getWeight()
                    + ", Size: " + data.getWeight()
                    + ", Fuel: " + data.getFuel().toString()
                    + ", Status: " + data.getStatus().toString()
                    + ", All_km: " + data.getAll_km()
                    + ", Km_before_maintenace: " + data.getKm_before_maintenace()
            );
        } else if (className.equals("Drivers")) {
            Drivers data = (Drivers) obj;
            System.out.println("Id: " + data.getId()
                    + ", Name: " + data.getName()
                    + ", Address: " + data.getAddress()
                    + ", Phone number: " + data.getPhonenumber()
                    + ", License " + data.getLicense().toString()
                    + ", Experiences: " + data.getExperiences()
                    + ", Status: " + data.getStatus().toString()
            );
        } else if (className.equals("Trips")) {
            Trips data = (Trips) obj;
            System.out.println("Id: " + data.getId()
                    + ", Start: " + data.getDestination_start().toString()
                    + ", End: " + data.getDestination_end().toString()
                    + ", Start time: " + data.getTime()
                    + ", Status: " + data.getStatus().toString()
                    + ", Driver's id: " + data.getDriverId()
                    + ", Vehicle's id: " + data.getVehicleId()
            );
        } else {
            System.out.println("Invalid data to read");
        }
    }

    public void read_map(Map<String, ?> map) throws Exception {
        String className = map.values().iterator().next().getClass().getSimpleName();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Users")) {
                Users data = (Users) entry.getValue();
                read(data);
            } else if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                read(data);
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                read(data);
            } else if (className.equals("Trips")) {
                Trips data = (Trips) entry.getValue();
                read(data);
            }
        }
    }

    public Object get_best_object(Vehicles.Type type, Map<String, ?> map) {
        String className = map.values().iterator().next().getClass().getSimpleName();
        Vehicles vehicle_temp = new Vehicles();
        Drivers driver_temp = new Drivers();
        boolean is_best_license = false;

        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                if (data.getType().equals(type)) {
                    if (data.getKm_before_maintenace() < vehicle_temp.getKm_before_maintenace() && data.getStatus().equals(Vehicles.Status.ready)) {
                        vehicle_temp = data;
                    }
                }
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                if (data.get_suitable_type().equals(type)) {
                    if (data.getExperiences() >= driver_temp.getExperiences() && data.getStatus().equals(Drivers.Status.ready)) {
                        driver_temp = data;
                        is_best_license = true;
                    }
                } else if (Trips.check_suitable(data.getLicense(), type) && !is_best_license && data.getStatus().equals(Drivers.Status.ready)) {
                    if (data.getExperiences() >= driver_temp.getExperiences()) {
                        driver_temp = data;
                    }
                }
            }
        }

        if (className.equals("Vehicles")) {
            return vehicle_temp;
        } else {
            return driver_temp;
        }
    }

    public void update_object(Map<String, ?> map) throws IllegalAccessException {
        String className = map.values().iterator().next().getClass().getSimpleName();
        this.myRef.child(className).updateChildrenAsync(Manager.getMapFieldsMap(map));
    }

    public boolean is_has_object(Map<String, ?> map, int id) throws Exception {
        String className = map.values().iterator().next().getClass().getSimpleName();
        if (map.isEmpty()) {
            throw new Exception("No data to get");
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                if (data.getId() == id) {
                    return true;
                }
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                if (data.getId() == id) {
                    return true;
                }
            } else if (className.equals("Trips")) {
                Trips data = (Trips) entry.getValue();
                if (data.getId() == id) {
                    return true;
                }
            }
        }

        return false;
    }

    public Object get_object(Map<String, ?> map, int id) throws Exception {
        String className = map.values().iterator().next().getClass().getSimpleName();
        Vehicles vehicle_temp = new Vehicles();
        Drivers driver_temp = new Drivers();
        Trips trip_temp = new Trips();

        if (map.isEmpty()) {
            throw new Exception("No data to get");
        }
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                if (data.getId() == id) {
                    vehicle_temp = data;
                    break;
                }
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                if (data.getId() == id) {
                    driver_temp = data;
                    break;
                }
            } else if (className.equals("Trips")) {
                Trips data = (Trips) entry.getValue();
                if (data.getId() == id) {
                    trip_temp = data;
                    break;

                }

            }
        }

        if (className.equals("Vehicles")) {
            return vehicle_temp;
        } else if (className.equals("Drivers")) {
            return driver_temp;
        } else {
            return trip_temp;
        }

    }

    public boolean is_object_in_trip(int id, Map<String, ?> map) {
        String className = map.values().iterator().next().getClass().getSimpleName();
        for (Map.Entry<String, Trips> entry : tripManager.entrySet()) {
            Trips data = entry.getValue();
            if (className.equals("Vehicles")) {
                if (data.getVehicleId() == id) {
                    return true;
                }
            } else if (className.equals("Drivers")) {
                if (data.getDriverId() == id) {
                    return true;
                }
            }
        }
        return false;
    }

    public Set<Integer> get_set_id(Map<String, ?> map) {
        String className = map.values().iterator().next().getClass().getSimpleName();
        Set<Integer> my_set = new TreeSet<>();
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            if (className.equals("Vehicles")) {
                Vehicles data = (Vehicles) entry.getValue();
                my_set.add(data.getId());
            } else if (className.equals("Drivers")) {
                Drivers data = (Drivers) entry.getValue();
                my_set.add(data.getId());
            } else if (className.equals("Trips")) {
                Trips data = (Trips) entry.getValue();
                my_set.add(data.getId());
            }
        }
        return my_set;
    }

    public boolean is_have_id(int id, Map<String, ?> map) {
        Set<Integer> my_set = get_set_id(map);
        return my_set.contains(id);
    }

    public int get_id(Map<String, ?> map) {
        Set<Integer> my_set = get_set_id(map);
        for (int i = 0;; i++) {
            if (!my_set.contains(i)) {
                return i;
            }
        }
    }
}
