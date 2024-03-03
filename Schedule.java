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
   private boolean[][] schedule;
   private Vector<Trip> trips;
   
   Schedule() { //constructor tao lich 7 ngay, 24h
       for(int i = 0; i < 7; i++) {
           for(int j = 0; j < 24; j++) {
               schedule[i][j] = false;
           }
       }
   }
   void add_trip(Trip new_trip) {
       trips.add(new_trip);
   }
}
