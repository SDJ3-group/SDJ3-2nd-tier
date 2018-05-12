package dk.via.Controller.RMIInterfaces;


import dk.via.Model.Package;

import java.rmi.RemoteException;

public interface PackagesRMIInterface {

    public Package[] getAllPackages() throws RemoteException;

    public Package getPackage(int id) throws RemoteException;

    public void updatePackage(Package pack) throws RemoteException;

    public void addPackage(Package pack) throws RemoteException;

    public void deletePackage(Package pack) throws RemoteException;
}
