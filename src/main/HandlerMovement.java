package main;

import java.util.ArrayList;

public class HandlerMovement implements Runnable {

    protected ArrayList<HandlerPath> movementThreads;

    public HandlerMovement() {
        movementThreads = new ArrayList<>();
    }

    public void addMovementThread() {
    }

    private void removeCompletedThreads() {
        for(int i = 0; i < movementThreads.size(); i++) {
            if(movementThreads.get(i).isDone()) {
                movementThreads.remove(i);
            }
        }
    }

    private void executeThreads() {
        for(int i = 0; i < movementThreads.size(); i++) {
            movementThreads.get(i).runTick();
        }
    }

    @Override
    public void run() {
        long startTime = 0;
        while(Defines.GAME_RUNNING) {
            startTime = System.currentTimeMillis();
            removeCompletedThreads();
            executeThreads();
            if((System.currentTimeMillis() - startTime) < 200) {
                try {
                    Thread.sleep(200 - (System.currentTimeMillis() - startTime));
                } catch(Exception ex) {
                }
            }
        }
    }
}