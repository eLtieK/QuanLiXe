package database;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Drivers {
    enum License{
        B2,C,D,E
    }
    public static Drivers.License fromStringLicense(String text) {
        for (License li : License.values()) {
            if (li.name().equalsIgnoreCase(text)) {
                return li;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in License enum");
    }
    
    enum Status{ //add some status for drivers
        ready,
        working,
        not_available 
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
    private int perfromance;
    private int id;

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
        this.perfromance = 100;
    }
    
    Drivers(Drivers driver) {
        this.name = driver.getName();
        this.phone_number = driver.getPhonenumber();
        this.address = driver.getAddress();
        this.license = driver.getLicense();
        this.experiences = driver.getExperiences();
        this.status = driver.getStatus();
        this.id = driver.getId();
        this.perfromance = driver.getPerformance();
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
        return this.perfromance;
    }
    
    public void reducePerformance(int num) {
        this.perfromance -= num;
    }
    public void resetPerformnance() {
        this.perfromance = 100;
    }
    public void changeName(String new_name) {
        this.name = new_name;
    }
    
    public int getAverageSpeed() { //lay toc do trung binh lai xe cua tai xe co the dat dc dua theo so nam kinh nghie,
        if(this.experiences <= 0) {
            return 40;
        } else if(this.experiences <= 4) {
            return 50;
        } else if(this.experiences <= 10){
            return 60;
        } else {
            return 70;
        }
    }
     
    public static int getProfit(Drivers.License license) { //lay tien luong chay xe 1h theo bang lai xe
        if(license.equals(Drivers.License.B2)) {
            return 10;
        } else if(license.equals(Drivers.License.C) || license.equals(Drivers.License.D) ) {
            return 30;
        } else {
            return 40;
        }
    }
    
    public Vehicles.Type get_suitable_type() {
        if(this.license.equals(Drivers.License.B2)) {
            return Vehicles.Type.car;
        }
        else if(this.license.equals(Drivers.License.C)) {
            return Vehicles.Type.coach;
        }
        else if(this.license.equals(Drivers.License.D)) {
            return Vehicles.Type.truck;
        }
        else {
            return Vehicles.Type.container;
        }
    }
}
