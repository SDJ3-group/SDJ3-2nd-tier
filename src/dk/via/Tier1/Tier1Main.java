package dk.via.Tier1;

import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Tier1Main {

    private static final long serialVersionUID = 1L;

    private static RMIInterface rmiInterface;

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        // rmiInterface = (RMIInterface) Naming.lookup("rmi://192.168.87.110:1099/RMIInterface");

        RMIClient.getInstance().startClient("192.168.87.110", 1099);

//        ClientRmi.getInstance().startClient("aaa", 1099);

//        ClientRmi clientRmi = ClientRmi.getInstance();
//        clientRmi.startClient("//localhost/", 1099);
        /*
        ModelManager.getInstance().populate();
        View view = new View();
        Scanner keyboard = new Scanner(System.in);
        view.DisplayMenu();
        view.setView(keyboard.nextInt());

        */
    }
}
