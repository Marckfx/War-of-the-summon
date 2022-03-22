package button;

import java.util.ArrayList;

public class Buildbuttons {

    ArrayList<Button> button1 = new ArrayList<>();
    ArrayList<Button> button2 = new ArrayList<>();

    public void Buildbutton() {

        button1.add(new Buttonbauer((13 * 82) + 13, (0 * 82), 0, 13));
        button2.add(new Buttonbauer((14 * 82) + 13, (0 * 82), 0, 14));

        button1.add(new Buttonarmbrustschuetze((13 * 82) + 13, (1 * 82), 1, 13));
        button2.add(new Buttonarmbrustschuetze((14 * 82) + 13, (1 * 82), 1, 14));

        button1.add(new Buttondrache((13 * 82) + 13, (2 * 82), 2, 13));
        button2.add(new Buttondrache((14 * 82) + 13, (2 * 82), 2, 14));

        button1.add(new Buttonkatapult((13 * 82) + 13, (3 * 82), 3, 13));
        button2.add(new Buttonkatapult((14 * 82) + 13, (3 * 82), 3, 14));

        button1.add(new Buttonoger((13 * 82) + 13, (4 * 82), 4, 13));
        button2.add(new Buttonoger((14 * 82) + 13, (4 * 82), 4, 14));

        button1.add(new Buttonpriester((13 * 82) + 13, (5 * 82), 5, 13));
        button2.add(new Buttonpriester((14 * 82) + 13, (5 * 82), 5, 14));

        button1.add(new Buttonreiter((13 * 82) + 13, (6 * 82), 6, 13));
        button2.add(new Buttonreiter((14 * 82) + 13, (6 * 82), 6, 14));

        button1.add(new Buttonschildwacht((13 * 82) + 13, (7 * 82), 7, 13));
        button2.add(new Buttonschildwacht((14 * 82) + 13, (7 * 82), 7, 14));

        button1.add(new Buttonturm((13 * 82) + 13, (8 * 82), 8, 13));
        button2.add(new Buttonturm((14 * 82) + 13, (8 * 82), 8, 14));

        button1.add(new Buttonuruk((13 *82) + 13, (9 * 82), 9, 13));
        button2.add(new Buttonuruk((14 * 82) + 13, (9 * 82), 9, 14));

        button1.add(new Buttonviper((13 * 82) + 13, (10 * 82), 10, 13));
        button2.add(new Buttonviper((14 * 82) + 13, (10 * 82), 10, 14));

        button1.add(new Buttonwaechter((13 * 82) + 13, (11 * 82), 11, 13));
        button2.add(new Buttonwaechter((14 * 82) + 13, (11 * 82), 11, 14));
    }

    public ArrayList<Button> getButton1() {
        return button1;
    }

    public ArrayList<Button> getButton2() {
        return button2;
    }
}
