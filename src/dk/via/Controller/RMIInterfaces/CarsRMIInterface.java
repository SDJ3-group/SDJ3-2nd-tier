package dk.via.Controller.RMIInterfaces;

import dk.via.Model.Car;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CarsRMIInterface extends Remote {

    public Car[] getAllCars() throws RemoteException;

    public Car getCar(int id) throws RemoteException;

    public void updateCar(Car car) throws RemoteException;

    public void addCar(Car car) throws RemoteException;

    public void deleteCar(Car car) throws RemoteException;

}
