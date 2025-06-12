package com.arcadia.core;

public class GameLoop {

    private boolean isRunning = false;

    public void start() {
        isRunning = true;
        System.out.println("🌀 Arcadia Engine started...");

        // Basic fixed-timestep loop
        final int fps = 60;
        final double frameTime = 1000.0 / fps;

        long lastTime = System.currentTimeMillis();

        while (isRunning) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime >= frameTime) {
                update();
                render();
                lastTime = currentTime;
            }
        }
    }

    private void update() {
        System.out.println("Updating game state...");
    }

    private void render() {
        System.out.println("Rendering frame...");
    }

    public void stop() {
        isRunning = false;
        System.out.println("🛑 Arcadia Engine stopped.");
    }
}
