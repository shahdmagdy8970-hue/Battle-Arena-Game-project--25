package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class Bow extends Weapon {
    private static final String NAME = "Bow";
    private static final double DAMAGE = 15.0;
    private static final double PROJECTILE_SPEED = 10.0;
    private static final long COOLDOWN = 500;
    private static final double SHAHD_MULTIPLIER = 1.3;

    public Bow() {
        super(NAME, DAMAGE, PROJECTILE_SPEED, COOLDOWN, Color.rgb(78, 205, 196));
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
