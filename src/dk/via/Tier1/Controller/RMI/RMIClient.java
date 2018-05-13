package dk.via.Tier1.Controller.RMI;


import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient extends UnicastRemoteObject {

    private static final long serialVersionUID = 1L;

    private static RMIClient instance = null;
    private static RMIInterface rmiInterface;

    private RMIClient() throws RemoteException {
    }

    public static RMIClient getInstance() {
        if (instance == null) {
            try {
                instance = new RMIClient();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public void startClient(String ipAddress, int port) {
        try {
            //System.setSecurityManager(new RMISecurityManager());
            rmiInterface = (RMIInterface) Naming.lookup("rmi://192.168.87.110:1099/RMIInterface");
            //rmiInterface.getAllCars();
            System.out.println("should be connected");
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public RMIInterface getService() {
        return null;
    }
}
