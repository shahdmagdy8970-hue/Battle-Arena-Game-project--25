package com.example.battlearena.models;

public abstract class Projectile {
     private double x;
    private double y;
    private double vx;
      private double vy;
    private Weapon  weapon;
    private Fighter fighter;
    private int  owner;
   private boolean active;
    public Projectile( double x, double y, double vx, double vy, Weapon weapon, Fighter fighter, int owner) {
        this.x = x;
        this.y = y;
       this.vx = vx;
        this.vy = vy;
        this.weapon = weapon;
        this.fighter = fighter;
        this.owner =  owner;
        this.active  = true; }
    public void update() {
        x = x + vx;
        y = y + vy;
    }

    public boolean isActive() {
        return active;}

    public void deactivate() {
        active = false;
      }

   public double getX() {
        return x;
   }
    public double getY() {
        return y;
      }
      public Weapon getWeapon() {
        return weapon;
   }
    public Fighter getFighter() {
        return fighter;
    }

    public int getOwner() {
        return owner;
    }
}