package dk.via.Tier1.Model;

import java.util.ArrayList;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class Package {
    private int ID;
    private boolean repacking;
    private ArrayList<Part> parts;

    public Package(int ID) {
        this.ID = ID;
        this.parts = new ArrayList<>();
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {

        this.ID = ID;
    }

    public boolean isRepacking() {
        return repacking;
    }

    public void setRepacking(boolean repacking) {
        this.repacking = repacking;
    }

    public ArrayList<Part> getParts() {

        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }
}
