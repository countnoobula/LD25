package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HandlerMap {

    protected GuiGame parent;
    protected int[][] currentMapArray;
    protected int[][] fullMapArray;
    protected BufferedImage currentView;
    private boolean dirty = true;

    public HandlerMap(GuiGame parent) {
        this.parent = parent;
        currentMapArray = new int[15][20];
        fullMapArray = new int[50][50];
        loadFullMap();
        updateCurrentMap();
        currentView = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
    }

    public void loadFullMap() {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                fullMapArray[i][j] = 1;
            }
        }
        fullMapArray[2][2] = 2;
        fullMapArray[2][3] = 2;
        fullMapArray[2][4] = 2;
        fullMapArray[2][5] = 2;
        fullMapArray[3][3] = 2;
        fullMapArray[4][3] = 2;
        fullMapArray[4][4] = 2;
        fullMapArray[4][5] = 3;
        fullMapArray[3][2] = 3;
    }

    public void updateCurrentMap() {
        if((parent.handlerPlayer.xPos + 15) > 50) {
            parent.handlerPlayer.xPos = (50 - 15);
        }
        if((parent.handlerPlayer.yPos + 20) > 50) {
            parent.handlerPlayer.yPos = (50 - 20);
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 20; j++) {
                currentMapArray[i][j] = fullMapArray[parent.handlerPlayer.xPos + i][parent.handlerPlayer.yPos + j];
            }
        }
    }

    public boolean canWalk(int x, int y) {
        return parent.handlerTiles.getTile(currentMapArray[y][x]).isPassable();
    }

    public BufferedImage getCurrentView() {
        return currentView;
    }

    public void renderCurrentView() {
        updateCurrentMap();
        currentView = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
        Graphics g = currentView.getGraphics();
        for(int rows = 0; rows < 20; rows++) {
            for(int cols = 0; cols < 15; cols++) {
                if(parent.handlerTiles.getTile(currentMapArray[cols][rows]) != null) {
                    g.drawImage(parent.handlerTiles.getTile(currentMapArray[cols][rows]).getTexture(), rows * 32, cols * 32, parent);
                } else {
                    System.out.println(cols + ";" + rows + " is null.");
                }
            }
        }
    }

    public void makeDirty() {
        dirty = true;
        parent.getMainWindow().repaint();
    }

    public boolean isDirty() {
        return dirty;
    }
}