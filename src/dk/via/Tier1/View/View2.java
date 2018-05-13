package dk.via.Tier1.View;

import dk.via.Tier1.Controller.SecondStationController;
import dk.via.Tier2.Model.Part;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View2 extends View {
    private Scanner keyboard = new Scanner(System.in);
    private SecondStationController controller = new SecondStationController();

    public View2() {
        while (true) {
            System.out.println("if you want to stop type in exit else press enter");
            keyboard.nextLine();
            String flag = keyboard.nextLine();
            if (flag.equals("exit")) {
                break;
            } else {

                disAssembleCarPart();
            }
        }

    }

    private void disAssembleCarPart() {
        System.out.println("write in the license plate of the car you want to dismantle");
        String licensePlate = keyboard.nextLine();
        System.out.println("type in the parts name");
        String name = keyboard.nextLine();
        System.out.println("type in the parts weight");
        float weight = (float) keyboard.nextInt();
        System.out.println("type in the ID");
        int id = keyboard.nextInt();
        Part partToBeRippedFromCar = controller.makePart(name, weight, id);
        controller.dismantleTheCarpart(licensePlate, partToBeRippedFromCar);
    }
}
