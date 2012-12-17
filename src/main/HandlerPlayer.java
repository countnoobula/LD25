package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 0;
    protected int yPos = 0;
    protected int cash = 0;
    protected BufferedImage miniMap;

    public HandlerPlayer(GuiGame parent) {
        this.parent = parent;
    }

    public void moveUp() {
        if(yPos != 0) {
            yPos--;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveDown() {
        if(yPos != 49) {
            yPos++;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveLeft() {
        if(xPos != 0) {
            xPos--;
        }
        parent.handlerMap.makeDirty();
    }

    public void moveRight() {
        if(xPos != 49) {
            xPos++;
        }
        parent.handlerMap.makeDirty();
    }

    public void selectSpot(int x, int y) {
        System.out.println(x + ";" + y);
        if(parent.handlerUnits.tileHasUnit(x, y)) {
            if(parent.handlerUnits.isFriendly(x+xPos, y+yPos)) {
                parent.handlerUnits.selectUnit(x, y);
            }
        } else {
            parent.handlerUnits.deselectAll();
        }
        
        parent.getMainWindow().repaint();
    }
    
    public void commandSpot(int x, int y) {
        if(parent.handlerUnits.isUnitsSelected()) {
            if(parent.handlerUnits.tileHasUnit(x, y)) {
                if(parent.handlerUnits.isFriendly(x+parent.handlerPlayer.xPos, y+parent.handlerPlayer.yPos)) {
                    parent.handlerUnits.moveSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
                    System.out.println("moving friendly");
                } else {
                    //parent.handlerUnits.attackSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
                    System.out.println("attacking enemy");
                }
            } else {
                parent.handlerUnits.moveSelected((x+parent.handlerPlayer.xPos), (y+parent.handlerPlayer.yPos));
                System.out.println("moving empty " + (x+parent.handlerPlayer.xPos) + ";" + (y+parent.handlerPlayer.yPos));
            }
        }
    }
    
    public void renderGUI(Graphics g) {
        g.setColor(Color.RED);
        g.fillRect(640, 0, 200, 480);
        
        g.setColor(Color.BLUE);
        g.fillRect(640, 0, 200, 200);
        
        g.setColor(Color.GREEN);
        g.fillRect(690, 50, 100, 100);
        
        g.setColor(Color.BLACK);
        g.fillRect(640, 200, 200, 36);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Serif", Font.PLAIN, 14));
        g.drawString("Cash: $" + getCash() + ".00", 660, 216);
        g.drawString("Unit Count: " + parent.handlerUnits.getUnitCount(), 660, 232);
    }
    
    private void renderMinimap() {
        //render to bufferedimage
    }
    
    public int getCash() {
        return cash;
    }
    
    public void setCash(int cash) {
        this.cash = cash;
    }
}