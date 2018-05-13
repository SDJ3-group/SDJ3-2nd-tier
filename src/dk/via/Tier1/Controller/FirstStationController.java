package dk.via.Tier1.Controller;


import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier1.Model.Car;
import dk.via.Tier1.Model.ModelManager;
import dk.via.Tier1.View.View;

import java.rmi.RemoteException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class FirstStationController extends Controller {
    private View view;
    private ModelManager modelManager;

    public FirstStationController() {
        modelManager = ModelManager.getInstance();
    }

    public void registerCar(String licensePlate, String model, float weight) {
        Car incomingCar = new Car(licensePlate, model, weight);
        //modelManager.registerNewCar(incomingCar);
        try {
            RMIClient.getInstance().getRmiInterface().addCar(null);
            View.allert("The car " + incomingCar.toString() + " has been added");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getAllCars() {
        try {
            return RMIClient.getInstance().getRmiInterface().getAllCars().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }
}
