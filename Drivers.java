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
    private String experiences; //years of experiences (can be int)
    private Status status;

    Drivers(String name, String phone_number, String address, License license, String experiences) {
        this.name = name;
        this.phone_number = phone_number;
        this.address = address;
        this.license = license;
        this.experiences = experiences;
        this.status = Status.ready;
    }
}
