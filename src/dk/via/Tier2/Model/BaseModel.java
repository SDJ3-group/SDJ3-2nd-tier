package dk.via.Tier2.Model;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {

    private int Id;

    BaseModel(int id) {
        this.Id = id;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "id=" + Id +
                '}';
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }
}
