package main;

public class UnitMage extends Unit {

    public UnitMage(HandlerUnits parent) {
        super(parent);
        this.parent = parent;
        maxHealth = 80;
        currentHealth = 120;
        damageType = Defines.MAGIC;
        damage = 20;
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public boolean canFly() {
        return true;
    }
}