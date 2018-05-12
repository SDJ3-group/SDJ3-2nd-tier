package dk.via.Controller;

import dk.via.Controller.API.CarsAPIService;
import dk.via.Controller.API.PackagesAPIService;
import dk.via.Controller.API.PalletsAPIService;
import dk.via.Controller.API.PartsAPIService;
import dk.via.Controller.RMI.CarsRMIService;
import dk.via.Controller.RMI.PackagesRMIService;
import dk.via.Controller.RMI.PalletsRMIService;
import dk.via.Controller.RMI.PartsRMIService;
import dk.via.Controller.RMIInterfaces.RMIInterface;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;
    private static String URL = "Fill me in";
    public CarsRMIService carsRMI;
    public PackagesRMIService packagesRMI;
    public PalletsRMIService palletsRMI;
    public PartsRMIService partsRMI;
    CarsAPIService carsAPI;
    PackagesAPIService packagesAPI;
    PalletsAPIService palletsAPI;
    PartsAPIService partsAPI;


    public RMIServer() throws RemoteException {
        super();
        carsAPI = new CarsAPIService();
        packagesAPI = new PackagesAPIService();
        palletsAPI = new PalletsAPIService();
        partsAPI = new PartsAPIService();

        carsRMI = new CarsRMIService(carsAPI);
        //   packagesRMI = new PackagesRMIService(packagesAPI);
        //  palletsRMI = new PalletsRMIService(palletsAPI);
        // partsRMI = new PartsRMIService(partsAPI);

    }


    public void StartRMI() {
        try {
            Naming.rebind(URL, new RMIServer());
            System.out.println("System ready");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
