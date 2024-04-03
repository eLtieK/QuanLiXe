import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    
    Trip(String time_start, String date_start, Trip.Destination start, Trip.Destination end, Vehicles vehicle, Drivers driver, int id) throws Exception {
        this.time_start = time_start; 
        this.date_start = date_start;
        this.destination_start = start;
        this.destination_end = end;
        this.status = Status.waiting;
        this.expected_time = caculate_expected_time();
        this.time_remaining = this.expected_time;
        this.driver = driver;
        this.vehicle = vehicle;
        this.id = id;
    }
    public int getId() {
        return this.id;
    }
    public Trip.Destination getDestination_start() {
        return this.destination_start;
    }
    public Trip.Destination getDestination_end() {
        return this.destination_end;
    }
    public long getExpected_time() {
        return this.expected_time;
    }
    public Trip.Status getStatus() {
        return this.status;
    }
    public String getTime() {
        return get_time().toString();
    }
    public Drivers getDriver() {
        return this.driver;
    }
    public Vehicles getVehicle() {
        return this.vehicle;
    }
    
    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }
    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
    
    private long caculate_expected_time() throws Exception{
        return (Trip.getDistance(this.destination_start ,this.destination_end) / this.driver.getAverageSpeed()) * 3600;
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
        } else if (li.equals(Drivers.License.D) && !type.equals(Vehicles.Type.car)) {
            return true;
        } else if (li.equals(Drivers.License.E)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void trip_on_ready() {
        if(get_time().isAfter(Schedule.get_now_time()) || get_time().isEqual(Schedule.get_now_time())) {
            this.status = Trip.Status.on_trip;
            trip_on_duty();
        }
    }
    
    public void trip_on_duty() {
        Thread updateThread = new Thread(() -> {
            while (this.time_remaining > 0) {
                // Cập nhật dữ liệu hoặc thực hiện các tác vụ cần thiết ở đây
                this.time_remaining -= 3600;
                try {
                    // Tạm ngừng luồng cập nhật trong 1 giây
                    Thread.sleep(1000); // milliseconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        updateThread.start();
    }
}
