package dk.via.Tier2.Controller.RMIInterfaces;

import dk.via.Tier2.Model.Part;

import java.rmi.RemoteException;

public interface PartsRMIInterface {

    Part[] getAllParts() throws RemoteException;

    Part getPart(int id) throws RemoteException;

    void updatePart(Part part) throws RemoteException;

    void addPart(Part part) throws RemoteException;

    void deletePart(Part part) throws RemoteException;

}
