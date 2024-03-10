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

public class ManagementSystem {
    private DatabaseReference myRef;
    public Map<String, Users> usersManager;
    
    ManagementSystem() throws IOException {
        init_Firebase();
        setup_Firebase_reference();
        load_user_data();
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
    }
    private void load_user_data() { //load data tu firebase vao map usersManager
        DatabaseReference usersRef = this.myRef.child("users");
        
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() { //se kich hoat mien firebase co data
            @Override
            public void onDataChange(DataSnapshot snapshot) { //chuyen doi data dang json_tree thanh map
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Users>>() {}.getType();
                usersManager = new Gson().fromJson(jsonString, type);
                System.out.println("Data loaded succesfully");
            }

            @Override
            public void onCancelled(DatabaseError error) { //xu li loi
                System.err.println("Error while reading: " + error.getMessage());
            }
            
        });
    }
    public void save_user_data(Users new_user) {
        DatabaseReference usersRef = this.myRef.child("users"); //duong dan toi nut users
        if(check_login_user(new_user.username, new_user.password)) {
            System.out.println("Account had been signed");
            return ;
        }
        System.out.println("New account have been signed succesfully");
        String new_key = usersRef.push().getKey();
        usersRef.child(new_key).setValueAsync(new_user);
        usersManager.put(new_key, new_user);
    }
    private String get_user_key(String temp_username, String temp_password) {
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");  
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().username.equals(temp_username)) { //so sanh 2 string giong nhau ko
                if(userEntry.getValue().password.equals(temp_password)) {
                    return userEntry.getKey();
                }
            }
        }
        return "";
    }
    public void delete_user_data(String temp_username, String temp_password) {
        String key = get_user_key(temp_username, temp_password);
        if(key.equals("")) {
            System.out.println("No account available");  
            return ;
        }
        DatabaseReference deleteRef = this.myRef.child("users").child(key);
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
    private boolean check_login_user(String temp_username, String temp_password) { //da co tai khoan ton tai chua
        if(usersManager.isEmpty()) {
            System.out.println("Check_Empty");
            return false;
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) { //duyet qua map
            if(userEntry.getValue().username.equals(temp_username)) { //so sanh 2 string giong nhau ko
                if(userEntry.getValue().password.equals(temp_password)) {
                    return true;
                }
            }
        }
        return false;
    }
}
