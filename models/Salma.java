package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Salma extends Fighter {
    private static final double MAX_HEALTH = 90.0;
    private static final double SPELL_POWER = 12.0;

    private double spellPower;

    public Salma(double x, double y) {
        super("Salma", FighterType.SALMA, x, y, MAX_HEALTH, Color.rgb(138, 43, 226));
        this.spellPower = SPELL_POWER;
    }

    @Override
    public String getSpecialAbility() {
        return "Spell Mastery";
    }

    public double getSpellPower() {
        return spellPower;
    }
}