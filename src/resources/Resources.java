package resources;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import main.MainWindow;

public class Resources {

    protected MainWindow parent;
    private Image texturePlayer;
    
    public static final int PLAYER = 1;

    public Resources(MainWindow parent) {
        this.parent = parent;
        loadTextures();
    }

    public void loadTextures() {
        try {
            texturePlayer = ImageIO.read(Resources.class.getResourceAsStream("Player.png"));
            System.out.println("Player.png loaded");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to load resources from folder", "Resource failure", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public Image getTexture(int texture) {
        switch(texture) {
            case PLAYER:
                return texturePlayer;
        }
        return null;
    }
}