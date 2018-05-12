package dk.via;


import dk.via.Controller.RMIServer;

import java.rmi.RemoteException;

public class Main {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ahoj adam");
        try {
            RMIServer rmiServer = new RMIServer();
            rmiServer.StartRMI();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
