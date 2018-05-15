package dk.via.Tier1.View;


import dk.via.Tier1.Controller.Controller;
import dk.via.Tier1.Controller.FirstStationController;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
class View1 extends View {
    private Scanner keyboard = new Scanner(System.in);
    private Scanner numberReader = new Scanner(System.in);
    private FirstStationController controller = new FirstStationController();

    View1() {

        while (true) {
            System.out.println("if you want to stop type in exit else press enter");
            String flag = keyboard.nextLine();
            if (flag.equals("exit")) {
                super.DisplayMenu();
                break;
            } else {

                registerCar();
            }
        }
    }

    private void registerCar() {
        System.out.println("write in the VinNo");
        String vinNo = keyboard.nextLine();
        System.out.println("write in the model");
        String model = keyboard.nextLine();
        System.out.println("write in the weight");
        float weight =  numberReader.nextFloat();
        controller.registerCar(vinNo, model, weight);
        System.out.println(controller.getAllCars());
    }
}
