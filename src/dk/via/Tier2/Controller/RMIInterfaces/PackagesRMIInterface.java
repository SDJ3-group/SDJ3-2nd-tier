package dk.via.Tier2.Controller.RMIInterfaces;


import dk.via.Tier2.Model.Package;

import java.rmi.RemoteException;

public interface PackagesRMIInterface {

    public Package[] getAllPackages() throws RemoteException;

    public Package getPackage(int id) throws RemoteException;

    public void updatePackage(Package pack) throws RemoteException;

    public void addPackage(Package pack) throws RemoteException;

    public void deletePackage(Package pack) throws RemoteException;

    public void makeModelPackage(int numberOfParts, String model) throws RemoteException;

    public void makeSystemPackage(int numberOfParts, String partType) throws RemoteException;
}
