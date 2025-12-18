package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Pistol extends Weapon {
    private static final String NAME = "Pistol";
    private static final double DAMAGE = 10.0;
    private static final double PROJECTILE_SPEED = 8.0;
    private static final long COOLDOWN = 400;
    private static final double SHAHD_MULTIPLIER = 1.2;

    public Pistol() {
        super(NAME, DAMAGE, PROJECTILE_SPEED, COOLDOWN, Color.GOLD);
    }

    @Override
    public Projectile createProjectile(double x, double y, double dirX, double dirY, Fighter fighter, int owner) {
        return new StraightProjectile(x, y, dirX * getProjectileSpeed(), dirY * getProjectileSpeed(), this, fighter, owner);
    }

    @Override
    protected double getDamageMultiplier(Fighter fighter) {
        return fighter.getType() == FighterType.SHAHD ? SHAHD_MULTIPLIER : 1.0;
    }
}