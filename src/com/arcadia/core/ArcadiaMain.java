package com.arcadia.core;

import com.arcadia.core.entity.*;

public class ArcadiaMain {
    public static void main(String[] args) {
        Entity player = new Entity();
        player.addComponent(new PositionComponent(10, 25));

        GameLoop loop = new GameLoop();
        loop.start();
    }
}