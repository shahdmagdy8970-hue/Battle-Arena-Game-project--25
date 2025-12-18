package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Shahd extends Fighter {
    private static final double MAX_HEALTH = 95.0;
    private static final double PRECISION = 18.0;

    private double precision;

    public Shahd(double x, double y) {
        super("Shahd", FighterType.SHAHD, x, y, MAX_HEALTH, Color.rgb(78, 205, 196));
        this.precision = PRECISION;
    }

    @Override
    public String getSpecialAbility() {
        return "Bow Mastery";
    }

    public double getPrecision() {
        return precision;
    }
}