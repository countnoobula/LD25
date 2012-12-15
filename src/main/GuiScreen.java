package main;

import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class GuiScreen extends JPanel {

    protected MainWindow parent;
    
    public abstract void render(Graphics g);
}
