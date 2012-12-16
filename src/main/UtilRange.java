package main;

import java.util.ArrayList;
import java.util.Collections;

public class UtilRange {
    public static ArrayList<Integer> getRange(int root, int Mods[]){
            int count = 0; 
            int flag = 0;
            ArrayList<Integer> retRange = new ArrayList<Integer>();
            for (int n = 0; n < Mods.length; n++){
                int x = 1;
                int nUse = Mods[n];
                if (n == 1){
                    nUse = Mods[n]-1;
                }
                
                while (x <= nUse){
                    if (flag == 0){
                        retRange.add(root-x);
                        count++;
                    }
                    
                    else if (flag == 1){
                        retRange.add(root+x);
                        count++;
                    }
                    x++;
                }
                
                if (flag == 0){
                    flag++;
                    retRange.add(root);
                    count++;
                }
            }
            Collections.sort(retRange);
            return retRange;
        }
}
