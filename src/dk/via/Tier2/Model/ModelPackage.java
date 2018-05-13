package dk.via.Tier2.Model;

import java.util.ArrayList;

public class ModelPackage extends Package {

    private String model;

    public ModelPackage(int id, ArrayList<Part> parts, boolean repacking) {
        super(id, parts, repacking);
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
