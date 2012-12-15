package main;

import java.awt.Color;
import java.awt.Graphics;

public class GuiGame extends GuiScreen {

    protected HandlerPlayer handlerPlayer = new HandlerPlayer(this);
    protected HandlerMap handlerMap = new HandlerMap(this);

    public GuiGame(MainWindow parent) {
        this.parent = parent;
    }
    
    @Override
    public void render(Graphics g) {//32x32 blocks
        int playerX = handlerPlayer.xPos * 32;
        int playerY = handlerPlayer.yPos * 32;
        
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 640, 480);
        
        for(int rows = 0; rows < 15; rows++) {
            for(int cols = 0; cols < 20; cols++) {
                //g.drawImage(parent.resources.getTexture(Resources.TILE_WATER), rows * 32, cols * 32, parent);
            }
        }
        
        g.drawImage(handlerPlayer.getAvatar(), playerX, playerY, parent);
    }
}