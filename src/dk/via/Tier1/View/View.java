package dk.via.Tier1.View;

import dk.via.Tier1.Controller.RMI.RMIClient;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View {
    private View view;
    private Scanner keyboard;
    public View() {
        keyboard = new Scanner(System.in);
    }

    ;

    public static void allert(String message) {
        System.out.println(message);
    }

    public void DisplayMenu() {
        System.out.println("Please enter IP adress");
        String ipAdress= keyboard.nextLine();
        RMIClient.getInstance().startClient(ipAdress, 1099);
        System.out.println("if you want to register Car press - 1");
        System.out.println("if you want to disassemble car into pallets press -2");
        System.out.println("if you want to make a packages out of pallets press -3");
        setView(keyboard.nextInt());
    }

    public void setView(int number) {
        if (number == 1) {
            this.view = new View1();
        } else if (number == 2) {
            this.view = new View2();
        } else if (number == 3) {
            this.view = new View3();
        } else {
            allert("you have to choose the correct menu operation");
            DisplayMenu();
        }

    }
}
