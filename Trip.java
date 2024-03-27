import java.util.Map;

public class Trip {
   enum Status {
        on_trip,
        waiting
    }    
   enum Destination {
       Ho_Chi_Minh,
       Ha_Noi,
       Da_Nang,
       Hue,
       Can_Tho,
       Hai_Phong
   }
    private String time_start;
    private Destination destination_end;
    private Destination destination_start;
    private double expected_time; //du kien thoi gian den
    private Status status;
    private Vehicles vehicle;
    private Drivers driver;
    
    Trip(String time_start, Trip.Destination start, Trip.Destination end) throws Exception {
        this.time_start = time_start;
        this.destination_start = start;
        this.destination_end = end;
        this.status = Status.waiting;
        this.expected_time = caculate_expected_time();
    }
    
    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }
    
    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
    
    private double caculate_expected_time() throws Exception{
        return Trip.getDistance(this.destination_start ,this.destination_end) / this.driver.getAverageSpeed();
    } 
    
    public static int getDistance(Trip.Destination start, Trip.Destination end) throws Exception{
        switch (start) { 
            case Trip.Destination.Ho_Chi_Minh:
                switch (end) {
                    case Trip.Destination.Ha_Noi:
                        return 1723;
                    case Trip.Destination.Da_Nang:
                        return 959;
                    case Trip.Destination.Hue:
                        return 929;
                    case Trip.Destination.Can_Tho:
                        return 157;
                    case Trip.Destination.Hai_Phong:
                        return 1794;
                }
            case Trip.Destination.Ha_Noi:
                switch (end) {
                    case Trip.Destination.Ho_Chi_Minh:
                        return 1723;
                    case Trip.Destination.Da_Nang:
                        return 766;
                    case Trip.Destination.Hue:
                        return 668;
                    case Trip.Destination.Can_Tho:
                        return 1600;
                    case Trip.Destination.Hai_Phong:
                        return 121;
                }
            case Trip.Destination.Da_Nang:
                switch (end) {
                    case Trip.Destination.Ha_Noi:
                        return 766;
                    case Trip.Destination.Ho_Chi_Minh:
                        return 959;
                    case Trip.Destination.Hue:
                        return 100;
                    case Trip.Destination.Can_Tho:
                        return 1115;
                    case Trip.Destination.Hai_Phong:
                        return 828;
                }
            case Trip.Destination.Hue:
                switch (end) {
                    case Trip.Destination.Ha_Noi:
                        return 668;
                    case Trip.Destination.Da_Nang:
                        return 100;
                    case Trip.Destination.Ho_Chi_Minh:
                        return 929;
                    case Trip.Destination.Can_Tho:
                        return 739;
                    case Trip.Destination.Hai_Phong:
                        return 749;
                }
            case Trip.Destination.Can_Tho:
                switch (end) {
                    case Trip.Destination.Ha_Noi:
                        return 1600;
                    case Trip.Destination.Da_Nang:
                        return 1115;
                    case Trip.Destination.Hue:
                        return 739;
                    case Trip.Destination.Ho_Chi_Minh:
                        return 157;
                    case Trip.Destination.Hai_Phong:
                        return 1207;
                }
            case Trip.Destination.Hai_Phong:
                switch (end) {
                    case Trip.Destination.Ha_Noi:
                        return 121;
                    case Trip.Destination.Da_Nang:
                        return 828;
                    case Trip.Destination.Hue:
                        return 749;
                    case Trip.Destination.Can_Tho:
                        return 1207;
                    case Trip.Destination.Ho_Chi_Minh:
                        return 1723;
                }
        }
        throw new Exception("Error: Unable to get distance");
    }
    
    public static Pair<Drivers, Vehicles> optimization_trip(Vehicles.Type type) {
        Map<String, Drivers> map_drivers = Manager.getFirebase().driversManager;
        Map<String, Vehicles> map_vehicles = Manager.getFirebase().vehiclesManager;
        
    }
}
