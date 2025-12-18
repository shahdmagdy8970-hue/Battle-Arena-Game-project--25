package com.example.battlearena.models;

import javafx.scene.paint.Color;

public abstract class Weapon {
    private String name;
    private double damage;
    private double projectileSpeed;
    private long cooldown;
    private long lastShotTime;
    private Color color;

    public Weapon(String name, double damage, double projectileSpeed, long cooldown, Color color) {
        this.name = name;
        this.damage = damage;
        this.projectileSpeed = projectileSpeed;
        this.cooldown = cooldown;
        this.lastShotTime = 0;
        this.color = color;
    }

    public boolean isWeaponOperable() {
        long current = System.currentTimeMillis();
        return (current - lastShotTime) >= cooldown;
    }

    public Projectile fire(double x, double y, double dirX, double dirY, Fighter fighter, int owner) {
        if (!isWeaponOperable())
            return null;
        Projectile p = createProjectile(x, y, dirX, dirY, fighter, owner);
        lastShotTime = System.currentTimeMillis();
        return p;
    }

    public abstract Projectile createProjectile(double x, double y, double dirX, double dirY, Fighter fighter, int owner);

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public double getProjectileSpeed() {
        return projectileSpeed;
    }

    public long getCooldown() {
        return cooldown;
    }

    public Color getColor() {
        return color;
    }

    public double calculateDamage(Fighter fighter) {
        return damage * getDamageMultiplier(fighter);
    }

    protected abstract double getDamageMultiplier(Fighter fighter);
}