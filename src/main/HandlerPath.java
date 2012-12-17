package main;

import java.util.ArrayList;

public class HandlerPath implements Runnable {

    protected GuiGame parent;
    
    protected Unit movable;
    
    // Change at own risk for FOV
    protected int[] xMods = {1,2};
    protected int[] yMods = {1,2};
    

    public HandlerPath(GuiGame parent, Unit unit) {
        this.parent = parent;
        
        movable = unit;
    }

    @Override
    synchronized public void run(){
        System.out.println("Movement started");
        
        ArrayList<Integer> dist = new ArrayList<>();
        dist.add(movable.unitX - movable.destX);
        dist.add(movable.unitY - movable.destY);
        
        int source[] = {movable.unitX,movable.unitY};
        
        System.out.println(dist);
        
        while (true){
            int dest[] = {movable.destX, movable.destY};
            
            int tempsrc[] = source;
            
            //System.out.println(movable.destX + " " + movable.destY);
            
            if(dist.get(0) != 0 || dist.get(1) != 0){
                ArrayList<ArrayList<ArrayList<Integer>>> surrounds = UtilGetSurroundings.getSurroundings(tempsrc, xMods, yMods);
                for (int x=0; x < surrounds.size(); x++){
                    System.out.println(surrounds.get(x));
                }
            
                tempsrc = source;
            
                if (dist.get(0) < 0){
                    tempsrc[0] = source[0] - 1;
                    dist.set(0,dest[0] - tempsrc[0]);
                }
                if (dist.get(0) > 0){
                    tempsrc[0] = source[0] + 1;
                    dist.set(0,dest[0] - tempsrc[0]);
                }
                if (dist.get(1) < 0){
                    tempsrc[1] = source[0] - 1;
                    dist.set(1,dest[1] - tempsrc[1]);
                }
                if(dist.get(1) > 0){
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
                    break;
                }
            }
        }
        System.out.println("Movement end");
    }
}