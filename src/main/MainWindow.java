package main;

import java.awt.Graphics;
import javax.swing.JFrame;
import resources.Resources;

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
        setLocationRelativeTo(null);
        setUndecorated(true);
        pack();
        setVisible(true);
    }

    public void changeToMenu() {
        //to be filled in
        mode = Defines.MENU;
    }
    
    public void quitGame() {
        //to be filled in
        System.exit(0);
    }
    
    @Override
    public void paint(Graphics g) {
        switch(mode) {
            case Defines.GAME:
                screenGame.render(g);
                break;
            case Defines.MENU:
                screenMenu.render(g);
                break;
            default:
                screenMenu.render(g);
                break;
        }
    }
}