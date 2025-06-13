package com.arcadia.core.map;

public class MapManager {
    private final int width;
    private final int height;
    private final Tile[][] tiles;

    public MapManager(String[] layout) {
        this.height = layout.length;
        this.width = layout[0].length();
        this.tiles = new Tile[height][width];

        for (int y = 0; y < height; y++) {
            String row = layout[y];
            for (int x = 0; x < width; x++) {
                char c = row.charAt(x);
                tiles[y][x] = switch (c) {
                    case '#' -> new Tile(TileType.WALL);
                    case '.' -> new Tile(TileType.FLOOR);
                    default -> new Tile(TileType.FLOOR); // fallback
                };
            }
        }
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || y < 0 || x >= width || y >= height) return new Tile(TileType.WALL);
        return tiles[y][x];
    }

    public int getWidth() { return width; }
    public int getHeight() { return height; }
}

