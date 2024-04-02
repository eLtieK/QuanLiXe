/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Vehicles {  
    enum Type{ //add some type of vehicles
        truck,
        coach, //xe khach
        car,
        container
    }
    enum Fuel{ //add some fuel for vehicles
        diesel,
        gasoline,
        ethanol,
        bio_diesel,
    }
    enum Status{ //add some status for drivers
        ready,
        on_duty,
        under_maintenance //dang bao duong
    }
    private int weight;
    private int size;
    private Fuel fuel;
    private Type type;
    private Status status;
    private int id;
    private double all_km;
    private double km_before_maintenace;
    //private String nickname; bonus feature :)) 

    Vehicles() {
        this.km_before_maintenace = Double.POSITIVE_INFINITY;
    }
    Vehicles(int weight, int size, Fuel fuel, Type type, int id) {
        this.weight = weight;
        this.size = size;
        this.fuel = fuel;
        this.type = type;
        this.status = Status.ready;
        this.id = id;
        this.all_km = 0;
        this.km_before_maintenace = 0;
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
    public double getAll_km() {
        return this.all_km;
    }
    public double getKm_before_maintenace() {
        return this.km_before_maintenace;
    }
    
    public Drivers.License getSuitableLicense () {
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
    
    public boolean is_need_maintenace () {
        if(this.km_before_maintenace >= 10000) {
            return true;
        }
        return false;
    }
    
    public void reset_after_maintenace() {
        this.km_before_maintenace = 0;
        this.status = Vehicles.Status.under_maintenance;
    }
}
