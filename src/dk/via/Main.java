package dk.via;


import dk.via.Controller.API.CarsAPIService;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Ahoj adam");

        CarsAPIService api = new CarsAPIService();

        api.getAllCars();

    }
}
