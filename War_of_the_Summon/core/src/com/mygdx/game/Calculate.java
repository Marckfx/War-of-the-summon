package com.mygdx.game;

import figures.Figures;

public class Calculate {

    /**Berechnet die Felder auf denen man sich bewegen kann
     *
     * @param figur Gibt die Figur an die zu Prüfen ist
     * @param i Gibt die Position des zu prüfenden Feldes aus der Arraylist an
     * @param x Gibt den X wert des Klickes an
     * @param y Gibt den Y wert des Klickes an
     * @return Gibt die Felder zurück, auf denen sich bewegt werden kann
     */
    public int[] calculatmove(int x, int y, int i, Figures figur) {

        int l = 0;
        int k = 0;

            if (!(figur.isMoved())) {
                for (int u = 1; u <= figur.getMove(); u++) {
                    l += 4 * u;
                }
                int[] h = new int[l];
                if (figur.getX() == x && figur.getY() == y) {
                    int b = 0;
                    int o;
                    int z = 0;
                    for (int m = 0; m < 13; m++) {
                        if (i > 13 * m) {
                            z = m;
                        }
                    }
                    for (int m = 0; m <= figur.getMove(); m++) {
                        int start = (figur.getMove() * -1) + b;
                        int ende = figur.getMove() - b;
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

    /**
     *
     * @param figur Gibt die Figur an die zu Prüfen ist
     * @param i Gibt die Position des zu prüfenden Feldes aus der Arraylist an
     * @param x Gibt den X wert des Klickes an
     * @param y Gibt den Y wert des Klickes an
     * @return Gibt die Felder zurück auf denen angegriffen werden kann
     */
    public int[] calculateattack(int x, int y, int i, Figures figur) {



            if (!figur.isMoved() && !figur.isAttacked()) {
               return attackwithoutmove(figur, i, x, y);
            }
            if (figur.isMoved() && !figur.isAttacked()) {
                return attackwithmove(figur, i, x, y);
            }

        return null;

    }

    /**
     * Berechnet die Felder, auf denen man angreifen kann, ohne bewegung zu haben
     * @param figure Gibt die Figur an die zu Prüfen ist
     * @param i Gibt die Position des zu prüfenden Feldes aus der Arraylist an
     * @param x Gibt den X wert des Klickes an
     * @param y Gibt den Y wert des Klickes an
     * @return Gibt die Felder zurück auf denen angegriffen werden kann
     */
    public int[] attackwithoutmove(Figures figure, int i, int x, int y) {
        int l = 0;
        int k = 0;
        for (int u = 1; u <= figure.getMove() + figure.getAttackrange(); u++) {
            l += 4 * u;
        }
        int[] h = new int[l];
        if (figure.getX() == x && figure.getY() == y) {
            int b = 0;
            int o;
            int z = 0;
            for (int m = 0; m < 13; m++) {
                if (i > 13 * m) {
                    z = m;
                }
            }


            for (int m = 0; m <= figure.getMove() + figure.getAttackrange(); m++) {
                int start = ((figure.getMove() + figure.getAttackrange()) * -1) + b;
                int ende = (figure.getMove() + figure.getAttackrange()) - b;
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
        return null;
    }

    /**
     * Berechnet die Felder, auf denen man angreifen kann, wenn man noch bewegung hat
     * @param figure Gibt die Figur an die zu Prüfen ist
     * @param i Gibt die Position des zu prüfenden Feldes aus der Arraylist an
     * @param x Gibt den X wert des Klickes an
     * @param y Gibt den Y wert des Klickes an
     * @return Gibt die Felder zurück auf denen angegriffen werden kann
     */
    public int[] attackwithmove(Figures figure, int i, int x, int y) {
        int l = 0;
        int k = 0;
        for (int u = 1; u <= figure.getAttackrange(); u++) {
            l += 4 * u;
        }
        int[] h = new int[l];
        if (figure.getX() == x && figure.getY() == y) {
            int b = 0;
            int o ;
            int z = 0;
            for (int m = 0; m < 13; m++) {
                if (i > 13 * m) {
                    z = m;
                }
            }


            for (int m = 0; m <= figure.getAttackrange(); m++) {
                int start = ((figure.getAttackrange()) * -1) + b;
                int ende = (figure.getAttackrange()) - b;
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
        return null;
    }

}
