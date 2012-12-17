package main;

import java.util.ArrayList;

public class HandlerPath implements Runnable {

    protected GuiGame parent;
    
    protected Unit movable;
    protected int[] source = {-1,-1};
    protected int[] dest = {-1,-1};
    
    // Change at own risk for FOV
    protected int[] xMods = {1,2};
    protected int[] yMods = {1,2};
    
    protected boolean done = false;

    public HandlerPath(GuiGame parent, Unit unit, int initialX, int initialY, int destinationX, int destinationY) {
        this.parent = parent;
        
        movable = unit;
        source[0] = initialX;
        source[1] = initialY;
        
        dest[0] = destinationX;
        dest[1] = destinationY;
        
        System.out.println("Moving from " + initialX + ";" + initialY + " to " + destinationX + ";" + destinationY);
    }
    
    public boolean isDone() {
        return done;
    }
    
    public void runTick() {
        //code here
    }

    @Override
    synchronized public void run(){
        System.out.println("Movement started");
        done = false;
        
        ArrayList<Integer> dist = new ArrayList<>();
        dist.add(dest[0] - source[0]);
        dist.add(dest[1] - source[1]);
        
        int tempsrc[] = source;
        
        if (!parent.handlerMap.isOccupiable(dest[0], dest[1])){
            System.out.println("Tile not occupiable!");
            return;
        }
        
        while (dist.get(0) != 0 || dist.get(1) != 0 ){
            
            ArrayList<ArrayList<ArrayList<Integer>>> surrounds = UtilGetSurroundings.getSurroundings(tempsrc, xMods, yMods);
            for (int x=0; x < surrounds.size(); x++){
                System.out.println(surrounds.get(x));
            }
            
            tempsrc = source;
            
            if (dist.get(0) < 0){
                tempsrc[0] = source[0] - 1;
                dist.set(0,dest[0] - tempsrc[0]);
            }
            else if (dist.get(0) > 0){
                tempsrc[0] = source[0] + 1;
                dist.set(0,dest[0] - tempsrc[0]);
            }
            if (dist.get(1) < 0){
                tempsrc[1] = source[0] - 1;
                dist.set(1,dest[1] - tempsrc[1]);
            }
            else if(dist.get(1) > 0){
                tempsrc[1] = source[1] + 1;
                dist.set(1,dest[1] - tempsrc[1]);
            }
            
            if (parent.handlerMap.isOccupiable(tempsrc[0], tempsrc[1])){
                movable.setLocation(tempsrc[0], tempsrc[1]);
                parent.parent.repaint();
            }
            
            System.out.println(dist);
            
            try {
                this.wait(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Movement end");
        done = true;
    }
}