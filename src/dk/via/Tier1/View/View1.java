package dk.via.Tier1.View;


import dk.via.Tier1.Controller.FirstStationController;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
class View1 extends View {
    private Scanner keyboard = new Scanner(System.in);
    private FirstStationController controller = new FirstStationController();

    View1() {

        while (true) {
            System.out.println("if you want to stop type in exit else press enter");
            keyboard.nextLine();
            String flag = keyboard.nextLine();
            if (flag.equals("exit")) {
                break;
            } else {

                registerCar();
            }
        }
    }

    private void registerCar() {
        System.out.println("write in the license plate");
        String licensePlate = keyboard.nextLine();
        System.out.println("write in the model");
        String model = keyboard.nextLine();
        System.out.println("write in the weight");
        float weight = (float) keyboard.nextInt();
        //    controller.registerCar(licensePlate, model, weight);
        //System.out.println(Controller.getAllCars());
    }
}
