package com.arcadia.core.system;

import com.arcadia.core.components.PositionComponent;
import com.arcadia.core.components.RenderLayerComponent;
import com.arcadia.core.components.RenderableComponent;
import com.arcadia.core.entity.*;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.map.MapManager;
import com.arcadia.core.util.EngineLogger;

import java.util.List;

public class RenderSystem implements GameSystem {
    private final MapManager mapManager;
    private final Renderer renderer;

    public RenderSystem(MapManager mapManager, Renderer renderer) {
        this.mapManager = mapManager;
        this.renderer = renderer;
    }

    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        int width = mapManager.getWidth();
        int height = mapManager.getHeight();
        char[][] grid = new char[height][width];

        // Render base map tiles
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                grid[y][x] = mapManager.getTile(x, y).getSymbol();

        // Get all renderable entities with positions and layers
        List<Entity> entities = entityManager.getEntitiesWithAll(
                PositionComponent.class,
                RenderableComponent.class,
                RenderLayerComponent.class
        );

        // Sort entities by render layer
        entities.sort((a, b) -> {
            int layerA = a.getComponent(RenderLayerComponent.class).layer;
            int layerB = b.getComponent(RenderLayerComponent.class).layer;
            return Integer.compare(layerA, layerB);
        });

        // Draw entities on grid
        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            RenderableComponent render = e.getComponent(RenderableComponent.class);
            if (pos == null || render == null) continue;

            int x = (int) pos.x;
            int y = (int) pos.y;
            if (x >= 0 && x < width && y >= 0 && y < height) {
                grid[y][x] = render.glyph;
                EngineLogger.render(e + " rendered as '" + render.glyph + "' at (" + x + ", " + y + ")");
            }
        }

        EngineLogger.render("🖥️ Render frame"); // 🔍 NEW: render debug line
        renderer.render(grid);
    }
}
