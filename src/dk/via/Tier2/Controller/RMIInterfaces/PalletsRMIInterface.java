package dk.via.Tier2.Controller.RMIInterfaces;

import dk.via.Tier2.Model.Pallet;

import java.rmi.RemoteException;

public interface PalletsRMIInterface {

    Pallet[] getAllPallets() throws RemoteException;

    Pallet getPallet(int id) throws RemoteException;

    void updatePallet(Pallet pallet) throws RemoteException;

    void addPallet(Pallet pallet) throws RemoteException;

    void deletePallet(Pallet pallet) throws RemoteException;

}
