package main;

import java.util.ArrayList;

public class UtilGetSurroundings {
    public static ArrayList<ArrayList<ArrayList<Integer>>> getSurroundings(int root[], int xMods[], int yMods[]){
        ArrayList<ArrayList<ArrayList<Integer>>> surroundings = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<Integer> xr = UtilRange.getRange(root[0], xMods);
        ArrayList<Integer> yr = UtilRange.getRange(root[0], yMods);
        
        for(int x=0; x <= xr.size()-1; x++){
            surroundings.add(new ArrayList<ArrayList<Integer>>());
            for(int y=0; y <= yr.size()-1; y++){
                surroundings.get(x).add(new ArrayList<Integer>());
                surroundings.get(x).get(y).add(xr.get(x));
                surroundings.get(x).get(y).add(yr.get(y));
            }
        }
        
        return surroundings;
    }
    
}
