package dk.via.Model;

import java.util.ArrayList;

public class ModelPackage extends Package {

    private String model;

    public ModelPackage(int id, ArrayList<Part> parts, String model) {
        super(id, parts);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "ModelPackage{" +
                "model='" + model + '\'' +
                super.toString() +
                '}';
    }
}
