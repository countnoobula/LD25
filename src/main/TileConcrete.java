package main;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import resources.Resources;

public class TileConcrete extends Tile {

    public TileConcrete(HandlerTiles parent) {
        super(parent);
        this.parent = parent;
        try {
            texture = ImageIO.read(Resources.class.getResourceAsStream("TileConcrete.png"));
            parent.registerTile(this);
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, "Failed to load player resources", "Resource failure", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            parent.getMainWindow().quitGame();
        }
    }

    @Override
    public boolean isPassable() {
        return true;
    }

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public String getName() {
        return "Concrete Tile";
    }
}