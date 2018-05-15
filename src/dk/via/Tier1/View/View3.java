package dk.via.Tier1.View;

import dk.via.Tier1.Controller.ThirdStationController;

import java.util.Scanner;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View3 extends View {
    private Scanner keyboard = new Scanner(System.in);
    private Scanner numberReader = new Scanner(System.in);
    private ThirdStationController controller = new ThirdStationController();



    public View3() {
        while (true) {
            System.out.println("if you want to stop type in exit else press enter");
            String flag = keyboard.nextLine();
            if (flag.equals("exit")) {
                super.DisplayMenu();
                break;
            } else {

                askForPackage();
            }
        }

    }

    private void askForPackage(){
        System.out.println("tell me, do you want to make a model package(press 1) \n" +
                "or system package(press 2)");
        if (numberReader.nextInt() == 1){
            oneTypePackage();
        } else if (numberReader.nextInt()==2){
            modelPackage();
        } else {
            System.out.println("Sir, you have to enter the correct number from the menu");
            askForPackage();
        }
    }


    private void oneTypePackage(){
        System.out.println("tell me what part do you want to put into the package");
        String whatType = keyboard.nextLine();
        System.out.println("tell me how many of those parts should the package contain");
        int noOfObjects = numberReader.nextInt();
        controller.makeAPackage(noOfObjects,whatType);
    }
    private void modelPackage(){
        System.out.println("tell me what model parts should the pallet contain");
        String whatType = keyboard.nextLine();
        System.out.println("tell me how many of those parts should the package contain");
        int noOfObjects = numberReader.nextInt();
        controller.prepareASystemPackage(noOfObjects,whatType);
    }
}
