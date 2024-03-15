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

public class FirebaseSystem {
    private DatabaseReference myRef;
    public Map<String, Users> usersManager;
    public Map<String, Drivers> driversManager;
    public Map<String, Vehicles> vehiclesManager;
    
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
    }
    private void load_data() { //load data tu firebase vao map usersManager
        DatabaseReference usersRef = this.myRef.child("Users");
        DatabaseReference vehiclesRef = this.myRef.child("Vehicles");
        DatabaseReference driversRef = this.myRef.child("Drivers");
        
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
                Type type = new TypeToken<Map<String, Users>>() {}.getType();
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
                Type type = new TypeToken<Map<String, Users>>() {}.getType();
                vehiclesManager = new Gson().fromJson(jsonString, type);
                System.out.println("Vehicles data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }
            
        });
    }
    public void save_user_data(Users new_user) {
        DatabaseReference usersRef = this.myRef.child("Users"); //duong dan toi nut users
        if(check_duplicated_user(new_user)) {
            System.out.println("Account had been signed");
            return ;
        }
        System.out.println("New account have been signed succesfully");
        String new_key = usersRef.push().getKey();
        usersRef.child(new_key).setValueAsync(new_user);
        usersManager.put(new_key, new_user);
    }
    public void delete_user_data(Users del_user) {
        String key = get_object_key(del_user);
        if(key.equals("")) {
            System.out.println("No account available");  
            return ;
        }
        DatabaseReference deleteRef = this.myRef.child("Users").child(key);
        deleteRef.removeValueAsync();
        usersManager.remove(key);
        System.out.println("Deleted succesfully key " + key);
    }
    public void read_user_data() {
        if(usersManager.isEmpty()) {
            System.out.println("Read_Empty");
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) {
//          System.out.print("Key: " + userEntry.getKey() + " ");
            System.out.println("Name: " + userEntry.getValue().username
                                + ", Email: " + userEntry.getValue().email
                                + ", Phone number: " + userEntry.getValue().phone_number);
        }
    }
    public boolean check_duplicated_user(Users user) {
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().username.equals(user.username)) { //so sanh 2 string giong nhau ko
               return true;
            }
        }
        return false;
    }
    private boolean check_login_user(Users user) { //check dang nhap
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().username.equals(user.username)) { //so sanh 2 string giong nhau ko
                if(userEntry.getValue().password.equals(user.password)) {
                    System.out.println("Login successfully");
                    return true;
                }
            }
        }
        System.out.println("Wrong password or username");
        return false;
    }
    // Add an object to Firebase, with Object class name as key and all of its variables as value.
    public void add(Object obj) throws IllegalAccessException {
    String className = obj.getClass().getSimpleName();
    DatabaseReference classRef = this.myRef.child(className); 
            Map<String, Object> objectMap = Manager.getObjectFieldsMap(obj);
            String new_key = classRef.push().getKey();
            classRef.child(new_key).setValueAsync(objectMap);

        if(className == "Users") {
            usersManager.put(new_key, (Users)obj);
        }
        else if(className == "Drivers") {
            driversManager.put(new_key, (Drivers)obj);
        }
        else if(className == "Vehicles") {
            vehiclesManager.put(new_key, (Vehicles)obj);
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
                if(user_data.username.equals(check_data))
                    return temp_entry.getKey();
            }
            else if(className.equals("Drivers") || className.equals("Vehicles")){
                Drivers driver_data = (Drivers)data;
                int check_data = (int)Manager.getFieldValue(obj, "id");
                if(driver_data.id == check_data)
                    return temp_entry.getKey();
            }                  
        }
        return "";
    }
    private String get_object_key(Object obj) {
        String className = obj.getClass().getSimpleName();
        Map<String, ?> temp_map = null;
        if("Users".equals(className)) {temp_map = usersManager;}
        else if("Vehicles".equals(className)) {temp_map = vehiclesManager;}
        else if("Drivers".equals(className)) {temp_map = driversManager;}
        else {
            System.out.println("Get key fail");
            return "";
        }

        return get_key(obj, temp_map);
    }
    public void delete(Object obj) {
        String className = obj.getClass().getSimpleName();
        Map<String, ?> temp_map = null;
        if("Users".equals(className)) {temp_map = usersManager;}
        else if("Vehicles".equals(className)) {temp_map = vehiclesManager;}
        else if("Drivers".equals(className)) {temp_map = driversManager;}
        else {
            System.out.println("Delete fail");
            return ;
        }
        
        String key = get_object_key(obj);
        DatabaseReference classRef = this.myRef.child(className).child(key);
        classRef.removeValueAsync();
        temp_map.remove(key);
        System.out.println("Deleted succesfully key " + className + " " + key);
    }
}

	
