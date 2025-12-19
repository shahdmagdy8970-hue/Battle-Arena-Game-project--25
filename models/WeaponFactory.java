package com.example.battlearena.models;

public class WeaponFactory {
    public static Weapon createWeapon(WeaponType type) {
        switch (type) {
            case PISTOL:
                return new Pistol();
            case CANNON:
                return new Cannon();
            case MAGIC_STAFF:
                return new MagicStaff();
            case BOW:
                return new Bow();
            default:
                return new Pistol();
        }
    }
}