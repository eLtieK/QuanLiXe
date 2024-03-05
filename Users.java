/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Users {
    private String username;
    private String password;
    private String phone_number;
    private String email;
    
    public Users(String username, String password, String phone_number, String email) {
        this.username = username;
        this.password = password;
        this.phone_number = phone_number;
        this.email = email;
    }
    
    public String get_name() {
        return this.username;
    }
}
