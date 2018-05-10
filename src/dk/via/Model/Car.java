package dk.via.Model;

import java.util.ArrayList;

public class Car extends BaseModel {

    private String VIN;
    private String model;
    private double weight;
    private ArrayList<Part> parts;


    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public Car(int id, String VIN, String model, double weight, ArrayList<Part> parts) {
        super(id);
        this.VIN = VIN;
        this.model = model;
        this.weight = weight;
        this.parts = parts;
    }

    public Car(int id, String VIN, String model, double weight) {
        super(id);
        this.VIN = VIN;
        this.model = model;
        this.weight = weight;
        this.parts = null;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", model='" + model + '\'' +
                ", weight=" + weight +
                ", parts=" + parts +
                '}';
    }
}
