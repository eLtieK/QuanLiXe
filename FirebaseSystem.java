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

public class FirebaseSystem {
    private DatabaseReference myRef;
    public Map<String, Users> usersManager;
    public Map<String, Drivers> driversManager;
    public Map<String, Vehicles> vehiclesManager;
    public Map<String, Trip> tripManager;
    
    FirebaseSystem() throws IOException {
        init_Firebase();
        setup_Firebase_reference();
        load_data();
    }    
    private void init_Firebase() throws IOException{
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
        DatabaseReference tripRef = this.myRef.child("Trip");
        
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Users>>() {}.getType();
                usersManager = new Gson().fromJson(jsonString, type);
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
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Drivers>>() {}.getType();
                driversManager = new Gson().fromJson(jsonString, type);
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
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Vehicles>>() {}.getType();
                vehiclesManager = new Gson().fromJson(jsonString, type);
                System.out.println("Vehicles data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }
            
        });
        tripRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Trip>>() {}.getType();
                tripManager = new Gson().fromJson(jsonString, type);
                System.out.println("Trip loaded succesfully");
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
    public boolean check_duplicated_user(Users user) {
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().getName().equals(user.getName())) { //so sanh 2 string giong nhau ko
               return true;
            }
        }
        return false;
    }
    public boolean check_login_user(Users user) { //check dang nhap
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().getName().equals(user.getName())) { //so sanh 2 string giong nhau ko
                if(userEntry.getValue().getPassword().equals(user.getPassword())) {
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

        if(className.equals("Users")) {
            usersManager.put(new_key, (Users)obj);
        }
        else if(className.equals("Drivers")) {
            driversManager.put(new_key, (Drivers)obj);
        }
        else if(className.equals("Vehicles")) {
            vehiclesManager.put(new_key, (Vehicles)obj);
        }
        else if(className.equals("Trip")) {
            tripManager.put(new_key, (Trip)obj);
        }
        else {
            System.out.print("Data invalid");
        }
    }
    private String get_key(Object obj, Map<String, ?> temp_map) {   
        String className = obj.getClass().getSimpleName();
        
        for(Map.Entry<String, ?> temp_entry : temp_map.entrySet()) { //duyet qua map
            Object data = temp_entry.getValue();
            if(className.equals("Users")){
                Users user_data = (Users)data;
                String check_data = (String)Manager.getFieldValue(obj, "username");
                if(user_data.getName().equals(check_data))
                    return temp_entry.getKey();
            }
            else if(className.equals("Drivers")){
                Drivers driver_data = (Drivers)data;
                int check_data = (int)Manager.getFieldValue(obj, "id");
                if(driver_data.getId() == check_data)
                    return temp_entry.getKey();
            }
            else if(className.equals("Vehicles")){
                Vehicles vehicle_data = (Vehicles)data;
                int check_data = (int)Manager.getFieldValue(obj, "id");
                if(vehicle_data.getId() == check_data)
                    return temp_entry.getKey();
            }
            else if(className.equals("Trip")) {
                Trip trip_data = (Trip)data;
                int check_data = (int)Manager.getFieldValue(obj, "id");
                if(trip_data.getId() == check_data)
                    return temp_entry.getKey();
            }
        }
        return "";
    }
    public void delete(Object obj) {
        String className = obj.getClass().getSimpleName();
        Map<String, ?> temp_map = null;
        if("Users".equals(className)) {temp_map = usersManager;}
        else if("Vehicles".equals(className)) {temp_map = vehiclesManager;}
        else if("Drivers".equals(className)) {temp_map = driversManager;}
        else if("Trip".equals(className)) {temp_map = tripManager;}
        else {
            System.out.println("Deleted fail");
            return ;
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
        for(Map.Entry<String, ?> entry : map.entrySet()) {
            if(className.equals("Users")) {
                Users data = (Users)entry.getValue();
                objsToRemove.add(data);
            }
            else if(className.equals("Vehicles")) {
                Vehicles data = (Vehicles)entry.getValue();
                objsToRemove.add(data);
            }
            else if(className.equals("Drivers")) {
                Drivers data = (Drivers)entry.getValue();
                objsToRemove.add(data);
            }
            else if(className.equals("Trip")) {
                Trip data = (Trip)entry.getValue();
                objsToRemove.add(data);
            }
        }
        
        for(Object obj : objsToRemove) {
            delete(obj);
        }
    }
    public void read(Object obj) {
        String className = obj.getClass().getSimpleName();
        if(className.equals("Users")) {
            Users data = (Users)obj;
            System.out.println("Name: " + data.getName()
                                + ", Email: " + data.getEmail()
                                + ", Phone number: " + data.getPhonenumber());
        }
        else if(className.equals("Vehicles")) {
            Vehicles data = (Vehicles)obj;
            System.out.println("Id: " + data.getId()
                                + ", Type: " + data.getType().toString()
                                + ", Weight: " + data.getWeight()
                                + ", Size: " + data.getWeight()
                                + ", Fuel: " + data.getFuel().toString()
                                + ", Status: " + data.getStatus().toString()
                                + ", All_km: " + data.getAll_km()
                                + ", Km_before_maintenace: " + data.getKm_before_maintenace()
            );
        }
        else if(className.equals("Drivers")) {
            Drivers data = (Drivers)obj;
            System.out.println("Id: " + data.getId()
                                + ", Name: " + data.getName()
                                + ", Address: " + data.getAddress()
                                + ", Phone number: " + data.getPhonenumber()
                                + ", License " + data.getLicense().toString()
                                + ", Experiences: " + data.getExperiences()
                                + ", Status: " + data.getStatus().toString()
            );
        }
        else if(className.equals("Trip")) {
            Trip data = (Trip)obj;
            System.out.println("Id: " + data.getId()
                                + ", Start: " + data.getDestination_start().toString()
                                + ", End: " + data.getDestination_end().toString()
                                + ", Start time: " + data.getTime()
                                + ", Expected time: " + data.getExpected_time()
                                + ", Status: " + data.getStatus().toString()
                                + ", Driver's name: " + data.getDriver().getName()
                                + ", Driver's phone number: " + data.getDriver().getPhonenumber()
                                + ", Type of vehicle: " + data.getVehicle().getType().toString()
            );
        }
        else {
            System.out.println("Invalid data to read");
        }
    }
    public void read_map(Map<String, ?> map) {  
        String className = map.values().iterator().next().getClass().getSimpleName();
        for(Map.Entry<String, ?> entry : map.entrySet()) {
            if(className.equals("Users")) {
                Users data = (Users)entry.getValue();
                read(data);
            }
            else if(className.equals("Vehicles")) {
                Vehicles data = (Vehicles)entry.getValue();
                read(data);
            }
            else if(className.equals("Drivers")) {
                Drivers data = (Drivers)entry.getValue();
                read(data);
            }
            else if(className.equals("Trip")) {
                Trip data = (Trip)entry.getValue();
                read(data);
            }
        }
    }
    
    public Object get_best_object(Vehicles.Type type, Map<String, ?> map) { 
        String className = map.values().iterator().next().getClass().getSimpleName();
        Vehicles vehicle_temp = new Vehicles();
        Drivers driver_temp = new Drivers();
        boolean is_best_license = false;
        
        for(Map.Entry<String, ?> entry : map.entrySet()) {
            if(className.equals("Vehicles")) {
                Vehicles data = (Vehicles)entry.getValue();
                if(data.getType().equals(type)) {
                    if(data.getKm_before_maintenace() < vehicle_temp.getKm_before_maintenace()) {
                        vehicle_temp = data;
                    }
                }
            }
            else if(className.equals("Drivers")) {
                Drivers data = (Drivers)entry.getValue();
                if(data.get_suitable_type().equals(type)) {
                    if(data.getExperiences() >= driver_temp.getExperiences()) {
                        driver_temp = data;
                        is_best_license = true;
                    }
                }
                else if(Trip.check_suitable(data.getLicense(), type) && !is_best_license) {
                    if(data.getExperiences() >= driver_temp.getExperiences()) {
                        driver_temp = data;
                    }
                }
            }
        }
        
        if(className.equals("Vehicles")) {
            return vehicle_temp;
        }
        else {
            return driver_temp;
        }
    }
}

	
