package com.thegamedevs.game_no_one;


import com.thegamedevs.game_no_one.display.Display;

public class Game implements  Runnable{

    private Display display;
    public int width;
    public int height;
    public String title;
    private Thread thread;
    private boolean running = false;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;

    }


    @Override
    public void run() {
        init();

        while(running){
            update();
            render();
        }
    }

    private void render() {

    }

    private void update() {

    }

    public synchronized void start(){
        if(!running) {
            running = true;
            thread = new Thread(this);
            thread.start();
        }

    }

    public synchronized void stop(){
        if(running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private void init(){
        this.display = new Display(title,width,height);

        //inits graphics
    }
}
