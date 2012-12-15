package resources;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import main.MainWindow;

public class Resources {

    protected MainWindow parent;
    
    private Image texturePlayer;
    private Image textureTileWater;
    
    public static final int PLAYER = 1;
    public static final int TILE_WATER = 2;

    public Resources(MainWindow parent) {
        this.parent = parent;
        loadTextures();
    }

    public void loadTextures() {
        try {
            texturePlayer = ImageIO.read(Resources.class.getResourceAsStream("Player.png"));
            System.out.println("Player.png loaded");
            textureTileWater = ImageIO.read(Resources.class.getResourceAsStream("TileWater.png"));
            System.out.println("TileWater.png loaded");
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
            case TILE_WATER:
                return textureTileWater;
        }
        return null;
    }
}