package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Rewan extends Fighter {
    private static final double MAX_HEALTH = 120.0;
    private static final double DEFENSE = 15.0;
    private static final double DAMAGE_REDUCTION_FACTOR = 0.1;
    private static final double MIN_DAMAGE = 1.0;

    private double defense;

    public Rewan(double x, double y) {
        super("Rewan", FighterType.REWAN, x, y, MAX_HEALTH, Color.rgb(255, 107, 107));
        this.defense = DEFENSE;
    }

    @Override
    public String getSpecialAbility() {
        return "High Defense";
    }

    @Override
    public void takeDamage(double damage) {
        double reducedDamage = Math.max(MIN_DAMAGE, damage - defense * DAMAGE_REDUCTION_FACTOR);
        super.takeDamage(reducedDamage);
    }

    public double getDefense() {
        return defense;
    }
}