package com.example.battlearena.utils;

import com.example.battlearena.models.Fighter;
import com.example.battlearena.models.Projectile;

public class CollisionDetector {
    private int playerSize;
    private int projectileSize;

    public CollisionDetector(int playerSize, int projectileSize) {
        this.playerSize = playerSize;
        this.projectileSize = projectileSize;
    }

    public boolean checkCollision(Projectile p, Fighter f) {
        return Math.abs(p.getX() - f.getX()) < playerSize / 2.0 + projectileSize &&
                Math.abs(p.getY() - f.getY()) < playerSize / 2.0 + projectileSize;
    }
}
