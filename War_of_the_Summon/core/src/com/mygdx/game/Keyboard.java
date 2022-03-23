package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Keyboard {
    String x = "";

    public void setX(String x) {
        this.x = x;
    }

    public String buttonpress() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.BACKSPACE) && x.length() > 0) {
            x = x.substring(0, x.length() - 1);
        } else {
            x += alfabet();
        }
        return x;
    }

    public String alfabet() {
        if (Gdx.input.isKeyJustPressed(Input.Keys.A) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "A";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            return "a";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.B) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "B";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.B)) {
            return "b";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.C) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "C";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.C)) {
            return "c";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "D";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            return "d";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.E) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "E";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            return "e";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.F) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "F";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.F)) {
            return "f";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.G) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "G";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.G)) {
            return "g";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.H) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "H";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.H)) {
            return "h";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.I) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "I";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.I)) {
            return "i";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.J) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "J";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.J)) {
            return "j";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.K) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "K";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.K)) {
            return "k";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.L) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "L";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.L)) {
            return "l";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.M) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "M";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.M)) {
            return "m";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.N) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "N";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.N)) {
            return "n";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.O) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "O";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.O)) {
            return "o";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.P) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "P";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.P)) {
            return "p";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Q) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "Q";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            return "q";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.R) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "R";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.R)) {
            return "r";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "S";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            return "s";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.T) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "T";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.T)) {
            return "t";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.U) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "U";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.U)) {
            return "u";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.V) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "V";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.V)) {
            return "v";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "W";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            return "w";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.X) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "X";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.X)) {
            return "x";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Z) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "Y";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
            return "y";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.Y) && (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT))) {
            return "Z";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1)) {
            return "1";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_2)) {
            return "2";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_3)) {
            return "3";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_4)) {
            return "4";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_5)) {
            return "5";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_6)) {
            return "6";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_7)) {
            return "7";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_8)) {
            return "8";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_9)) {
            return "9";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_0)) {
            return "0";
        } else if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            return " ";
        }
        return "";
    }
}
