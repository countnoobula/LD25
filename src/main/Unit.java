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
    protected int range = 0;
    protected int speed = 1;

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

    public void inflictDamage(int damageAmount) {
        currentHealth = currentHealth-damageAmount;
        if(currentHealth < 0) {
            parent.killUnit(this);
        }
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
    
    public int getRange() {
        return range;
    }
    
    public int getSpeed() {
        return 1;
    }
        
    public boolean isInRange(int x, int y) {
        return true;
    }
    
    public void attack(int x, int y) {
        Unit targetUnit = parent.getUnit(x, y);
        int damageAmount = getDamage();
        
        switch(targetUnit.getDamageType()) {
            case Defines.MELEE:
                if(getDamageType() == Defines.RANGED) {
                    damageAmount = (int)(damageAmount * 0.8);
                }
                if(getDamageType() == Defines.MAGIC) {
                    damageAmount = (int)(damageAmount * 1.2);
                }
                break;
            case Defines.RANGED:
                if(getDamageType() == Defines.MELEE) {
                    damageAmount = (int)(damageAmount * 0.8);
                }
                if(getDamageType() == Defines.MAGIC) {
                    damageAmount = (int)(damageAmount * 1.2);
                }
                break;
            case Defines.MAGIC:
                if(getDamageType() == Defines.MELEE) {
                    damageAmount = (int)(damageAmount * 0.8);
                }
                if(getDamageType() == Defines.RANGED) {
                    damageAmount = (int)(damageAmount * 1.2);
                }
                break;
        }
        
        //attack path calculation
        if(isInRange(x, y)) {
            parent.getUnit(x, y).inflictDamage(30);
            System.out.println("is in target");
        }
        System.out.println("Attacking " + x + ";" + y);
    }

    public boolean isPlayerOwned() {
        return playerOwned;
    }
}