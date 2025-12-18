package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Mariem extends Fighter {
    private static final double MAX_HEALTH = 100.0;
    private static final double BALANCE = 10.0;

    private double balance;

    public Mariem(double x, double y) {
        super("Mariam", FighterType.MARIAM, x, y, MAX_HEALTH, Color.rgb(255, 182, 193));
        this.balance = BALANCE;
    }

    @Override
    public String getSpecialAbility() {
        return "Balanced Stats";
    }

    public double getBalance() {
        return balance;
    }
}