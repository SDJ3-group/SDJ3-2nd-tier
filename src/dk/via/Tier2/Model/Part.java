package dk.via.Tier2.Model;

import java.io.Serializable;

public class Part extends BaseModel implements Serializable {

    private String Name;
    private double Weight;
    private String CarId;
    private int PalletId;
    private int PreviousPalletId;
    private int PackageId;


    public Part(int id, String name, double weight, String carId) {
        super(id);
        Name = name;
        Weight = weight;
        CarId = carId;
        PalletId = 0;
        PackageId = 0;
        PreviousPalletId = 0;
    }

    public Part(int id, String name, double weight, String carId, int palletId, int previousPalletId, int packageId) {
        super(id);
        Name = name;
        Weight = weight;
        CarId = carId;
        PalletId = palletId;
        PreviousPalletId = previousPalletId;
        PackageId = packageId;
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

    public String getCarId() {
        return CarId;
    }

    public void setCarId(String carId) {
        CarId = carId;
    }

    public int getPalletId() {
        return PalletId;
    }

    public void setPalletId(int palletId) {
        PalletId = palletId;
    }

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public int getPreviousPalletId() {
        return PreviousPalletId;
    }

    public void setPreviousPalletId(int previousPalletId) {
        PreviousPalletId = previousPalletId;
    }

    @Override
    public String toString() {
        return "Part{" +
                "Name='" + Name + '\'' +
                ", Weight=" + Weight +
                ", CarId='" + CarId + '\'' +
                ", PalletId=" + PalletId +
                ", PreviousPalletId=" + PreviousPalletId +
                ", PackageId=" + PackageId +
                '}';
    }
}
