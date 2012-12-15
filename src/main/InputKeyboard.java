package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputKeyboard implements KeyListener {

    protected MainWindow parent;
    private long previousKeyTime = 0;

    public InputKeyboard(MainWindow parent) {
        this.parent = parent;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        parseInput(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void parseInput(int keyCode) { //due to special symbols
        if((System.currentTimeMillis() - previousKeyTime) > 50) {
            switch(parent.mode) {
                case Defines.GAME:
                    switch(keyCode) {
                        case 65: //a
                            parent.screenGame.handlerPlayer.moveLeft();
                            break;
                        case 87: //w
                            parent.screenGame.handlerPlayer.moveUp();
                            break;
                        case 83: //s
                            parent.screenGame.handlerPlayer.moveDown();
                            break;
                        case 68: //d
                            parent.screenGame.handlerPlayer.moveRight();
                            break;
                        case 27: //esc
                            parent.changeToMenu();
                            break;
                        case 32: //space
                            break;
                    }
                    parent.screenGame.handlerPlayer.clearSelection();
                    break;
                case Defines.MENU:
                    switch(keyCode) {
                        case 27:
                            parent.quitGame();
                            break;
                        case 32:
                            parent.startGame();
                            break;
                    }
                    break;
            }
            previousKeyTime = System.currentTimeMillis();
            parent.repaint();
        }
    }
}