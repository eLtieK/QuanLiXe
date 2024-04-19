package database;


import static java.lang.Math.abs;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Vehicles {  
    public enum Type{ //add some type of vehicles
        truck,
        coach, //xe khach
        car,
        container
    }
    public static int index_type(Vehicles.Type ty) {
        if(ty.equals(Vehicles.Type.truck)) {
            return 0;
        } else if(ty.equals(Vehicles.Type.coach)) {
            return 1;
        } else if(ty.equals(Vehicles.Type.car)) {
            return 2;
        } else {
            return 3;
        }
    } 
    public static Vehicles.Type fromStringType(String text) {
        for (Type ty : Type.values()) {
            if (ty.name().equalsIgnoreCase(text)) {
                return ty;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in License enum");
    }
    public enum Fuel{ //add some fuel for vehicles
        diesel,
        gasoline,
        ethanol,
    }
    public static int index_fuel(Vehicles.Fuel fu) {
        if(fu.equals(Vehicles.Fuel.diesel)) {
            return 0;
        } else if(fu.equals(Vehicles.Fuel.gasoline)) {
            return 1;
        } else {
            return 2;
        }
    }
    public static Vehicles.Fuel fromStringFuel(String text) {
        for (Fuel fu : Fuel.values()) {
            if (fu.name().equalsIgnoreCase(text)) {
                return fu;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in License enum");
    }
    public enum Status{ //add some status for drivers
        ready,
        on_duty,
        under_maintenance,      //dang bao duong
        in_trip,             
    }
    public static Vehicles.Status fromStringStatus(String text) {
        for (Status sta : Status.values()) {
            if (sta.name().equalsIgnoreCase(text)) {
                return sta;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in License enum");
    }
    private int weight;
    private int size;
    private Fuel fuel;
    private Type type;
    private Status status;
    private int id;
    private long all_km;
    private long km_before_maintenace;
    private String date_start; //(yyyy-mm-dd)
    private String date_end; //(yyyy-mm-dd)

    Vehicles() {
        this.km_before_maintenace = Long.MAX_VALUE;
    }
    public Vehicles(int weight, int size, Fuel fuel, Type type, int id) {
        this.weight = weight;
        this.size = size;
        this.fuel = fuel;
        this.type = type;
        this.status = Status.ready;
        this.id = id;
        this.all_km = 0;
        this.km_before_maintenace = 0;
        this.date_start = "0000-00-00 00:00:00";
        this.date_end = "0000-00-00 00:00:00";
    }
    public Vehicles(int weight, int size, Vehicles.Fuel fuel, Vehicles.Type type, int id, Vehicles.Status status, long all_km, long km_bef, String start, String end) {
        this.weight = weight;
        this.size = size;
        this.fuel = fuel;
        this.type = type;
        this.status = status;
        this.id = id;
        this.all_km = all_km;
        this.km_before_maintenace = km_bef;
        this.date_start = start;
        this.date_end = end;
    }
    
    public int getWeight() {
        return this.weight;
    }
    public int getSize() {
        return this.size;
    }
    public Vehicles.Fuel getFuel() {
        return this.fuel;
    }
    public Vehicles.Type getType() {
        return this.type;
    }
    public Vehicles.Status getStatus() {
        return this.status;
    }    
    public int getId() {
        return this.id;
    }
    public long getAll_km() {
        return this.all_km;
    }
    public long getKm_before_maintenace() {
        return this.km_before_maintenace;
    }
    public String getDate_start() {
        return this.date_start;
    }
    public String getDate_end() {
        return this.date_end;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public void setType(String ty) {
        this.type = Vehicles.fromStringType(ty);
    }
    public void setFuel(String fu) {
        this.fuel = Vehicles.fromStringFuel(fu);
    }
    public void setDate_start(String start) {
        this.date_start = start;
    }
    public void setDate_end(String end) {
        this.date_end = end;
    }
    public void setStatus(Vehicles.Status sta) {
        this.status = sta;
    }
    
    public Drivers.License get_suitable_license () {
        if(this.type.equals(Vehicles.Type.car)) {
            return Drivers.License.B2;
        }
        else if(this.type.equals(Vehicles.Type.coach)) {
            return Drivers.License.C;
        }
        else if(this.type.equals(Vehicles.Type.truck)) {
            return Drivers.License.D;
        }
        else {
            return Drivers.License.E;
        }
    }
    public String get_all_suitable_license () {
        if(this.type.equals(Vehicles.Type.car)) {
            return "B2, C, D, E";
        }
        else if(this.type.equals(Vehicles.Type.coach)) {
            return "C, D, E";
        }
        else if(this.type.equals(Vehicles.Type.truck)) {
            return "D, E";
        }
        else {
            return "E";
        }
    }
    
    public boolean is_need_maintenace () {
        if(this.km_before_maintenace >= 10000) {
            return true;
        }
        return false;
    }
    
    public boolean is_maintenance () {
        return !this.date_start.equals("0000-00-00 00:00:00") && !this.date_end.equals("0000-00-00 00:00:00");
    }

    public static int get_price_fuel(Vehicles.Fuel fuel) throws Exception {
        switch (fuel) {
            case Vehicles.Fuel.diesel:
                return 22;
            case Vehicles.Fuel.ethanol:
                return 20;
            case Vehicles.Fuel.gasoline:
                return 15;
        }
        throw new Exception("Error: Unable to get price_fuel");
    }
    
    public static int get_fuel_cosumption_rate(Vehicles.Type type, Vehicles.Fuel fuel) throws Exception { //1h di ton bao nhieu li xang
        switch (type) {
            case Vehicles.Type.car:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 4;
                    case Vehicles.Fuel.ethanol:
                        return 8;
                    case Vehicles.Fuel.gasoline:
                        return 6    ;
                }
           case Vehicles.Type.truck:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 7;
                    case Vehicles.Fuel.ethanol:
                        return 10;
                    case Vehicles.Fuel.gasoline:
                        return 9;
                }
            case Vehicles.Type.coach:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 5;
                    case Vehicles.Fuel.ethanol:
                        return 9;
                    case Vehicles.Fuel.gasoline:
                        return 7;
                }
            case Vehicles.Type.container:
                switch (fuel) {
                    case Vehicles.Fuel.diesel:
                        return 12;
                    case Vehicles.Fuel.ethanol:
                        return 22;
                    case Vehicles.Fuel.gasoline:
                        return 18;
                }
        }
        throw new Exception("Error: Unable to get fuel_cosumption_rate");
    }
    
    public void increase_km(int distance) {
        this.all_km += distance;
        this.km_before_maintenace += distance;
    }
    public void reset_km() {
        this.km_before_maintenace = 0;
    }
    public void make_vehicle_in_trip() {
        this.status = Vehicles.Status.in_trip;
    }
    public void make_vehicle_ready() {
        this.status = Vehicles.Status.ready;
    }
    public boolean check_vehicle_in_trip() {
        return (this.status.equals(Vehicles.Status.in_trip));
    }
    public LocalDateTime get_start_date() {
         return LocalDateTime.parse(date_start, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public LocalDateTime get_end_date() {
        return LocalDateTime.parse(date_end, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public boolean chech_start() {
        return get_start_date().isBefore(Schedule.get_now_time()) || get_start_date().isEqual(Schedule.get_now_time());
    }
    public boolean chech_end() {
        return get_end_date().isBefore(Schedule.get_now_time()) || get_end_date().isEqual(Schedule.get_now_time());
    }
}
