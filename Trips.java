import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Trips {
   enum Status {
        on_trip,
        waiting;
        
        public static Trips.Status fromString(String text) {
            for (Status status : Status.values()) {
                if (status.name().equalsIgnoreCase(text)) {
                    return status;
                }
            }
            throw new IllegalArgumentException("No constant with text " + text + " found in Status enum");
        }
    }    
   enum Destination {
       Ho_Chi_Minh,
       Ha_Noi,
       Da_Nang,
       Hue,
       Can_Tho,
       Hai_Phong;
       
       public static Destination fromString(String text) {
            for (Destination des : Destination.values()) {
                if (des.name().equalsIgnoreCase(text)) {
                    return des;
                }
            }
            throw new IllegalArgumentException("No constant with text " + text + " found in Destination enum");
       }
   }
    private String date_start; //(yyyy-mm-dd)
    private String time_start; //(HH:mm:ss)
    private long time_remaining;
    private Destination destination_end;
    private Destination destination_start;
    private long expected_time; //du kien thoi gian den
    private Status status;
    private Vehicles vehicle;
    private Drivers driver;
    private int id;
    
    Trips() {
        
    };
    Trips(String time_start, String date_start, Trips.Destination start, Trips.Destination end, Vehicles vehicle, Drivers driver, int id) throws Exception {
        this.time_start = time_start; 
        this.date_start = date_start;
        this.destination_start = start;
        this.destination_end = end;
        this.status = Status.waiting;
        this.driver = driver;
        this.vehicle = vehicle;
        this.id = id;
        this.expected_time = caculate_expected_time();
        this.time_remaining = caculate_expected_time();
    }
    public int getId() {
        return this.id;
    }
    public Trips.Destination getDestination_start() {
        return this.destination_start;
    }
    public Trips.Destination getDestination_end() {
        return this.destination_end;
    }
    public long getExpected_time() {
        return this.expected_time;
    }
    public Trips.Status getStatus() {
        return this.status;
    }
    public String getTime() {
        return Schedule.format_time(get_time());
    }
    public Drivers getDriver() {
        return this.driver;
    }
    public Vehicles getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicles vehicle) {
        this.vehicle = new Vehicles(vehicle);
    }
    public void setDriver(Drivers driver) {
        this.driver = new Drivers(driver);
    }
    
    private long caculate_expected_time() throws Exception{
        return (Trips.getDistance(this.destination_start ,this.destination_end) / this.driver.getAverageSpeed()) * 3600;
    } 
    
    public long caculate_trip_cost() throws Exception {
        return ( (Vehicles.get_fuel_cosumption_rate(this.vehicle.getType(), this.vehicle.getFuel()) * Vehicles.get_price_fuel(this.vehicle.getFuel())) 
                + (Drivers.getProfit(this.driver.getLicense())) ) * ( this.expected_time / 3600);
    }
    
    public static int getDistance(Trips.Destination start, Trips.Destination end) throws Exception{
        switch (start) { 
            case Trips.Destination.Ho_Chi_Minh:
                switch (end) {
                    case Trips.Destination.Ha_Noi:
                        return 1723;
                    case Trips.Destination.Da_Nang:
                        return 959;
                    case Trips.Destination.Hue:
                        return 929;
                    case Trips.Destination.Can_Tho:
                        return 157;
                    case Trips.Destination.Hai_Phong:
                        return 1794;
                }
            case Trips.Destination.Ha_Noi:
                switch (end) {
                    case Trips.Destination.Ho_Chi_Minh:
                        return 1723;
                    case Trips.Destination.Da_Nang:
                        return 766;
                    case Trips.Destination.Hue:
                        return 668;
                    case Trips.Destination.Can_Tho:
                        return 1600;
                    case Trips.Destination.Hai_Phong:
                        return 121;
                }
            case Trips.Destination.Da_Nang:
                switch (end) {
                    case Trips.Destination.Ha_Noi:
                        return 766;
                    case Trips.Destination.Ho_Chi_Minh:
                        return 959;
                    case Trips.Destination.Hue:
                        return 100;
                    case Trips.Destination.Can_Tho:
                        return 1115;
                    case Trips.Destination.Hai_Phong:
                        return 828;
                }
            case Trips.Destination.Hue:
                switch (end) {
                    case Trips.Destination.Ha_Noi:
                        return 668;
                    case Trips.Destination.Da_Nang:
                        return 100;
                    case Trips.Destination.Ho_Chi_Minh:
                        return 929;
                    case Trips.Destination.Can_Tho:
                        return 739;
                    case Trips.Destination.Hai_Phong:
                        return 749;
                }
            case Trips.Destination.Can_Tho:
                switch (end) {
                    case Trips.Destination.Ha_Noi:
                        return 1600;
                    case Trips.Destination.Da_Nang:
                        return 1115;
                    case Trips.Destination.Hue:
                        return 739;
                    case Trips.Destination.Ho_Chi_Minh:
                        return 157;
                    case Trips.Destination.Hai_Phong:
                        return 1207;
                }
            case Trips.Destination.Hai_Phong:
                switch (end) {
                    case Trips.Destination.Ha_Noi:
                        return 121;
                    case Trips.Destination.Da_Nang:
                        return 828;
                    case Trips.Destination.Hue:
                        return 749;
                    case Trips.Destination.Can_Tho:
                        return 1207;
                    case Trips.Destination.Ho_Chi_Minh:
                        return 1723;
                }
        }
        throw new Exception("Error: Unable to get distance");
    }
    
    public LocalDateTime get_time() {
        String dateTimeInput = date_start + " " + time_start;
        return LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    //help method 
    public static boolean check_suitable(Drivers.License li, Vehicles.Type type) {
        if(li.equals(Drivers.License.B2) && type.equals(Vehicles.Type.car)) {
            return true;
        } else if (li.equals(Drivers.License.C) && 
                   (type.equals(Vehicles.Type.car) || type.equals(Vehicles.Type.coach)) ) {
            return true;
        } else if (li.equals(Drivers.License.D) && !type.equals(Vehicles.Type.container)) {
            return true;
        } else if (li.equals(Drivers.License.E)) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean trip_on_ready() throws Exception {
        if(this.driver.getPerformance() < this.expected_time / 3600) {
            System.out.println("Driver can't drive because of lack of performance");
            return false;
        }
        if(get_time().isBefore(Schedule.get_now_time()) || get_time().isEqual(Schedule.get_now_time())) {
            this.status = Trips.Status.on_trip;
            trip_on_duty();
            return true;
        }
        return false;
    }
    
    public void trip_on_duty() throws Exception {
        Thread updateThread = new Thread(() -> {
            while (this.time_remaining > 0) {
                // Cập nhật dữ liệu hoặc thực hiện các tác vụ cần thiết ở đây
                this.time_remaining -= 3600;
                this.driver.reducePerformance(1);
                System.out.println("Trip's id: " + this.id + " is making a trip ... " + (int)(((this.expected_time - this.time_remaining) * 100) / this.expected_time) + "%");
                try {
                    // Tạm ngừng luồng cập nhật trong 1 giây
                    Thread.sleep(1000); // milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        if(this.time_remaining > 0) {
            this.vehicle.increase_km(Trips.getDistance(this.destination_start, this.destination_end));

        }
        updateThread.start();
    }
}
