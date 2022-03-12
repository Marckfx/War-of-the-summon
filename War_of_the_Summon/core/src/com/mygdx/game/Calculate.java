package com.mygdx.game;

import figures.Figures;

import java.util.ArrayList;

public class Calculate {
    public int[] calculatmove(int x, int y, int i, ArrayList<Figures> figures) {
        int l = 0;
        int k = 0;

        for (int j = 0; j < figures.size(); j++) {

            for (int u = 1; u <= figures.get(j).getMove(); u++) {
                l += 4 * u;
            }

            int[] h = new int[l];
            if (figures.get(j).getX() == x && figures.get(j).getY() == y) {
                int b = 0;
                int o = i;

                for (int m = 0; m <= figures.get(j).getMove(); m++) {
                    for (int n = 0; n < (figures.get(j).getMove() * 2) + 1 - (b * 2); n++) {

                        o = i - (13 * m) - (figures.get(j).getMove() - b) + n;
                        if (!(o == i)&&o>0) {
                            h[k] = o;
                            k++;
                            System.out.println(o);
                        }else{
                            h[k] = -1;
                        }

                        o = i + (13 * m) - (figures.get(j).getMove() - b) + n;
                        if (!(o == i) && m > 0&&o>0) {
                            h[k] = o;
                            k++;
                        }else{
                            h[k] = -1;
                        }
                    }
                    b++;
                }
                for (int m = 0; m < h.length; m++) {
                    System.out.println(h[m]);
                }

                return h;
            }
        }


        return null;

    }
}
