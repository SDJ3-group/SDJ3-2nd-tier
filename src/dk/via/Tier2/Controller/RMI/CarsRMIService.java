package dk.via.Tier2.Controller.RMI;

import dk.via.Tier2.Controller.API.CarsAPIService;
import dk.via.Tier2.Controller.RMIInterfaces.CarsRMIInterface;
import dk.via.Tier2.Model.Car;

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
}
