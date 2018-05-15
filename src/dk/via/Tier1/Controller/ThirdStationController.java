package dk.via.Tier1.Controller;


import dk.via.Tier1.Controller.RMI.RMIClient;
import dk.via.Tier1.Model.ModelManager;
import dk.via.Tier1.Model.Part;
import dk.via.Tier1.View.View;
import dk.via.Tier1.View.View3;

import javax.naming.NoPermissionException;
import java.rmi.RemoteException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class ThirdStationController extends Controller {

    public ThirdStationController() {
    }

    public void makeAPackage(int noOfObjects, String whatType) {
        try {
            RMIClient.getInstance().getRmiService().makeModelPackage(noOfObjects,whatType);
        } catch (RemoteException e) {
            e.printStackTrace();
            View.allert("connection went wrong");
        }
    }
    //takze nie ze sa ma zrobic samo, ale chceme interactovat s guickom
    // party sa sami nepriradia do packagu ale pride user a zaregistruje part ktoremu sa priradi package


    public void prepareASystemPackage( int noOfObjects, String model) {
        try {
            RMIClient.getInstance().getRmiService().makeSystemPackage(noOfObjects, model);
        } catch (RemoteException e) {
            e.printStackTrace();
            View.allert("connection went wrong");
        }
    }


}
