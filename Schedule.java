/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.util.Map;
import java.time.LocalDateTime;

public class Schedule {
   public static int get_now_hour() {
       return LocalDateTime.now().getHour();
   } 
   public static int get_now_day() {
       return LocalDateTime.now().getDayOfMonth();
   }  
   public static int get_now_month() {
       return LocalDateTime.now().getMonthValue();
   }  
   public static int get_now_year() {
       return LocalDateTime.now().getYear();
   }  
   public static int get_now_minute() {
       return LocalDateTime.now().getMinute();
   }
   public static int get_now_second() {
       return LocalDateTime.now().getSecond();
   }
   public static LocalDateTime get_now_time() {
       return LocalDateTime.now();
   }
    
   public static int get_hour(LocalDateTime dateTime) {
       return dateTime.getHour();
   } 
   public static int get_day(LocalDateTime dateTime) {
       return dateTime.getDayOfMonth();
   }  
   public static int get_month(LocalDateTime dateTime) {
       return dateTime.getMonthValue();
   }  
   public static int get_year(LocalDateTime dateTime) {
       return dateTime.getYear();
   }  
   public static int get_minute(LocalDateTime dateTime) {
       return dateTime.getMinute();
   }
   public static int get_second(LocalDateTime dateTime) {
       return dateTime.getSecond();
   }
}
