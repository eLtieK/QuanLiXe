/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Vector;

public class Schedule {
   private Vector<Trip> trips;
   
   void add_trip(Trip new_trip) {
       trips.add(new_trip);
   }
}
