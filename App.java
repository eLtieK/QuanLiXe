
import java.io.IOException;
import java.util.Scanner;

/*
 * This Java source file was generated by the Gradle 'init' task.
 */


public class App {
   
    App() throws IOException {

    }
    
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) throws IOException, InterruptedException{
        System.out.println(new App().getGreeting());
        ManagementSystem myManager = new ManagementSystem();
        myManager.save_user_data(new Users("kiet", "kentom", "0946800349", "kennezversion@gmail.com"));
        myManager.save_user_data(new Users("cun", "cun123", "0123456789", "baoanh@gmai.com"));
        myManager.save_user_data(new Users("lebao", "baole321", "0908331349", "baolelb@gamil.com"));
        myManager.save_user_data(new Users("xuanhai", "hai1010", "0917220886", "haixuan@gamil.com"));
        
        Scanner scanner = new Scanner(System.in);
        
        while(!scanner.nextLine().equals("Quit")){}
        myManager.read_user_data();
        scanner.close();
    }
}
