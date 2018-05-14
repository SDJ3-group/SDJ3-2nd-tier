package dk.via.Tier1.Controller.RMI;


import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;
import dk.via.Tier2.Model.Car;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient extends UnicastRemoteObject {

    private static final long serialVersionUID = 1L;

    private RMIInterface rmiInterface;

    public RMIClient() throws RemoteException {
        super();

    }



    public void startClient(String ipAddress, int port) {
        try {
            rmiInterface = (RMIInterface) Naming.lookup("rmi://" + ipAddress + ":" + port + "/RMIInterface");
            System.out.println("should be connected");
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }


    public Car[] getAllCars() {
        System.out.println("Zavolala sa funkcia");
        try {
            return rmiInterface.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

}
