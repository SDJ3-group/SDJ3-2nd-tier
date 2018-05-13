package dk.via.Tier1.View;

/**
 * Created by Libcoo on 11.05.2018.
 */
public class View {
    private View view;

    public View() {
    }

    ;

    public static void allert(String message) {
        System.out.println(message);
    }

    public void DisplayMenu() {
        System.out.println("if you want to register Car press - 1");
        System.out.println("if you want to disassemble car into pallets press -2");
        System.out.println("if you want to make a packages out of pallets press -3");
    }

    public void setView(int number) {
        if (number == 1) {
            this.view = new View1();
        } else if (number == 2) {
            this.view = new View2();
        } else if (number == 3) {
            this.view = new View3();
        } else allert("you have to choose the correct menu operation");

    }
}
