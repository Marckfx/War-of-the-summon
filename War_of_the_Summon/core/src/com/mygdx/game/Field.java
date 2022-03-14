package com.mygdx.game;


import java.util.ArrayList;


public class Field {
    ArrayList<Fieldparts> fieldparts= new ArrayList<Fieldparts>();
    public void generatField(){
        fieldparts.add(new Fieldparts(0,0,0,0));
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                fieldparts.add(new Fieldparts(j*151,i*151,i,j));
            }
        }
    }

    public ArrayList<Fieldparts> getFieldparts() {
        return fieldparts;
    }
}
