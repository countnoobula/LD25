package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.io.InputStream;
import resources.Resources;

public class GuiMenu extends GuiScreen {

    protected Font aerial = null;
    
    public GuiMenu(MainWindow parent) {
        this.parent = parent;

        try {
            InputStream is = Resources.class.getResourceAsStream("aerial.ttf");
            aerial = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(Font.TRUETYPE_FONT, 12);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.err.println("'aerial.ttf' not loaded.  Using Serif font.");
            aerial = new Font("serif", Font.PLAIN, 24);
        }
    }

    @Override
    public void render(Graphics g) {
        g.clearRect(0, 0, 640, 480);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 640, 480);
        g.setFont(aerial);
        
        FontMetrics metrics = g.getFontMetrics(aerial);
        g.setColor(new Color(0, 200, 255));
        g.drawString("Press space to begin...", 198, 375);
    }
}