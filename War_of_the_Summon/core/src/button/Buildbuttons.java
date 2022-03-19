package button;

import java.util.ArrayList;

public class Buildbuttons {

    ArrayList<Button> button1 = new ArrayList<>();
    ArrayList<Button> button2 = new ArrayList<>();

    public void Buildbutton() {

        button1.add(new Buttonbauer((13 * 151) + 25, (0 * 151), 0, 13));
        button2.add(new Buttonbauer((14 * 151) + 25, (0 * 151), 0, 13));

        button1.add(new Buttonarmbrustschuetze((13 * 151) + 25, (1 * 151), 1, 13));
        button2.add(new Buttonarmbrustschuetze((14 * 151) + 25, (1 * 151), 1, 13));



    }

    public ArrayList<Button> getButton1() {
        return button1;
    }

    public ArrayList<Button> getButton2() {
        return button2;
    }
}
