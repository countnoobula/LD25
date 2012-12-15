package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class GuiGame extends GuiScreen {

    protected HandlerTiles handlerTiles = new HandlerTiles(this);
    protected HandlerPlayer handlerPlayer = new HandlerPlayer(this);
    protected HandlerMap handlerMap = new HandlerMap(this);

    public GuiGame(MainWindow parent) {
        this.parent = parent;
    }
    
    public void drawHighlightedBox() {
        
    }
    
    @Override
    public void render(Graphics g) {//32x32 blocks
        if(handlerMap.isDirty()) {
            handlerMap.renderCurrentView();
        }
        
        int playerX = handlerPlayer.xPos * 32;
        int playerY = handlerPlayer.yPos * 32;
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 640, 480);

        g.drawImage(handlerMap.getCurrentView(), 0, 0, parent);

        if(handlerPlayer.hasSelectedTile()) {
            Point selectedTile = handlerPlayer.getSelectedTile();
            g.setColor(Color.YELLOW);
            g.drawRect(selectedTile.x * 32, selectedTile.y * 32, 32, 32);
        }
    }
}