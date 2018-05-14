package dk.via.Tier2.Controller;

import dk.via.Tier2.Controller.API.CarsAPIService;
import dk.via.Tier2.Controller.API.PackagesAPIService;
import dk.via.Tier2.Controller.API.PalletsAPIService;
import dk.via.Tier2.Controller.API.PartsAPIService;
import dk.via.Tier2.Controller.RMI.CarsRMIService;
import dk.via.Tier2.Controller.RMI.PackagesRMIService;
import dk.via.Tier2.Controller.RMI.PalletsRMIService;
import dk.via.Tier2.Controller.RMI.PartsRMIService;
import dk.via.Tier2.Controller.RMIInterfaces.RMIInterface;
import dk.via.Tier2.Model.Car;
import dk.via.Tier2.Model.Package;
import dk.via.Tier2.Model.Pallet;
import dk.via.Tier2.Model.Part;

import java.net.InetAddress;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;

    public CarsRMIService carsRMI;
    public PackagesRMIService packagesRMI;
    public PalletsRMIService palletsRMI;
    public PartsRMIService partsRMI;
    private CarsAPIService carsAPI;
    private PackagesAPIService packagesAPI;
    private PalletsAPIService palletsAPI;
    private PartsAPIService partsAPI;


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


    public void StartRMI(int serverPort) {
        try {
            System.setProperty("java.rmi.server.hostname", InetAddress.getLocalHost().getHostAddress());
            System.out.println("System: " + System.getProperty("java.rmi.server.hostname"));
            Registry reg = LocateRegistry.createRegistry(serverPort);
            reg.bind("RMIInterface", new RMIServer());

            System.out.println("Server started" + reg.toString());
        } catch (Exception e) {
            System.out.println("We were unable to start server");
            e.printStackTrace();
        }
    }

    @Override
    public Car[] getAllCars() {
        System.out.println("zavolala sa funkcia na servery");
        return carsAPI.getAllCars();
    }

    @Override
    public Car getCar(String VIN) {
        return null;
    }

    @Override
    public void updateCar(Car car) {

    }

    @Override
    public void addCar(Car car) {

    }

    @Override
    public void deleteCar(Car car) {

    }

    @Override
    public Package[] getAllPackages() {
        return new Package[0];
    }

    @Override
    public Package getPackage(int id) {
        return null;
    }

    @Override
    public void updatePackage(Package pack) {
    }

    @Override
    public void addPackage(Package pack) {

    }

    @Override
    public void deletePackage(Package pack) {

    }

    @Override
    public Pallet[] getAllPallets() {
        return new Pallet[0];
    }

    @Override
    public Pallet getPallet(int id) {
        return null;
    }

    @Override
    public void updatePallet(Pallet pallet) {

    }

    @Override
    public void addPallet(Pallet pallet) {

    }

    @Override
    public void deletePallet(Pallet pallet) {

    }

    @Override
    public Part[] getAllParts() {
        return new Part[0];
    }

    @Override
    public Part getPart(int id) {
        return null;
    }

    @Override
    public void updatePart(Part part) {

    }

    @Override
    public void addPart(Part part) {

    }

    @Override
    public void deletePart(Part part) {

    }
}
