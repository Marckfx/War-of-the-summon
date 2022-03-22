package com.mygdx.game;


import java.util.ArrayList;


public class Field {
    ArrayList<Fieldparts> fieldparts= new ArrayList<>();
    public void generatField(){
        fieldparts.add(new Fieldparts(0,0,0,0));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                fieldparts.add(new Fieldparts(j*82,i*82,i,j));
            }
        }
    }

    public ArrayList<Fieldparts> getFieldparts() {
        return fieldparts;
    }
}
