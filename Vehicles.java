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
    //private String nickname; bonus feature :)) 

    Vehicles(int weight, int size, Fuel fuel, Type type, int id) {
        this.weight = weight;
        this.size = size;
        this.fuel = fuel;
        this.type = type;
        this.status = Status.ready;
        this.id = id;
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
}
