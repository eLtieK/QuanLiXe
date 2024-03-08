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
import java.io.FileNotFoundException;
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
    private void init_Firebase() throws FileNotFoundException, IOException{
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
    public void save_user_data(Users new_user) throws InterruptedException {
        DatabaseReference usersRef = this.myRef.child("users");
        usersRef.push().setValueAsync(new_user);
    }
    private void load_user_data() {
        DatabaseReference usersRef = this.myRef.child("users");
        
        usersRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {   
                String jsonString = snapshot.getValue().toString();
                Type type = new TypeToken<Map<String, Users>>() {}.getType();
                usersManager = new Gson().fromJson(jsonString, type);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                System.err.println("Error while reading: " + error.getMessage());
            }
            
        });
    }
    public void read_user_data() {
        if(usersManager.isEmpty()) {
            System.out.println("Empty");
        }
        for(Map.Entry<String, Users> userEntry : usersManager.entrySet()) {
            System.out.println("Name: " + userEntry.getValue().username
                                + ", Email: " + userEntry.getValue().email
                                + ", Phone number: " + userEntry.getValue().phone_number);
        }
    }
}
