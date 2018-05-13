package dk.via.Tier2.Model;

public abstract class BaseModel {

    int Id;

    public BaseModel(int id) {
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
