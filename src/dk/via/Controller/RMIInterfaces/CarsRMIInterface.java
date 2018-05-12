package dk.via.Controller.RMIInterfaces;

import dk.via.Model.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarsRMIInterface extends Remote {

    Car[] getAllCars() throws RemoteException;

    Car getCar(String VIN) throws RemoteException;

    void updateCar(Car car) throws RemoteException;

    void addCar(Car car) throws RemoteException;

    void deleteCar(Car car) throws RemoteException;

}
