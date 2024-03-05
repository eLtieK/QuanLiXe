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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ManagementSystem {
    private List<Vehicles> vehicles;
    private List<Drivers> drivers;
    private List<Trip> trips;
    private List<Users> users;
    private DatabaseReference rootDatabase_ref;
    
    public ManagementSystem() {
        
    }    
    public ManagementSystem(List<Vehicles> vehicles, List<Drivers> drivers, List<Trip> trips, List<Users> users) throws IOException {
        this.vehicles = vehicles;
        this.drivers = drivers;
        this.trips = trips;
        this.users = users;
        init_Firebase();
        this.rootDatabase_ref = FirebaseDatabase.getInstance().getReference();
    }
    
    private static void init_Firebase() throws FileNotFoundException, IOException{
        if(FirebaseApp.getApps().isEmpty()) { 
            FileInputStream refreshToken = new FileInputStream("cridentials .json");

            FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(refreshToken))
                .setDatabaseUrl("https://quanlixe-9970a-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build();

            FirebaseApp.initializeApp(options);
        }
    }
    
    public void save_user_data(Users new_user) {
        DatabaseReference user_data = this.rootDatabase_ref.child("Users");
        user_data.setValueAsync(new_user.get_name());
    }
}
