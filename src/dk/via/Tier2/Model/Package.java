package dk.via.Tier2.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Package extends BaseModel implements Serializable {
    private ArrayList<Part> Parts;
    private Boolean Repacking;

    public Package(int id, ArrayList<Part> parts, boolean repacking) {
        super(id);
        this.Parts = parts;
        this.Repacking = repacking;
    }

    public Package(int id, boolean repacking) {
        super(id);
        this.Repacking = repacking;
        this.Parts = new ArrayList<>();
    }

    public ArrayList<Part> getParts() {
        return Parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.Parts = parts;
    }

    public Boolean getRepacking() {
        return Repacking;
    }

    public void setRepacking(Boolean repacking) {
        this.Repacking = repacking;
    }

    @Override
    public String toString() {
        return "Package{" +
                ", Parts=" + Parts +
                '}';
    }
}
