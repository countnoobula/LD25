package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class HandlerMap {

    protected GuiGame parent;
    protected int[][] currentMapArray;
    protected int[][] fullMapArray;
    protected BufferedImage currentView;
    private boolean dirty = true;
    private boolean mapLoaded = false;
    
    public HandlerMap(GuiGame parent) {
        this.parent = parent;
        currentMapArray = new int[20][15];
        fullMapArray = new int[50][50];
        loadMap(new File("map.txt"));
        updateCurrentMap();
        currentView = new BufferedImage(640, 480, BufferedImage.TYPE_INT_RGB);
    }

    private void populateMap() {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                fullMapArray[i][j] = 0;
            }
        }
    }
    
    private void completeMap() {
        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                if(parent.handlerTiles.getTile(fullMapArray[i][j]) == null) {
                    fullMapArray[i][j] = 1;
                }
            }
        }
    }

    public void loadMap(File mapFile) {
        if(!mapFile.exists()) {
            JOptionPane.showMessageDialog(null, "Map failed to load. File not found.", "Map failed to load", JOptionPane.ERROR_MESSAGE);
        }
        String mapData = "";

        try {
            Scanner mapInput = new Scanner(mapFile);

            if(mapInput.hasNextLine()) {
                mapData = mapInput.nextLine();
            } else {
                JOptionPane.showMessageDialog(null, "Map failed to load. Invalid content.", "Map failed to load", JOptionPane.ERROR_MESSAGE);
            }
        } catch(Exception ex) {
            ex.printStackTrace();
            System.exit(0);
        }
        populateMap();
        String rows[] = new String[50];
        try {
            String[] tempMapData;
            int rowCount = 0;

            tempMapData = mapData.split(";");
            if(tempMapData.length != 50) {
                return;
            }
            for(int i = 0; i < 50; i++) {
                rows[i] = tempMapData[i];
            }
        } catch(Exception ex) {
            return;
        }

        for(int row = 0; row < 50; row++) {
            String[] rowData = rows[row].split(",");
            for(int col = 0; col < 50; col++) {
                int mapPos = 0;
                try {
                    mapPos = Integer.parseInt(rowData[col]);
                } catch(Exception ex) {
                    mapPos = 0;
                }
                fullMapArray[col][row] = mapPos;
            }
        }

        completeMap();
        mapLoaded = true;
    }

    public void updateCurrentMap() {
        if((parent.handlerPlayer.xPos + 20) > 50) {
            parent.handlerPlayer.xPos = (50 - 20);
        }
        if((parent.handlerPlayer.yPos + 15) > 50) {
            parent.handlerPlayer.yPos = (50 - 15);
        }

        for(int y = 0; y < 15; y++) {
            for(int x = 0; x < 20; x++) {
                currentMapArray[x][y] = fullMapArray[parent.handlerPlayer.xPos + x][parent.handlerPlayer.yPos + y];
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
        if(mapLoaded) {
            for(int cols = 0; cols < 20; cols++) {
                for(int rows = 0; rows < 15; rows++) {
                    if(parent.handlerTiles.getTile(currentMapArray[cols][rows]) != null) {
                        g.drawImage(parent.handlerTiles.getTile(currentMapArray[cols][rows]).getTexture(), cols * 32, rows * 32, parent);
                    } else {
                        System.out.println(rows + ";" + cols + " is null.");
                    }
                }
            }
        } else {
            renderCurrentView();
        }
    }

    public void makeDirty() {
        dirty = true;
        parent.getMainWindow().repaint();
    }

    public boolean isDirty() {
        return dirty;
    }

    public boolean isMapLoaded() {
        return mapLoaded;
    }
}