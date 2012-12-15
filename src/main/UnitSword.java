package main;

public class UnitSword extends Unit {

    public UnitSword(HandlerUnits parent) {
        super(parent);
        this.parent = parent;
        maxHealth = 120;
        currentHealth = 120;
    }
    
    @Override
    public int getID() {
        return 1;
    }
    
    @Override
    public boolean canFly() {
        return false;
    }
}