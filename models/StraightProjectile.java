package com.example.battlearena.models;

public class StraightProjectile extends Projectile {
    public StraightProjectile(double x, double y, double vx, double vy, Weapon weapon, Fighter fighter, int owner) {
        super(x, y, vx, vy, weapon, fighter, owner);
    }
}