/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Trip {
   enum Status {
        on_trip,
        waiting
    }    
    private Vehicles vehicle;
    private Drivers driver;
    private String time_start;
    private String destination;
    private String expected_time; //du kien thoi gian den
    private Status status;
    
    Trip(Vehicles vehicle, Drivers driver, String time_start, String destination) {
        this.vehicle = vehicle;
        this.driver = driver;
        this.time_start = time_start;
        this.destination = destination;
        this.status = Status.waiting;
        this.expected_time = caculate_expected_time();
    }
    
    String caculate_expected_time(){
        return "00:00";
    } 
}
