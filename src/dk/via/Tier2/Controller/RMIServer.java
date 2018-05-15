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
    public void makeModelPackage(int numberOfParts, String model) {
        packagesAPI.makeModelPackage(numberOfParts, model);
    }

    @Override
    public void makeSystemPackage(int numberOfParts, String partType) {
        packagesAPI.makeSystemPackage(numberOfParts, partType);
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
    public Part[] getAllParts() {
        return partsAPI.getAllParts();
    }

    @Override
    public Part getPart(int id) {
        return partsAPI.getPart(id);
    }

    @Override
    public void updatePart(String VIN, Part part) {
        partsAPI.updatePart(part);
    }

    @Override
    public void addPart(Part part) {
        partsAPI.addPart(part);
    }

    @Override
    public void deletePart(Part part) {
        partsAPI.deletePart(part);
    }

    @Override
    public void assignPartsToPallet(Part[] parts, int palletId) {
        partsAPI.putPartsOnPallet(parts, palletId);
    }

    @Override
    public Part[] getPartsForPallete(int palletId) {
        return partsAPI.getPartsForPallet(palletId);
    }

    @Override
    public void putPartsInPackage(Part[] parts, int packageId) {
        partsAPI.assignPartsToPackage(parts, packageId);
    }

    @Override
    public Part[] getPartsForCar(String VIN) {
        return partsAPI.getPartsForCar(VIN);
    }

    @Override
    public Part[] getPartsForPackage(int packageId) {
        return partsAPI.getPartsForPackage(packageId);
    }
}
