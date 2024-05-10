package database;

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
public class Drivers {

    public enum License {
        B2, C, D, E
    }

    public static int index_license(Drivers.License li) {
        if (li.equals(Drivers.License.B2)) {
            return 0;
        } else if (li.equals(Drivers.License.C)) {
            return 1;
        } else if (li.equals(Drivers.License.D)) {
            return 2;
        } else  {
            return 3;
        }

    }

    public static Drivers.License fromStringLicense(String text) {
        for (License li : License.values()) {
            if (li.name().equalsIgnoreCase(text)) {
                return li;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in License enum");
    }

    public enum Status { //add some status for drivers
        ready,
        not_available,
        in_trip
    }

    public static Drivers.Status fromStringStatus(String text) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(text)) {
                return status;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in Status enum");
    }
    private String name;
    private String phone_number;
    private String address;
    private License license;
    private int experiences; //years of experiences (can be int)
    private Status status;
    private int performance;
    private int id;
    private String date_start; //(yyyy-mm-dd)
    private String date_end; //(yyyy-mm-dd)

    Drivers() {
        this.experiences = 0;
    }

    public Drivers(String name, String phone_number, String address, License license, int experiences, int id) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.license = license;
        this.experiences = experiences;
        this.status = Status.ready;
        this.id = id;
        this.performance = 100;
        this.date_start = "0000-00-00 00:00:00";
        this.date_end = "0000-00-00 00:00:00";
    }

    public Drivers(String name, String phone_number, String address, License license, int experiences, Drivers.Status status, int id, int performance, String start, String end) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.license = license;
        this.experiences = experiences;
        this.status = status;
        this.id = id;
        this.performance = performance;
        this.date_start = start;
        this.date_end = end;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getPhonenumber() {
        return this.phone_number;
    }

    public Drivers.License getLicense() {
        return this.license;
    }

    public int getExperiences() {
        return this.experiences;
    }

    public Drivers.Status getStatus() {
        return this.status;
    }

    public int getId() {
        return this.id;
    }

    public int getPerformance() {
        return this.performance;
    }
    public String getDate_start() {
        return this.date_start;
    }
    public String getDate_end() {
        return this.date_end;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhonenumber(String phone) {
        this.phone_number = phone;
    }

    public void setLicense(String li) {
        this.license = Drivers.fromStringLicense(li);
    }

    public void setExperiences(int ex) {
        this.experiences = ex;
    }
     public void setDate_start(String start) {
        this.date_start = start;
    }
    public void setDate_end(String end) {
        this.date_end = end;
    }
    public void setStatus(Drivers.Status sta) {
        this.status = sta;
    }

    public void reducePerformance(int num) {
        this.performance -= num;
    }

    public void resetPerformnance() {
        this.performance = 100;
    }

    public void changeName(String new_name) {
        this.name = new_name;
    }

    public int getAverageSpeed() { //lay toc do trung binh lai xe cua tai xe co the dat dc dua theo so nam kinh nghie,
        if (this.experiences <= 0) {
            return 40;
        } else if (this.experiences <= 4) {
            return 50;
        } else if (this.experiences <= 10) {
            return 60;
        } else {
            return 70;
        }
    }

    public static int getProfit(Drivers.License license) { //lay tien luong chay xe 1h theo bang lai xe
        if (license.equals(Drivers.License.B2)) {
            return 10;
        } else if (license.equals(Drivers.License.C) || license.equals(Drivers.License.D)) {
            return 30;
        } else {
            return 40;
        }
    }
    public String get_all_suitable_type() {
         if (this.license.equals(Drivers.License.B2)) {
            return "car";
        } else if (this.license.equals(Drivers.License.C)) {
            return "car, coach";
        } else if (this.license.equals(Drivers.License.D)) {
            return "car, coach, truck";
        } else {
            return "car, coach, truck, container";
        }
    }
    public Vehicles.Type get_suitable_type() {
        if (this.license.equals(Drivers.License.B2)) {
            return Vehicles.Type.car;
        } else if (this.license.equals(Drivers.License.C)) {
            return Vehicles.Type.coach;
        } else if (this.license.equals(Drivers.License.D)) {
            return Vehicles.Type.truck;
        } else {
            return Vehicles.Type.container;
        }
    }
    public boolean is_on_leave () {
        return !this.date_start.equals("0000-00-00 00:00:00") && !this.date_end.equals("0000-00-00 00:00:00");
    }

    public void make_driver_in_trip() {
        this.status = Drivers.Status.in_trip;
    }

    public void make_driver_ready() {
        this.status = Drivers.Status.ready;
    }

    public boolean check_driver_in_trip() {
        return (this.status.equals(Drivers.Status.in_trip));
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
