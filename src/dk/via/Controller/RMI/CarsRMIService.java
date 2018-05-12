package dk.via.Controller.RMI;

import dk.via.Controller.API.CarsAPIService;
import dk.via.Controller.RMIInterfaces.CarsRMIInterface;
import dk.via.Model.Car;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CarsRMIService extends UnicastRemoteObject implements CarsRMIInterface {

    private static final long serialVersionUID = 1L;
    private CarsAPIService carsAPI;

    public CarsRMIService(CarsAPIService service) throws RemoteException {
        super();
        carsAPI = service;
    }

    @Override
    public Car[] getAllCars() throws RemoteException {
        return carsAPI.getAllCars();
    }

    @Override
    public Car getCar(int id) throws RemoteException {
        return carsAPI.getCar(id);
    }

    @Override
    public void updateCar(Car car) throws RemoteException {
        carsAPI.updateCar(car);
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        carsAPI.addCar(car);
    }

    @Override
    public void deleteCar(Car car) throws RemoteException {
        carsAPI.deleteCar(car);
    }
}
