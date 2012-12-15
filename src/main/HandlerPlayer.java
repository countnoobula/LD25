package main;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import resources.Resources;

public class HandlerPlayer {

    protected GuiGame parent;
    protected int xPos = 2;
    protected int yPos = 2;
    protected Image playerAvatar;

    public HandlerPlayer(GuiGame parent) {
        this.parent = parent;
        try {
            playerAvatar = ImageIO.read(Resources.class.getResourceAsStream("Player.png"));
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to load player resources", "Resource failure", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            parent.getMainWindow().quitGame();
        }
    }

    public void moveUp() {
        if(parent.handlerMap.canWalk(xPos, yPos - 1)) {
            yPos--;
        }
    }

    public void moveDown() {
        if(parent.handlerMap.canWalk(xPos, yPos + 1)) {
            yPos++;
        }
    }

    public void moveLeft() {
        if(parent.handlerMap.canWalk(xPos - 1, yPos)) {
            xPos--;
        }
    }

    public void moveRight() {
        if(parent.handlerMap.canWalk(xPos + 1, yPos)) {
            xPos++;
        }
    }
    
    public Image getAvatar() {
        return playerAvatar;
    }
}