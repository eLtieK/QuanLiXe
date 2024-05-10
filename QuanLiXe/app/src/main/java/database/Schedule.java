package database;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
   public static String get_now_time_string() {
       return Schedule.format_time(Schedule.get_now_time());
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
   
   public static String format_time(LocalDateTime time) {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return time.format(formatter);
   }
   public static LocalDateTime get_date(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(date, formatter);
    }
   public static boolean check_logic_date(String start, String end) {
       return Schedule.get_date(start).isBefore(Schedule.get_date(end));
   }
   public static boolean check_logic_date(String time) {
       return Schedule.get_date(time).isBefore(Schedule.get_now_time()) || Schedule.get_date(time).isEqual(Schedule.get_now_time());
   }
   public static String convertSecondsToTimeString(long seconds) {
        long hours = seconds / 3600;
        long remainder = seconds % 3600;
        long minutes = remainder / 60;
        long remainingSeconds = remainder % 60;
        
        return String.format("%02d:%02d:%02d", hours, minutes, remainingSeconds);
    }
}
