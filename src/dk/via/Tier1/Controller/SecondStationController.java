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

    public SecondStationController() {
    }

    public void dismantleTheCarpart(String vinNo, Part part) {
        try {
            Car carToBeDismantled = RMIClient.getInstance().getRmiService().getCar(vinNo);
            try {
                part.setCarId(carToBeDismantled.getVIN());
                RMIClient.getInstance().getRmiService().addPart(part);
                View.allert("the part " + part.toString() + " has been taken from the car " + carToBeDismantled);
            } catch (RemoteException e) {
                View.allert("the connection failed");
                e.printStackTrace();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
            View.allert("the connection failed");
        }
        catch (NullPointerException e){
            e.printStackTrace();
            View.allert("the car with this vinNo is not in the house :_)");
        }
    }


    public Part makePart(String name, float weight) {
        return new Part(-1,name, weight);
    }
    //getne si auto podla vinka
    //creatne part z auta a da ho na prislusnu paletu paletu

}
