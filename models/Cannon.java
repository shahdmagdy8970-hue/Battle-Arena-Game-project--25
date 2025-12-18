package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Cannon extends Weapon {
    private static final String NAME = "Cannon";
    private static final double DAMAGE = 25.0;
    private static final double PROJECTILE_SPEED = 4.0;
    private static final long COOLDOWN = 1000;
    private static final double REWAN_MULTIPLIER = 1.3;

    public Cannon() {
        super(NAME, DAMAGE, PROJECTILE_SPEED, COOLDOWN, Color.RED);
    }

    @Override
    public Projectile createProjectile(double x, double y, double dirX, double dirY, Fighter fighter, int owner) {
        return new StraightProjectile(x, y, dirX * getProjectileSpeed(), dirY * getProjectileSpeed(), this, fighter, owner);
    }

    @Override
    protected double getDamageMultiplier(Fighter fighter) {
        return fighter.getType() == FighterType.REWAN ? REWAN_MULTIPLIER : 1.0;
    }
}