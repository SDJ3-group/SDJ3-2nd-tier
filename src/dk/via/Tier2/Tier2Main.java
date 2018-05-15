package dk.via.Tier2;


import dk.via.Tier2.Controller.API.CarsAPIService;

public class Tier2Main {

    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        CarsAPIService carsAPIService = new CarsAPIService();
        carsAPIService.testAPI("VIN01");

        //      System.setProperty("java.rmi.server.hostname", "127.0.0.1/RmiService");
//
//        try {
//            RMIServer rmiServer = new RMIServer();
//            rmiServer.StartRMI(1099);
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
    }
}
