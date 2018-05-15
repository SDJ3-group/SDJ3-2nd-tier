package dk.via.Tier1.Model;

import javax.naming.NoPermissionException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class ModelManager {
    private static ModelManager instance;
    private ArrayList<Pallet> palletes = new ArrayList<>();
    private ArrayList<Package> packages = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();

    private ModelManager() {
        instance = this;
    }

    public static ModelManager getInstance() {
        if (instance == null) {
            return new ModelManager();
        } else {
            return instance;
        }
    }

    public void registerNewCar(Car car) {
        cars.add(car);
    }

    public void dismantleTheCar(Car car) throws NoSuchElementException {
        ArrayList<Part> partsFromCar = car.getParts();
        for (int i = 0; i < partsFromCar.size(); i++) {
            Pallet palletToTakeInThePart = lookForPalletThatCanTakeThis(partsFromCar.get(i));
            if (palletToTakeInThePart != null) {
                //registracia partu na paletu
                palletToTakeInThePart.setCapacity(palletToTakeInThePart.getCapacity() - partsFromCar.get(i).getWeight());
                Part partToBeAdded = partsFromCar.get(i);
                //setneme mu aby si pamatal z akeho auta prisiel
                partToBeAdded.setCar(car);
                palletToTakeInThePart.getParts().add(partToBeAdded);
            } else {
                throw new NoSuchElementException("there is no pallet that can take the part " + partsFromCar.get(i).getId());
            }
        }
        cars.remove(car);

    }

    public Car getCar(String licensePlate) {

        for (int i = 0; i < cars.size(); i++) {

            if (cars.get(i).getVinNO().equals(licensePlate)) {
                return cars.get(i);
            }
        }
        return null;
    }

    private Pallet lookForPalletThatCanTakeThis(Part part) {
        for (int i = 0; i < palletes.size(); i++) {
            if (palletes.get(i).contains(part.getName()) && palletes.get(i).getCapacity() > part.getWeight()) {
                return palletes.get(i);
            }
        }
        Pallet newPalletWithSuchParts = new Pallet(generatePalletId());
        if (newPalletWithSuchParts.getCapacity() > part.getWeight()) {
            palletes.add(newPalletWithSuchParts);
            return newPalletWithSuchParts;
        } else {
            return null;
        }
    }

    private int generatePalletId() {
        int id = palletes.size() + 1;
        return id;
    }

    public void prepareASystemPackage(String model, int noOfObjects) {


    }

    public void makeAPackage(int noOfObjects, Part whatType) throws NoPermissionException {
        Package aPackage = new Package(generatePackageId());
        ArrayList<Part> allLegitObjects = getAllLegitObjectsFromPalletes(whatType);
        if (allLegitObjects != null) {
            if (!(allLegitObjects.size() < noOfObjects)) {
                for (int i = 0; i < noOfObjects; i++) {
                    transferPartFromPaletToPackage(allLegitObjects.get(i), aPackage, allLegitObjects.get(i).getPallet());
                }
            } else throw new NoPermissionException("There are not enough parts in the warehouse to form this package");
        }


    }

    private ArrayList<Part> getAllLegitObjectsFromPalletes(Part whatType) {
        ArrayList<Part> allTheParts = new ArrayList<>();
        for (int i = 0; i < palletes.size(); i++) {
            if (palletes.get(i).contains(whatType.getName())) {
                for (int j = 0; j < palletes.get(i).getParts().size(); j++) {
                    //setnut objektu paletu z ktorej prisiel aby sme ju potom vedeli dohladat v package
                    // a popripade vratit
                    palletes.get(i).getParts().get(j).setPallet(palletes.get(i));
                    allTheParts.add(palletes.get(i).getParts().get(j));

                }
            }
        }
        return allTheParts;
    }

    private void transferPartFromPaletToPackage(Part part, Package apackage, Pallet pallet) {
        pallet.getParts().remove(part);
        apackage.getParts().add(part);
    }

    private int generatePackageId() {
        int id = packages.size() + 1;
        return id;
    }

    public String getAllCars() {
        String out = "";
        for (int i = 0; i < cars.size(); i++) {
            out += cars.get(i) + "\n";
        }
        return out;
    }

    public String getAllPalletes() {
        String out = "";
        for (int i = 0; i < palletes.size(); i++) {
            out += palletes.get(i) + "\n";
        }
        return out;
    }

    public void populate() {
        ArrayList<Part> parts = new ArrayList<>();
        Part par1 = new Part(10, "steering", 1);
        Part par2 = new Part(30, "wheels", 2);
        Part par3 = new Part(4, "lightbulb", 3);
        parts.add(par1);
        parts.add(par2);
        parts.add(par3);
        Car car1 = new Car("tesla0", "agji", 150);
        car1.setParts(parts);
        Car car2 = new Car("tesla5", "aisj", 300);
        Car car3 = new Car("kkot", "srot", 450);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        for (int i = 0; i < cars.size(); i++) {
            System.out.println(cars.get(i).toString());
        }
    }
}
