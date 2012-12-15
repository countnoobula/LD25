package main;

import java.util.HashMap;

public class HandlerTiles {
    
    protected GuiGame parent;
    private HashMap<Integer, Tile> tileMap = new HashMap<>();
    
    public HandlerTiles(GuiGame parent) {
        this.parent = parent;
        new TileWater(this);
        new TileConcrete(this);
    }
    
    public void registerTile(Tile tileToRegister) {
        if(tileMap.get(tileToRegister.getID()) == null) {
            tileMap.put(tileToRegister.getID(), tileToRegister);
            System.out.println(tileToRegister.getName() + " registered");
        }
    }
    
    public Tile getTile(int id) {
        return tileMap.get(id);
    }
    
    public MainWindow getMainWindow() {
        return parent.getMainWindow();
    }
}