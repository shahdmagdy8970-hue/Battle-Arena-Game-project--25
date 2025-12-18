package com.example.battlearena.models;
import javafx.scene.paint.Color;

public class MagicStaff extends Weapon {
    private static final String NAME = "Magic Staff";
    private static final double DAMAGE = 20.0;
    private static final double PROJECTILE_SPEED = 6.0;
    private static final long COOLDOWN = 800;
    private static final double MAGIC_USER_MULTIPLIER = 1.25;

    public MagicStaff() {
        super(NAME, DAMAGE, PROJECTILE_SPEED, COOLDOWN, Color.MEDIUMPURPLE);
    }

    @Override
    public Projectile createProjectile(double x, double y, double dirX, double dirY, Fighter fighter, int owner) {
        return new StraightProjectile(x, y, dirX * getProjectileSpeed(), dirY * getProjectileSpeed(), this, fighter, owner);
    }

    @Override
    protected double getDamageMultiplier(Fighter fighter) {
        FighterType type = fighter.getType();
        return (type == FighterType.SALMA || type == FighterType.ALAA) ? MAGIC_USER_MULTIPLIER : 1.0;
    }
}