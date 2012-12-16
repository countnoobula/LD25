package main;

public class UnitArcher extends Unit {

    public UnitArcher(HandlerUnits parent) {
        super(parent);
        this.parent = parent;
        maxHealth = 100;
        currentHealth = 120;
        damageType = Defines.RANGED;
        damage = 20;
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public boolean canFly() {
        return false;
    }
}
