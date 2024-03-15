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
        B1,B2,C,D,E,F
    }
    enum Status{ //add some status for drivers
        ready,
        working,
        not_available 
    }
    private String name;
    private String phone_number;
    private String address;
    private License license;
    private int experiences; //years of experiences (can be int)
    private Status status;
    private int id;

    Drivers(String name, String phone_number, String address, License license, int experiences, int id) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.license = license;
        this.experiences = experiences;
        this.status = Status.ready;
        this.id = id;
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
    
     public void changeName(String new_name) {
        this.name = new_name;
    }
}
