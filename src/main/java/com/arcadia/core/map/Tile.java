package com.arcadia.core.map;

public class Tile {
    public TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public char getSymbol() {
        return type.symbol;
    }

    public boolean isWalkable() {
        return type.isWalkable;
    }
}

