package com.arcadia.core.system;

import com.arcadia.core.entity.*;
import com.arcadia.core.util.*;
import java.util.List;

public class RenderSystem implements GameSystem {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;

    @Override
    public void update(EntityManager entityManager, double deltaTime) {
        char[][] grid = new char[HEIGHT][WIDTH];

        // Fill with dots
        for (int y = 0; y < HEIGHT; y++)
            for (int x = 0; x < WIDTH; x++)
                grid[y][x] = '.';

        // Place entities on grid
        List<Entity> entities = entityManager.getEntitiesWith(PositionComponent.class);
        for (Entity e : entities) {
            PositionComponent pos = e.getComponent(PositionComponent.class);
            int x = Math.max(0, Math.min(WIDTH - 1, (int) pos.x));
            int y = Math.max(0, Math.min(HEIGHT - 1, (int) pos.y));
            grid[y][x] = '@';  // Render symbol
            EngineLogger.render(e + " rendered at (" + x + ", " + y + ")");
        }

        

        // Clear console (optional)
        System.out.print("\033[H\033[2J");
        System.out.flush();

        // Print grid
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++)
                System.out.print(grid[y][x]);
            System.out.println();
        }

        System.out.println(); // Spacer
    }
}
