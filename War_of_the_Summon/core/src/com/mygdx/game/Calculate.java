package com.mygdx.game;

import figures.Figures;

import java.util.ArrayList;

public class Calculate {
    int[] bewegen;

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
                int z = 0;
                for (int m = 0; m < 13; m++) {
                    if (i > 13 * m) {
                        z = m;
                    }
                }


                for (int m = 0; m <= figures.get(j).getMove(); m++) {
                    int start = (figures.get(j).getMove() * -1) + b;
                    int ende = figures.get(j).getMove() - b;
                    for (int n = start; n <= ende; n++) {

                        o = i - (13 * m) + n;

                        if (!(o == i) && o > -1 && o < 169) {
                            if (n < 0 && o >= 13 * (z - m) + 1) {
                                h[k] = o;
                                k++;
                            } else if (n > 0 && o <= 13 * (z + 1 - m)) {
                                h[k] = o;
                                k++;
                            } else if (n == 0) {
                                h[k] = o;
                                k++;
                            } else {
                                h[k] = -1;
                                k++;
                            }
                        }

                        o = i + (13 * m) + n;
                        if (!(o == i) && m > 0 && o > -1 && o < 169) {
                            if (n < 0 && o >= 13 * (z + m) + 1) {
                                h[k] = o;
                                k++;
                            } else if (n > 0 && o <= 13 * (z + 1 + m)) {
                                h[k] = o;
                                k++;
                            } else if (n == 0) {
                                h[k] = o;
                                k++;
                            } else {
                                h[k] = -1;
                                k++;
                            }
                        }
                    }
                    b++;
                }
                bewegen = h;
                return h;
            }
        }


        return null;

    }

    public int[] calculateattack(int x, int y, int i, ArrayList<Figures> figures) {
        int l = 0;
        int k = 0;

        for (int j = 0; j < figures.size(); j++) {
            for (int u = 1; u <= figures.get(j).getMove() + figures.get(j).getAttackrange(); u++) {
                l += 4 * u;
            }
            int[] h = new int[l];
            if (figures.get(j).getX() == x && figures.get(j).getY() == y) {
                int b = 0;
                int o = i;
                int z = 0;
                for (int m = 0; m < 13; m++) {
                    if (i > 13 * m) {
                        z = m;
                    }
                }


                for (int m = 0; m <= figures.get(j).getMove() + figures.get(j).getAttackrange(); m++) {
                    int start = ((figures.get(j).getMove() + figures.get(j).getAttackrange()) * -1) + b;
                    int ende = (figures.get(j).getMove() + figures.get(j).getAttackrange()) - b;
                    for (int n = start; n <= ende; n++) {

                        o = i - (13 * m) + n;

                        if (!(o == i) && o > -1 && o < 169) {
                            if (n < 0 && o >= 13 * (z - m) + 1) {
                                h[k] = o;
                                k++;
                            } else if (n > 0 && o <= 13 * (z + 1 - m)) {
                                h[k] = o;
                                k++;
                            } else if (n == 0) {
                                h[k] = o;
                                k++;
                            } else {
                                h[k] = -1;
                                k++;
                            }
                        }
                        o = i + (13 * m) + n;
                        if (!(o == i) && m > 0 && o > -1 && o < 169) {
                            if (n < 0 && o >= 13 * (z + m) + 1) {
                                h[k] = o;
                                k++;
                            } else if (n > 0 && o <= 13 * (z + 1 + m)) {
                                h[k] = o;
                                k++;
                            } else if (n == 0) {
                                h[k] = o;
                                k++;
                            } else {
                                h[k] = -1;
                                k++;
                            }
                        }
                    }
                    b++;
                }
                return h;
            }
        }


        return null;

    }
}
