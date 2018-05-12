package dk.via.Controller.RMIInterfaces;

import dk.via.Model.Part;

import java.rmi.RemoteException;

public interface PartsRMIInterface {

    Part[] getAllParts() throws RemoteException;

    Part getPart(int id) throws RemoteException;

    void updatePart(Part part) throws RemoteException;

    void addPart(Part part) throws RemoteException;

    void deletePart(Part part) throws RemoteException;

}
