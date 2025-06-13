package com.arcadia.demo;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.map.MapManager;
import com.arcadia.core.map.Tile;
import com.arcadia.core.map.loader.TileMapLoader;
import com.arcadia.core.scene.Scene;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoScene implements Scene {
    private final MapManager mapManager;

    public DemoScene() {
        Tile[][] tiles = new Tile[0][0];

        try {
            // 🔹 Relative to project root; adjust if needed
            Path mapPath = Paths.get("maps/demo_map.txt");
            tiles = TileMapLoader.load(mapPath);
        } catch (Exception e) {
            System.err.println("Failed to load map: " + e.getMessage());
        }

        this.mapManager = new MapManager(tiles);
    }

    public MapManager getMapManager() {
        return mapManager;
    }

    @Override
    public void load(EntityManager manager) {
        manager.addEntity(EntityFactory.createPlayer(2, 3));
        manager.addEntity(EntityFactory.createWanderer(2, 2));
        manager.addEntity(EntityFactory.createStaticObject(3, 2));
    }
}
