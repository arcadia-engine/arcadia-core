package com.arcadia.core.map.loader;

import com.arcadia.core.map.Tile;

import java.io.IOException;
import java.nio.file.Path;

public interface TileMapFormat {
    Tile[][] load(Path path) throws IOException;
}
