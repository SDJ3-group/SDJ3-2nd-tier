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
import dk.via.Model.Car;
import dk.via.Model.Package;
import dk.via.Model.Pallet;
import dk.via.Model.Part;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer extends UnicastRemoteObject implements RMIInterface {

    private static final long serialVersionUID = 1L;
    private static String URL = "http://localhost:50387/api/";
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

    @Override
    public Car[] getAllCars() {
        return new Car[0];
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
    public Pallet[] getAllPallets() throws RemoteException {
        return new Pallet[0];
    }

    @Override
    public Pallet getPallet(int id) throws RemoteException {
        return null;
    }

    @Override
    public void updatePallet(Pallet pallet) throws RemoteException {

    }

    @Override
    public void addPallet(Pallet pallet) throws RemoteException {

    }

    @Override
    public void deletePallet(Pallet pallet) throws RemoteException {

    }

    @Override
    public Part[] getAllParts() throws RemoteException {
        return new Part[0];
    }

    @Override
    public Part getPart(int id) throws RemoteException {
        return null;
    }

    @Override
    public void updatePart(Part part) throws RemoteException {

    }

    @Override
    public void addPart(Part part) throws RemoteException {

    }

    @Override
    public void deletePart(Part part) throws RemoteException {

    }
}
