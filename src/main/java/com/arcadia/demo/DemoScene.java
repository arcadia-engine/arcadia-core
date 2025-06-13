package com.arcadia.demo;

import com.arcadia.core.entity.EntityManager;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.map.MapManager;
import com.arcadia.core.map.Tile;
import com.arcadia.core.map.loader.TileMapLoader;
import com.arcadia.core.scene.Scene;
import com.arcadia.core.system.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class DemoScene implements Scene {
    private final MapManager mapManager;
    private final Renderer renderer;
    private final InputProvider input;

    public DemoScene(Renderer renderer, InputProvider input) {
        this.renderer = renderer;
        this.input = input;

        Tile[][] tiles = new Tile[0][0];
        try {
            Path mapPath = Paths.get("maps/demo_map.txt"); // ASCII map
            tiles = TileMapLoader.load(mapPath);
        } catch (Exception e) {
            System.err.println("Failed to load map: " + e.getMessage());
        }

        this.mapManager = new MapManager(tiles);
    }

    @Override
    public void load(SystemManager systemManager, EntityManager manager) {
        systemManager.addSystem(new InputSystem(input));
        systemManager.addSystem(new IntentProcessingSystem()); // ← Insert this line
        systemManager.addSystem(new PhysicsSystem(mapManager));
        systemManager.addSystem(new RenderSystem(mapManager, renderer));

        manager.addEntity(EntityFactory.createPlayer(2, 3));
        manager.addEntity(EntityFactory.createWanderer(2, 2));
        manager.addEntity(EntityFactory.createStaticObject(3, 2));
    }

}
