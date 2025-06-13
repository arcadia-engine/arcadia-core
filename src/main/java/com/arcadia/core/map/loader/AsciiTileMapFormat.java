package com.arcadia.core.map.loader;

import com.arcadia.core.map.Tile;
import com.arcadia.core.map.TileType;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AsciiTileMapFormat implements TileMapFormat {

    @Override
    public Tile[][] load(Path path) throws IOException {
        List<String> lines = Files.readAllLines(path);

        int height = lines.size();
        int width = lines.get(0).length();
        Tile[][] tiles = new Tile[height][width];

        for (int y = 0; y < height; y++) {
            String line = lines.get(y);
            for (int x = 0; x < width; x++) {
                char c = line.charAt(x);
                tiles[y][x] = new Tile(TileType.fromSymbol(c));
            }
        }

        return tiles;
    }
}
