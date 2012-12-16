package main;

import java.awt.Point;

public class Unit {

    protected HandlerUnits parent;
    protected int unitX = 0;
    protected int unitY = 0;
    protected int maxHealth = 0;
    protected int currentHealth = 0;
    protected boolean selected = false;
    protected int damageType = 0;
    protected int damage = 0;
    protected boolean playerOwned = true;

    public Unit(HandlerUnits parent) {
        this.parent = parent;
    }

    public boolean canFly() {
        return false;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setPlayerOwned(boolean po) {
        playerOwned = po;
    }
    
    public int getID() {
        return 0;
    }

    public void setLocation(int x, int y) {
        unitX = x;
        unitY = y;
    }

    public Point getLocation() {
        return new Point(unitX, unitY);
    }

    public void move(int x, int y) {
        new Thread(new HandlerPath(parent.getGuiGame(), this, unitX, unitY, x, y)).start();
    }

    public void select() {
        selected = true;
    }

    public void deselect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }
    
    public int getDamageType() {
        return damageType;
    }
    
    public int getDamage() {
        return damage;
    }

    public void attack(int x, int y) {
        //attack path calculation
        System.out.println("Attacking " + x + ";" + y);
    }

    public boolean isPlayerOwned() {
        return playerOwned;
    }
}