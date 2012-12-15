package main;

import java.awt.Graphics;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    protected int mode = Defines.GAME;
    protected InputKeyboard input = new InputKeyboard(this);
    protected GuiMenu screenMenu = new GuiMenu(this);
    protected GuiGame screenGame = new GuiGame(this);

    public MainWindow() {
        super(Defines.WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new GuiGame(this));
        addKeyListener(input);
        setMinimumSize(Defines.PANEL_SIZE);
        setPreferredSize(Defines.PANEL_SIZE);
        setMaximumSize(Defines.PANEL_SIZE);
        pack();
        setVisible(true);
    }

    public void changeToMenu() {
        //to be filled in
        mode = Defines.MENU;
    }
    
    public void quitGame() {
        //to be filled in
        System.out.println();
    }
    
    @Override
    public void paint(Graphics g) {
        switch(mode) {
            case Defines.GAME:
                screenGame.render(g);
                break;
            case Defines.MENU:
                screenGame.render(g);
                break;
            default:
                screenGame.render(g);
                break;
        }
    }
}