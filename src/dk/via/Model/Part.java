package dk.via.Model;

public class Part {

    private String name;
    private double weight;
    private Car car;
    private Category category;
    private int registrationNo;
    private Pallet pallet;


    public Part(String name, double weight, Car car, Category category, int registrationNo, Pallet pallet) {
        this.name = name;
        this.weight = weight;
        this.car = car;
        this.category = category;
        this.registrationNo = registrationNo;
        this.pallet = pallet;
    }

    public Part(String name, double weight, Car car, Category category, int registrationNo) {
        this.name = name;
        this.weight = weight;
        this.car = car;
        this.category = category;
        this.registrationNo = registrationNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getRegistrationNo() {
        return registrationNo;
    }

    public void setRegistrationNo(int registrationNo) {
        this.registrationNo = registrationNo;
    }

    public Pallet getPallet() {
        return pallet;
    }

    public void setPallet(Pallet pallet) {
        this.pallet = pallet;
    }

    @Override
    public String toString() {
        return "Part{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", car=" + car +
                ", category=" + category +
                ", registrationNo=" + registrationNo +
                ", pallet=" + pallet +
                '}';
    }
}
