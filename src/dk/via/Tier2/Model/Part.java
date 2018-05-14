package dk.via.Tier2.Model;

import java.io.Serializable;

public class Part extends BaseModel implements Serializable {

    private String Name;
    private double Weight;
    private Car Car;
    private Pallet Pallet;
    private Package Package;


    public Part(int id, String name, double weight, Car car, Pallet pallet, Package pack) {
        super(id);
        Name = name;
        Weight = weight;
        Car = car;
        Pallet = pallet;
        Package = pack;
    }

    public Part(int id, String name, double weight, Car car) {
        super(id);
        this.Name = name;
        this.Weight = weight;
        this.Car = car;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        this.Weight = weight;
    }

    public Car getCar() {
        return Car;
    }

    public void setCar(Car car) {
        this.Car = car;
    }

    public Pallet getPallet() {
        return Pallet;
    }

    public void setPallet(Pallet pallet) {
        this.Pallet = pallet;
    }

    @Override
    public String toString() {
        return "Part{" +
                "Name='" + Name + '\'' +
                ", Weight=" + Weight +
                ", Car=" + Car +
                ", Pallet=" + Pallet +
                '}';
    }
}
