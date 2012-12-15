package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InputMouse implements MouseListener {

    protected MainWindow parent;
    
    public InputMouse(MainWindow parent) {
        this.parent = parent;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        int mouseX = e.getPoint().x;
        int mouseY = e.getPoint().y;
        int tempX = mouseX%32;
        int tempY = mouseY%32;
        mouseX = mouseX-tempX;
        mouseX = mouseX/32;
        mouseY = mouseY-tempY;
        mouseY = mouseY/32;
        parent.screenGame.handlerPlayer.selectSpot(mouseX, mouseY);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}