package dk.via.Model;

import java.util.ArrayList;

public class Car extends BaseModel {

    private String VIN;
    private String Model;
    private double Weight;
    private ArrayList<Part> Parts;


    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public Car(int id, String VIN, String model, double weight, ArrayList<Part> parts) {
        super(id);
        this.VIN = VIN;
        this.Model = model;
        this.Weight = weight;
        this.Parts = parts;
    }

    public Car(int id, String VIN, String model, double weight) {
        super(id);
        this.VIN = VIN;
        this.Model = model;
        this.Weight = weight;
        this.Parts = null;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        this.Model = model;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        this.Weight = weight;
    }

    public ArrayList<Part> getParts() {
        return Parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.Parts = parts;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VIN='" + VIN + '\'' +
                ", model='" + Model + '\'' +
                ", weight=" + Weight +
                ", parts=" + Parts +
                '}';
    }
}
