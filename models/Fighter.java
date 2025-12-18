package com.example.battlearena.models;

import javafx.scene.paint.Color;

public abstract class Fighter {
    private static final double SPAWN_DISTANCE = 20.0;

    private String name;
    private FighterType type;
    private double x;
    private double y;
    private double health;
    private double maxHealth;
    private Weapon weapon;
    private double rotation;
    private Color color;

    public Fighter(String name, FighterType type, double x, double y, double maxHealth, Color color) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.health = maxHealth;
        this.maxHealth = maxHealth;
        this.rotation = 0;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public FighterType getType() {
        return type;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getHealth() {
        return health;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public double getRotation() {
        return rotation;
    }

    public Color getColor() {
        return color;
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setRotation(double angle) {
        this.rotation = angle;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void takeDamage(double damage) {
        this.health = Math.max(0, this.health - damage);
    }

    public Projectile shoot(int owner) {
        if (weapon == null) {
            return null;
        }

        double radians = Math.toRadians(rotation);
        double dirX = Math.cos(radians);
        double dirY = Math.sin(radians);

        double spawnX = x + dirX * SPAWN_DISTANCE;
        double spawnY = y + dirY * SPAWN_DISTANCE;

        return weapon.fire(spawnX, spawnY, dirX, dirY, this, owner);
    }

    public abstract String getSpecialAbility();
}