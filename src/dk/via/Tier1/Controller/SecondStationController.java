package dk.via.Tier1.Controller;


import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier1.Model.ModelManager;
import dk.via.Tier1.View.View;
import dk.via.Tier2.Model.Car;
import dk.via.Tier2.Model.Part;

import java.rmi.RemoteException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class SecondStationController extends Controller {
    private ModelManager modelManager;

    public SecondStationController() {
        modelManager = ModelManager.getInstance();
    }

    public void dismantleTheCarpart(String vinNo, Part part) {
        //try{
        Car carToBeDismantled = /*ModelManager.getInstance().getCar(vinNo);*/ null;
        try {
            carToBeDismantled = RMIClient.getInstance().getService().getCar(vinNo);
            part.setCar(carToBeDismantled);
            RMIClient.getInstance().getService().updatePart(part);
            View.allert("the part " + part.toString() + " has been taken from the car " + carToBeDismantled);
        } catch (RemoteException e) {
            View.allert("there is no such a car in the warehouse");
            e.printStackTrace();
        }

            /*if (!(carToBeDismantled==null)){
                ModelManager.getInstance().dismantleTheCar(carToBeDismantled);
                View.allert(modelManager.getAllPalletes());
            } else View.allert("the car you wish to dismantle doesnt exist");
        }
        catch (NoSuchElementException e){
            View.allert(e.getMessage());
        }
        */
    }


    public Part makePart(String name, float weight, int id) {
        return null;
    }
    //getne si auto podla vinka
    //creatne part z auta a da ho na prislusnu paletu paletu

}
