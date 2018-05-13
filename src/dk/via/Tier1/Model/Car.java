package dk.via.Tier1.Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class Car {
    private String VinNO;
    private String Model;
    private ArrayList<Part> parts;
    private float weight;

    public Car(String vinNO, String model, float weight, ArrayList<Part> parts) {
        this.VinNO = vinNO;
        this.Model = model;
        this.weight = weight;
        this.parts = parts;
    }

    public Car(String vinNo, String model, float weight) {
        this.VinNO = vinNo;
        this.Model = model;
        this.weight = weight;
        this.parts = new ArrayList<>();
        this.parts.add(new Part(50, "steering", 1));
        this.parts.add(new Part(150, "carosery", 2));
        this.parts.add(new Part(65, "lights", 3));
        this.parts.add(new Part(350, "wheels", 4));
        this.parts.add(new Part(30, "metalic parts", 5));
    }

    public String getVinNO() {
        return VinNO;
    }

    public void setVinNO(String vinNO) {
        VinNO = vinNO;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    @Override
    public String toString() {
        return "Car{" +
                "VinNO='" + VinNO + '\'' +
                ", Model='" + Model + '\'' +
                ", weight=" + weight + '\'' +
                ", parts=" + Arrays.toString(parts.toArray()) +
                '}';
    }
}
