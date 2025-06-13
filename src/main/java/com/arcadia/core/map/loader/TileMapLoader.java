package com.arcadia.core.map.loader;

import com.arcadia.core.map.Tile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class TileMapLoader {

    private static final Map<String, TileMapFormat> formats = Map.of(
        "txt", new AsciiTileMapFormat()
        // Add: "json", "tmx", etc.
    );

    public static Tile[][] load(Path path) throws IOException {
        String ext = getExtension(path.getFileName().toString());
        TileMapFormat format = formats.get(ext);
        if (format == null) {
            throw new IllegalArgumentException("Unsupported tile map format: " + ext);
        }
        return format.load(path);
    }

    private static String getExtension(String filename) {
        int i = filename.lastIndexOf('.');
        return (i >= 0) ? filename.substring(i + 1).toLowerCase() : "";
    }
}
