package main;

public class UnitSword extends Unit {

    public UnitSword(HandlerUnits parent) {
        super(parent);
        this.parent = parent;
        maxHealth = 120;
        currentHealth = 120;
        damageType = Defines.MELEE;
        damage = 20;
        range = 1;
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