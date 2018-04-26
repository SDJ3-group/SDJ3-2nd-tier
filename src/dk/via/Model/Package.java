package dk.via.Model;

import java.util.ArrayList;

public abstract class Package {
    private ArrayList<Part> parts;

    public Package(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Package{" +
                "parts=" + parts +
                '}';
    }
}
