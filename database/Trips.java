package database;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trips {

    public enum Status {
        on_trip,
        done,
        waiting;
    }
    
    public static Trips.Status fromStringStatus(String text) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in Status enum");
    }

    public enum Destination {
        Ho_Chi_Minh,
        Ha_Noi,
        Da_Nang,
        Hue,
        Can_Tho,
        Hai_Phong;
    }
    public static int index_destination_start (Trips.Destination de) {
        if(de.equals(Trips.Destination.Ho_Chi_Minh)) {
            return 0;
        } else if(de.equals(Trips.Destination.Ha_Noi)) {
            return 1;
        } else if(de.equals(Trips.Destination.Da_Nang)) {
            return 2;
        } else if(de.equals(Trips.Destination.Hue)) {
            return 3;
        } else if(de.equals(Trips.Destination.Can_Tho)) {
            return 4;
        } else {
            return 5;
        }
    }
    public static int index_destination_end (Trips.Destination de) {
        if(de.equals(Trips.Destination.Ho_Chi_Minh)) {
            return 1;
        } else if(de.equals(Trips.Destination.Ha_Noi)) {
            return 0;
        } else if(de.equals(Trips.Destination.Da_Nang)) {
            return 2;
        } else if(de.equals(Trips.Destination.Hue)) {
            return 3;
        } else if(de.equals(Trips.Destination.Can_Tho)) {
            return 4;
        } else {
            return 5;
        }
    }
    public static Destination fromStringDestination(String text) {
        for (Destination des : Destination.values()) {
            if (des.name().equalsIgnoreCase(text)) {
                return des;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in Destination enum");
    }

    private String date_start; //(yyyy-mm-dd)
    private String time_start; //(HH:mm:ss)
    private Destination destination_end;
    private Destination destination_start;
    private Status status;
    private int vehicle_id;
    private int driver_id;
    private int id;

    public Trips(String time_start, String date_start, Trips.Destination start, Trips.Destination end, Trips.Status status, int vehicle, int driver, int id) throws Exception {
        this.time_start = time_start;
        this.date_start = date_start;
        this.destination_start = start;
        this.destination_end = end;
        this.status = status;
        this.driver_id = driver;
        this.vehicle_id = vehicle;
        this.id = id;
    }

    public Trips() {

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
    public String getTimeStart() {
        return this.time_start;
    }
    public String getDateStart() {
        return this.date_start;
    }
    public long getExpected_time() throws Exception {
        return this.caculate_expected_time();
    }

    public Trips.Status getStatus() {
        return this.status;
    }

    public String getTime() {
        return Schedule.format_time(get_time());
    }

    public int getDriverId() {
        return this.driver_id;
    }

    public int getVehicleId() {
        return this.vehicle_id;
    }
    
    public void setTimeStart(String ti) {
        this.time_start = ti;
    }
    public void setDateStart(String da) {
        this.date_start = da;
    }
    public void setDesStart(Trips.Destination sta) {
        this.destination_start = sta;
    }
    public void setDesEnd(Trips.Destination end) {
        this.destination_end = end;
    }
    public void setDriverId(int dri) {
        this.driver_id = dri;
    }
    public void setVehicleId(int ve) {
        this.vehicle_id = ve;
    } 
    public void setStatus(Trips.Status sta) {
        this.status = sta;
    }
    public long caculate_expected_time() throws Exception {
        Drivers driver = Manager.getInstance().getDriver(this.driver_id);
        return (Trips.getDistance(this.destination_start, this.destination_end) / driver.getAverageSpeed()) * 3600;
    }

    public long caculate_trip_cost() throws Exception {
        Vehicles vehicle = Manager.getInstance().getVehicle(this.vehicle_id);
        Drivers driver = Manager.getInstance().getDriver(this.driver_id);
        return ((Vehicles.get_fuel_cosumption_rate(vehicle.getType(), vehicle.getFuel()) * Vehicles.get_price_fuel(vehicle.getFuel()))
                + (Drivers.getProfit(driver.getLicense()))) * (this.caculate_expected_time() / 3600);
    }

    public static int getDistance(Trips.Destination start, Trips.Destination end) throws Exception {
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
        if (li.equals(Drivers.License.B2) && type.equals(Vehicles.Type.car)) {
            return true;
        } else if (li.equals(Drivers.License.C)
                && (type.equals(Vehicles.Type.car) || type.equals(Vehicles.Type.coach))) {
            return true;
        } else if (li.equals(Drivers.License.D) && !type.equals(Vehicles.Type.container)) {
            return true;
        } else if (li.equals(Drivers.License.E)) {
            return true;
        } else {
            return false;
        }
    }
    public boolean is_done() {
        return this.status.equals(Trips.Status.done);
    }
    public boolean is_trip_done() {
        if (this.status.equals(Trips.Status.done)) {
            System.out.println("This trip has been done");
            return true;
        } else if (this.status.equals(Trips.Status.waiting)) {
            System.out.println("This trip is waiting to execute");
            return true;
        } else if (this.status.equals(Trips.Status.on_trip)) {
            System.out.println("This trip is on_duty");
        }
        return false;
    }

    public boolean trip_on_ready() throws Exception {
        Drivers driver = Manager.getInstance().getDriver(this.driver_id);
        if (driver.getPerformance() < this.caculate_expected_time() / 3600 || is_done()) {
            System.out.println("Driver can't drive because of lack of performance");
            return false;
        }
        if (get_time().isBefore(Schedule.get_now_time()) || get_time().isEqual(Schedule.get_now_time())) {
            this.status = Trips.Status.on_trip;
            Manager.updateTrips();
            return true;
        }
        return false;
    }

    public void trip_on_duty() throws Exception {
        Thread updateThread = new Thread(() -> {
            try {
                Drivers driver = Manager.getInstance().getDriver(this.driver_id);
                long expected_time = this.caculate_expected_time();
                long time_remaining = expected_time;
                while (time_remaining > 0) {
                    // Cập nhật dữ liệu hoặc thực hiện các tác vụ cần thiết ở đây
                    time_remaining -= 3600;
                    //driver.reducePerformance(1);
                    System.out.println("Trip's id: " + this.id + " is making a trip ... " + (int) (((expected_time - time_remaining) * 100) / expected_time) + "%");
                    try {
                        // Tạm ngừng luồng cập nhật trong 1 giây
                        Thread.sleep(1000); // milliseconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception ex) {
                Logger.getLogger(Trips.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        if (this.status.equals(Trips.Status.done)) {
            Vehicles vehicle = Manager.getInstance().getVehicle(this.vehicle_id);
            vehicle.increase_km(Trips.getDistance(this.destination_start, this.destination_end));
            Manager.updateVehicles();
        } else {
            updateThread.start();
            this.status = Trips.Status.done;
            set_up_waiting();
            this.driver_id = -1;
            this.vehicle_id = -1;
            Manager.updateTrips();
        }
    }

    public void set_up_in_trip() throws Exception {
        Manager.getDriver(this.driver_id).make_driver_in_trip();
        Manager.getVehicle(this.vehicle_id).make_vehicle_in_trip();
        Manager.updateDrivers();
        Manager.updateVehicles();
    }

    public void set_up_waiting() throws Exception {
        Manager.getDriver(this.driver_id).make_driver_ready();
        Manager.getVehicle(this.vehicle_id).make_vehicle_ready();
        Manager.updateDrivers();
        Manager.updateVehicles();
    }
}
