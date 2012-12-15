package main;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import resources.Resources;

public class TileWater extends Tile {

    public TileWater(HandlerTiles parent) {
        super(parent);
        this.parent = parent;
        try {
            texture = ImageIO.read(Resources.class.getResourceAsStream("TileWater.png"));
            parent.registerTile(this);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to load player resources", "Resource failure", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            parent.getMainWindow().quitGame();
        }
    }

    @Override
    public boolean isPassable() {
        return false;
    }

    public int getID() {
        return 1;
    }
}