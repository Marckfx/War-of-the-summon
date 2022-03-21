package button;

import java.util.ArrayList;

public class Buildbuttons {

    ArrayList<Button> button1 = new ArrayList<>();
    ArrayList<Button> button2 = new ArrayList<>();

    public void Buildbutton() {

        button1.add(new Buttonbauer((13 * 151) + 25, (0 * 151), 0, 13));
        button2.add(new Buttonbauer((14 * 151) + 25, (0 * 151), 0, 14));

        button1.add(new Buttonarmbrustschuetze((13 * 151) + 25, (1 * 151), 1, 13));
        button2.add(new Buttonarmbrustschuetze((14 * 151) + 25, (1 * 151), 1, 14));

        button1.add(new Buttondrache((13 * 151) + 25, (2 * 151), 2, 13));
        button2.add(new Buttondrache((14 * 151) + 25, (2 * 151), 2, 14));

        button1.add(new Buttonkatapult((13 * 151) + 25, (3 * 151), 3, 13));
        button2.add(new Buttonkatapult((14 * 151) + 25, (3 * 151), 3, 14));

        button1.add(new Buttonoger((13 * 151) + 25, (4 * 151), 4, 13));
        button2.add(new Buttonoger((14 * 151) + 25, (4 * 151), 4, 14));

        button1.add(new Buttonpriester((13 * 151) + 25, (5 * 151), 5, 13));
        button2.add(new Buttonpriester((14 * 151) + 25, (5 * 151), 5, 14));

        button1.add(new Buttonreiter((13 * 151) + 25, (6 * 151), 6, 13));
        button2.add(new Buttonreiter((14 * 151) + 25, (6 * 151), 6, 14));

        button1.add(new Buttonschildwacht((13 * 151) + 25, (7 * 151), 7, 13));
        button2.add(new Buttonschildwacht((14 * 151) + 25, (7 * 151), 7, 14));

        button1.add(new Buttonturm((13 * 151) + 25, (8 * 151), 8, 13));
        button2.add(new Buttonturm((14 * 151) + 25, (8 * 151), 8, 14));

        button1.add(new Buttonuruk((13 * 151) + 25, (9 * 151), 9, 13));
        button2.add(new Buttonuruk((14 * 151) + 25, (9 * 151), 9, 14));

        button1.add(new Buttonviper((13 * 151) + 25, (10 * 151), 10, 13));
        button2.add(new Buttonviper((14 * 151) + 25, (10 * 151), 10, 14));

        button1.add(new Buttonwaechter((13 * 151) + 25, (11 * 151), 11, 13));
        button2.add(new Buttonwaechter((14 * 151) + 25, (11 * 151), 11, 14));
    }

    public ArrayList<Button> getButton1() {
        return button1;
    }

    public ArrayList<Button> getButton2() {
        return button2;
    }
}
