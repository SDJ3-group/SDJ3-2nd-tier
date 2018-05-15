package dk.via.Tier1.Controller;


import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier1.View.View;
import dk.via.Tier2.Model.Car;

import java.rmi.RemoteException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class FirstStationController extends Controller {
    private View view;

    public FirstStationController() {
    }

    public void registerCar(String vinNo, String model, float weight) {
        System.out.println("pred vytovrenim auta");
        Car incomingCar = new Car(-1, vinNo, model, weight);
        //modelManager.registerNewCar(incomingCar);
        System.out.println("po vytovrenie auta" + incomingCar.toString());
        try {
            System.out.println("pred rmi");
            RMIClient.getInstance().getRmiService().addCar(incomingCar);
            System.out.println("po rmi");
            View.allert("The car " + incomingCar.toString() + " has been added");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public String getAllCars() {
       try {
            return RMIClient.getInstance().getRmiService().getAllCars().toString();//modelManager.getAllCars();
        } catch (RemoteException e) {
           e.printStackTrace();
            return null;
        }
    }
}
