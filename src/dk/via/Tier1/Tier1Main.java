package dk.via.Tier1;

import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier1.View.View;
import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;
import dk.via.Tier2.Model.Car;

import java.rmi.RemoteException;
import java.util.Scanner;

public class Tier1Main {

    private static final long serialVersionUID = 1L;

    private static RMIInterface rmiInterface;

    public static void main(String[] args) throws RemoteException {

        // rmiInterface = (RMIInterface) Naming.lookup("rmi://192.168.87.110:1099/RMIInterface");

        View view = new View();
        view.DisplayMenu();

        /*Car[] cars = rmiClient.getAllCars();
        for (Car car : cars) {
            System.out.println(car.toString());
        }*/

    }
}

