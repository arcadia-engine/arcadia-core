package com.arcadia.demo;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.scene.Scene;
import com.arcadia.demo.map.MapManager;

public class DemoScene implements Scene {

    private final MapManager mapManager;

    public DemoScene() {
        this.mapManager = new MapManager(new String[] {
            "####################",
            "#..................#",
            "#..####............#",
            "#..................#",
            "####################"
        });
    }

    @Override
    public void load(EntityManager entityManager) {
        entityManager.addEntity(EntityFactory.createPlayer(2, 3));
        entityManager.addEntity(EntityFactory.createWanderer(2, 2));
        entityManager.addEntity(EntityFactory.createStaticObject(3, 2));

        // You might store the mapManager somewhere global if RenderSystem needs it
    }

    public MapManager getMapManager() {
        return mapManager;
    }
}
