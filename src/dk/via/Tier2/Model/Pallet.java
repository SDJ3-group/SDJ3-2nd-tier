package dk.via.Tier2.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Pallet extends BaseModel implements Serializable {

    private ArrayList<Part> Parts;
    private double MaximumCapacity;

    public Pallet(int id, ArrayList<Part> parts, double maximumCapacity) {
        super(id);
        this.Parts = parts;
        this.MaximumCapacity = maximumCapacity;
    }

    public Pallet(int id, double maximumCapacity) {
        super(id);
        this.MaximumCapacity = maximumCapacity;
        this.Parts = new ArrayList<>();
    }

    public void addPart(Part part) {
        Parts.add(part);
    }

    public void removePart(Part part) {
        Parts.remove(part);
    }

    public ArrayList<Part> getParts() {
        return Parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.Parts = parts;
    }

    public void setParts(Part[] parts) {
        Parts.addAll(Arrays.asList(parts));
    }

    public double getMaximumCapacity() {
        return MaximumCapacity;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.MaximumCapacity = maximumCapacity;
    }

    public double currentCapacity() {
        double capacity = 0;

        for (Part part : Parts) {
            capacity += part.getWeight();
        }

        return capacity;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "Parts=" + Parts +
                ", MaximumCapacity=" + MaximumCapacity +
                '}';
    }
}
