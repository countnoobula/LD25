package main;

import java.awt.Graphics;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    protected int mode = Defines.MENU;
    protected InputKeyboard inputKeyboard = new InputKeyboard(this);
    protected InputMouse inputMouse = new InputMouse(this);
    protected GuiMenu screenMenu = new GuiMenu(this);
    protected GuiGame screenGame = new GuiGame(this);

    public MainWindow() {
        super(Defines.WINDOW_TITLE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new GuiGame(this));
        addKeyListener(inputKeyboard);
        addMouseListener(inputMouse);
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
    
    public void startGame() {
        //to be filled in
        mode = Defines.GAME;
    }
    
    public void quitGame() {
        //to be filled in
        System.exit(0);
    }
    
    public void runTick() {
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