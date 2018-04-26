package dk.via.Model;

import java.util.ArrayList;

public class Pallet {

    private ArrayList<Part> parts;
    private double maximumCapacity;
    private int registrationNo;

    public Pallet(ArrayList<Part> parts, double maximumCapacity, int registrationNo) {
        this.parts = parts;
        this.maximumCapacity = maximumCapacity;
        this.registrationNo = registrationNo;
    }

    public Pallet(double maximumCapacity, int registrationNo) {
        this.maximumCapacity = maximumCapacity;
        this.registrationNo = registrationNo;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    public void removePart(Part part) {
        parts.remove(part);
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public double getMaximumCapacity() {
        return maximumCapacity;
    }

    public void setMaximumCapacity(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "parts=" + parts +
                ", maximumCapacity=" + maximumCapacity +
                ", registrationNo=" + registrationNo +
                '}';
    }
}
