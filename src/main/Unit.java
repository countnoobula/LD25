package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class Unit {

    protected HandlerUnits parent;
    protected int unitX = 0;
    protected int unitY = 0;
    protected int maxHealth = 0;
    protected int currentHealth = 0;
    protected int mapID = 0;
    protected boolean selected = false;

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
        new Thread(new HandlerPath(parent.getGuiGame(), mapID, unitX, unitY, x, y)).start();
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
}