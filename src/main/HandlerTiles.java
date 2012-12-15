package main;

import java.util.HashMap;

public class HandlerTiles {
    
    protected MainWindow parent;
    private HashMap<Integer, Tile> tileMap = new HashMap<>();
    
    public HandlerTiles(MainWindow parent) {
        this.parent = parent;
    }
    
    public void registerTile(Tile tileToRegister) {
        if(tileMap.get(tileToRegister.getID()) == null) {
            tileMap.put(tileToRegister.getID(), tileToRegister);
        }
    }
    
    public Tile getTile(int id) {
        return tileMap.get(id);
    }
    
    public MainWindow getMainWindow() {
        return parent;
    }
}