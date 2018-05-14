package dk.via.Tier1;

import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;
import dk.via.Tier2.Model.Car;

import java.rmi.RemoteException;

public class Tier1Main {

    private static final long serialVersionUID = 1L;

    private static RMIInterface rmiInterface;

    public static void main(String[] args) throws RemoteException {

        // rmiInterface = (RMIInterface) Naming.lookup("rmi://192.168.87.110:1099/RMIInterface");

        RMIClient rmiClient = new RMIClient();
        rmiClient.startClient("172.16.220.129", 1099);
        Car[] cars = rmiClient.getAllCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }

        /*
        ModelManager.getInstance().populate();
        View view = new View();
        Scanner keyboard = new Scanner(System.in);
        view.DisplayMenu();
        view.setView(keyboard.nextInt());
        */
    }
}
