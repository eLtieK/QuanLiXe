


import java.io.IOException;
import java.util.Scanner;
import menu.Login;

public class App {
   
    App() throws IOException {

    }
    public String getGreeting() {
        return "Hello World!";
    }
    public  void wait_system_load() {
        Scanner scanner = new Scanner(System.in);
        while(!scanner.nextLine().equals("Quit")){} //Quit de tiep tuc
    }
//    public static void main(String[] args) throws IOException, InterruptedException, Exception{
//        App myApp = new App();
//        final Manager manager = Manager.getInstance();
//        
//        myApp.wait_system_load();
//        
//        Drivers driver_1 = new Drivers("huy", "0123456789", "kontum", Drivers.License.E, 10, manager.getNumOfDrivers());
//        Drivers driver_2 = new Drivers("linh", "987654321", "tphcm", Drivers.License.D, 4, manager.getNumOfDrivers());
//        manager.addDriver(driver_1);
//        manager.addDriver(driver_2);
//        
//        Vehicles vehicle_1 = new Vehicles(1, 1, Vehicles.Fuel.diesel, Vehicles.Type.truck, manager.getNumOfVehicles());
//        Vehicles vehicle_2 = new Vehicles(2, 2, Vehicles.Fuel.ethanol, Vehicles.Type.coach, manager.getNumOfVehicles());
//        manager.addVehicle(vehicle_1);
//        manager.addVehicle(vehicle_2);
//        
//        manager.addUser(new Users("kiet", "kentom", "0946800349", "kennezversion@gmail.com"));
//        manager.addUser(new Users("cun", "cun123", "0123456789", "baoanh@gmai.com"));
//        manager.addUser(new Users("lebao", "baole321", "0908331349", "baolelb@gamil.com"));
//        manager.addUser(new Users("xuanhai", "hai1010", "0917220886", "haixuan@gamil.com"));
//        
//        myApp.wait_system_load();
//        
//        Trips trip_1 = new Trips("15:00:00", "2024-04-04", Trips.Destination.Ho_Chi_Minh, Trips.Destination.Hai_Phong, Trips.Status.waiting, vehicle_2.getId(), driver_1.getId(), manager.getNumOfTrips());
//        manager.addTrip(trip_1);
//        manager.makeTrip(trip_1);
//
//        manager.readDriver(manager.getBestDriver(vehicle_1.getType()));
//        manager.readVehicle(manager.getBestVehicle(vehicle_1.getType()));
//        myApp.wait_system_load();
//        
//        manager.readAllUsers();
//        manager.readAllDrivers();
//        manager.readAllVehicles();
//        manager.readAllTrip();
//        
//        manager.updateUsers();
//        manager.updateDrivers();
//        manager.updateVehicles();
//        manager.updateTrips();
//        
//       manager.removeAllUsers();
//    manager.removeAllDrivers();
//       manager.removeAllVehicles();
//      manager.removeAllTrip();
//        
//        myApp.wait_system_load();
//    }
    
    public static void main(String[] args) {
         Login LoginFrame = new Login();
         LoginFrame.setVisible(true);
         LoginFrame.pack();
         LoginFrame.setLocationRelativeTo(null);
         
    }
}
