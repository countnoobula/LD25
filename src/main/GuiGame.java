package main;

import java.awt.Graphics;

public class GuiGame extends GuiScreen {

    protected HandlerPlayer handlerPlayer = new HandlerPlayer(this);
    protected HandlerMap handlerMap = new HandlerMap(this);

    public GuiGame(MainWindow parent) {
        this.parent = parent;
    }

    @Override
    public void render(Graphics g) {
    }
}