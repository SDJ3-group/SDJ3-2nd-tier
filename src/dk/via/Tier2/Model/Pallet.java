package dk.via.Tier2.Model;

import java.util.ArrayList;

public class Pallet extends BaseModel {

    private ArrayList<Part> Parts;
    private double MaximumCapacity;
    private int RegistrationNo;

    public Pallet(int id, ArrayList<Part> parts, double maximumCapacity, int registrationNo) {
        super(id);
        this.Parts = parts;
        this.MaximumCapacity = maximumCapacity;
        this.RegistrationNo = registrationNo;
    }

    public Pallet(int id, double maximumCapacity, int registrationNo) {
        super(id);
        this.MaximumCapacity = maximumCapacity;
        this.RegistrationNo = registrationNo;
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

    public double getMaximumCapacity() {
        return MaximumCapacity;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.MaximumCapacity = maximumCapacity;
    }

    public int getRegistrationNo() {
        return RegistrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.RegistrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "Parts=" + Parts +
                ", MaximumCapacity=" + MaximumCapacity +
                ", RegistrationNo=" + RegistrationNo +
                '}';
    }
}
