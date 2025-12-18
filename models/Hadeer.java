package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Hadeer extends Fighter {
    private static final double MAX_HEALTH = 95.0;
    private static final double AGILITY = 20.0;

    private double agility;

    public Hadeer(double x, double y) {
        super("Hadeer", FighterType.HADEER, x, y, MAX_HEALTH, Color.rgb(255, 215, 0));
        this.agility = AGILITY;
    }

    @Override
    public String getSpecialAbility() {
        return "High Agility";
    }

    public double getAgility() {
        return agility;
    }
}