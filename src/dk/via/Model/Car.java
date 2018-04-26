package dk.via.Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Car {

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

    public Car(String VIN, String model, double weight, ArrayList<Part> parts) {
        this.VIN = VIN;
        this.model = model;
        this.weight = weight;
        this.parts = parts;
    }

    public Car(String VIN, String model, double weight) {
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
