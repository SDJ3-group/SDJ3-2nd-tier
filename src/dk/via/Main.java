package dk.via;


import dk.via.Controller.API.CarsAPIService;
import dk.via.Controller.RMIServer;

import java.rmi.RemoteException;

public class Main {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        System.setProperty("java.rmi.server.hostname", "127.0.0.1/RmiService");
        //  System.setSecurityManager(new RMISecurityManager());

	// write your code here
        System.out.println("Ahoj adam");

        try {
            RMIServer rmiServer = new RMIServer();
            rmiServer.StartRMI(1099);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        CarsAPIService carsAPI = new CarsAPIService();
        //    carsAPI.getAllCars();

        //   Car car = new Car(0, "Testovacie", "Fiesticka", 123.33);

//        carsAPI.addCar(car);
//        car.setWeight(333.33);
//        carsAPI.updateCar(car);
        //   carsAPI.getCar("Testovacie");
        //      carsAPI.deleteCar(car);

//        PartsAPIService partsAPI = new PartsAPIService();
//        partsAPI.getAllParts();
//
//
//        PalletsAPIService palletsAPI = new PalletsAPIService();
//        palletsAPI.getAllPallets();
//
//        PackagesAPIService packagesAPI = new PackagesAPIService();
//        packagesAPI.getAllPackages();
//
//
//

        /*

        try {
            RMIServer rmiServer = new RMIServer();
            rmiServer.StartRMI();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

*/


    }
}
