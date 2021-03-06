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
    private static RMIClient instance = null;

    private RMIClient() throws RemoteException {
        super();

    }

    public void startClient(String ipAddress, int port) {
        try {
            rmiInterface = (RMIInterface) Naming.lookup("rmi://" + ipAddress + ":" + port + "/RMIInterface");
            System.out.println("should be connected" + rmiInterface.toString());
        } catch (NotBoundException | RemoteException | MalformedURLException e) {
            e.printStackTrace();
            System.out.println("connection went wrong");
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
    public static RMIClient getInstance(){
        if (instance==null){
            try {
                instance = new RMIClient();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        System.out.println("tot mas instance "+instance);
        return instance;
    }
    public RMIInterface getRmiService(){
        return rmiInterface;
    }

}
