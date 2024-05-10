


import database.Manager;
import java.io.IOException;
import menu.Login;

/**
 *
 * @author User
 */
public class Loginandsingup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Manager manager = Manager.getInstance();
         Login LoginFrame = new Login();
         LoginFrame.setVisible(true);
         LoginFrame.pack();
         LoginFrame.setLocationRelativeTo(null);
         
    }
    
}
