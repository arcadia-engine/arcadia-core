package com.arcadia.core.map;

import com.arcadia.core.collision.CollisionProvider;

public class MapManager implements CollisionProvider {
    private final Tile[][] tiles;

    // Load from pre-parsed tile data (e.g., loader)
    public MapManager(Tile[][] tiles) {
        this.tiles = tiles;
    }

    // Convenience: parse ASCII layout
    public MapManager(String[] layout) {
        this(parseLayout(layout));
    }

    private static Tile[][] parseLayout(String[] layout) {
        int height = layout.length;
        int width = layout[0].length();
        Tile[][] result = new Tile[height][width];

        for (int y = 0; y < height; y++) {
            String row = layout[y];
            for (int x = 0; x < width; x++) {
                char c = row.charAt(x);
                result[y][x] = switch (c) {
                    case '#' -> new Tile(TileType.WALL);
                    case '.' -> new Tile(TileType.FLOOR);
                    default  -> new Tile(TileType.FLOOR); // fallback
                };
            }
        }
        return result;
    }

    public Tile getTile(int x, int y) {
        if (y >= 0 && y < tiles.length && x >= 0 && x < tiles[0].length) {
            return tiles[y][x];
        }
        return new Tile(TileType.WALL); // fallback for OOB
    }

    @Override
    public boolean isWalkable(int x, int y) {
        return getTile(x, y).getType().isWalkable();
    }

    public int getWidth() {
        return tiles[0].length;
    }

    public int getHeight() {
        return tiles.length;
    }
}
