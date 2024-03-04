/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.List;

public class ManagementSystem {
    private List<Vehicles> vehicles;
    private List<Drivers> drivers;
    private List<Trip> trips;
    
    public ManagementSystem(List<Vehicles> vehicles, List<Drivers> drivers, List<Trip> trips) {
        this.vehicles = vehicles;
        this.drivers = drivers;
        this.trips = trips;
    }
}
