package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Alaa extends Fighter {
    private static final double MAX_HEALTH = 85.0;
    private static final double MAGIC_POWER = 15.0;

    private double magicPower;

    public Alaa(double x, double y) {
        super("Alaa", FighterType.ALAA, x, y, MAX_HEALTH, Color.MEDIUMPURPLE);
        this.magicPower = MAGIC_POWER;
    }

    @Override
    public String getSpecialAbility() {
        return "Magic Boost";
    }

    public double getMagicPower() {
        return magicPower;
    }
}
