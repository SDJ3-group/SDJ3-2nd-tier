package dk.via.Tier2.Controller;

import dk.via.Tier2.Controller.API.CarsAPIService;
import dk.via.Tier2.Controller.API.PackagesAPIService;
import dk.via.Tier2.Controller.API.PalletsAPIService;
import dk.via.Tier2.Controller.API.PartsAPIService;
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
        return carsAPI.getAllCars();
    }

    @Override
    public Car getCar(String VIN) {
        return carsAPI.getCar(VIN);
    }

    @Override
    public void updateCar(Car car) {
        carsAPI.updateCar(car);
    }

    @Override
    public void addCar(Car car) {
        carsAPI.addCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        carsAPI.deleteCar(car);
    }

    @Override
    public Package[] getAllPackages() {
        return packagesAPI.getAllPackages();
    }

    @Override
    public Package getPackage(int id) {
        return packagesAPI.getPackage(id);
    }

    @Override
    public void updatePackage(Package pack) {
        packagesAPI.updatePackage(pack);
    }

    @Override
    public void addPackage(Package pack) {
        packagesAPI.addPackage(pack);
    }

    @Override
    public void deletePackage(Package pack) {
        packagesAPI.deletePackage(pack);
    }

    @Override
    public Pallet[] getAllPallets() {
        return palletsAPI.getAllPallets();
    }

    @Override
    public Pallet getPallet(int id) {
        return palletsAPI.getPallet(id);
    }

    @Override
    public void updatePallet(Pallet pallet) {
        palletsAPI.updatePallet(pallet);
    }

    @Override
    public void addPallet(Pallet pallet) {
        palletsAPI.addPallet(pallet);
    }

    @Override
    public void deletePallet(Pallet pallet) {
        palletsAPI.deletePallet(pallet);
    }

    @Override
    public Part[] getAllParts() throws RemoteException {
        return partsAPI.getAllParts();
    }

    @Override
    public Part getPart(int id) throws RemoteException {
        return partsAPI.getPart(id);
    }

    @Override
    public void updatePart(String VIN, Part part) throws RemoteException {
        partsAPI.updatePart(VIN, part);
    }

    @Override
    public void addPart(String VIN, Part part) throws RemoteException {
        partsAPI.addPartToCar(VIN, part);
    }

    @Override
    public void deletePart(Part part) throws RemoteException {
        partsAPI.deletePart(part);
    }

    @Override
    public void assignPartsToPallet(Part[] parts, int palletId) throws RemoteException {
        partsAPI.putPartsOnPallet(parts, palletId);
    }

    @Override
    public Part[] getPartsForPallete(int palletId) throws RemoteException {
        return partsAPI.getPartsForPallet(palletId);
    }

    @Override
    public void putPartsInPackage(Part[] parts, int packageId) throws RemoteException {
        partsAPI.assignPartsToPackage(parts, packageId);
    }

    @Override
    public Part[] getPartsForCar(String VIN) throws RemoteException {
        return partsAPI.getPartsForCar(VIN);
    }

    @Override
    public Part[] getPartsForPackage(int packageId) throws RemoteException {
        return partsAPI.getPartsForPackage(packageId);
    }
}
