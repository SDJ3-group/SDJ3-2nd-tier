package dk.via.Model;

import java.util.ArrayList;

public abstract class Package extends BaseModel {
    private int id;
    private ArrayList<Part> parts;
    private Boolean repacking;

    public Package(int id, ArrayList<Part> parts) {
        super(id);
        this.parts = parts;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getRepacking() {
        return repacking;
    }

    public void setRepacking(Boolean repacking) {
        this.repacking = repacking;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", parts=" + parts +
                '}';
    }
}
