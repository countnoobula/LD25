package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HandlerMap {

    protected GuiGame parent;
    protected int[][] currentMapArray;
    protected BufferedImage currentView;

    public HandlerMap(GuiGame parent) {
        this.parent = parent;
        currentMapArray = new int[15][20];
        updateCurrentMap();
        currentView = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
        renderCurrentView();
    }

    public void updateCurrentMap() {
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 20; j++) {
                currentMapArray[i][j] = 1;
            }
        }
        currentMapArray[2][2] = 2;
        currentMapArray[2][3] = 2;
        currentMapArray[2][4] = 2;
        currentMapArray[2][5] = 2;
        currentMapArray[3][3] = 2;
    }
    
    public boolean canWalk(int x, int y) {
        return parent.handlerTiles.getTile(currentMapArray[y][x]).isPassable();
    }

    public BufferedImage getCurrentView() {
        return currentView;
    }
    
    public void renderCurrentView() {
        currentView = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics g = currentView.getGraphics();

        for(int rows = 0; rows < 20; rows++) {
            for(int cols = 0; cols < 15; cols++) {
                g.drawImage(parent.handlerTiles.getTile(currentMapArray[cols][rows]).getTexture(), rows * 32, cols * 32, parent);
            }
        }
    }
}