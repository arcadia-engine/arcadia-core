package com.arcadia.core.map;

public class Tile {
    private final TileType type;

    public Tile(TileType type) {
        this.type = type;
    }

    public TileType getType() {
        return type;
    }

    public char getSymbol() {
        return type.getSymbol();
    }

    public boolean isWalkable() {
        return type.isWalkable();
    }

    // Optional future hooks
    // public String getSpriteId() { return type.getSpriteId(); }
    // public String getTag()      { return type.getTag(); }
}
