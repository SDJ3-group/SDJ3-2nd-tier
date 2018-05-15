package dk.via.Tier2.Controller.RMIInterfaces;

import dk.via.Tier2.Model.Part;

import java.rmi.RemoteException;

public interface PartsRMIInterface {

    Part[] getAllParts() throws RemoteException;

    Part getPart(int id) throws RemoteException;

    void updatePart(String VIN, Part part) throws RemoteException;

    void addPart(String VIN, Part part) throws RemoteException;

    void deletePart(Part part) throws RemoteException;

    void assignPartsToPallet(Part[] parts, int palletId) throws RemoteException;

    Part[] getPartsForPallete(int palletId) throws RemoteException;

    void putPartsInPackage(Part[] parts, int PackageId) throws RemoteException;

    Part[] getPartsForCar(String VIN) throws RemoteException;

    Part[] getPartsForPackage(int packageId) throws RemoteException;

}
