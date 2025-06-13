package com.arcadia.core.map;

public enum TileType {
    FLOOR(true, '.'),
    WALL(false, '#');

    private final boolean walkable;
    private final char symbol;

    TileType(boolean walkable, char symbol) {
        this.walkable = walkable;
        this.symbol = symbol;
    }

    public boolean isWalkable() {
        return walkable;
    }

    public char getSymbol() {
        return symbol;
    }

    // Optional: useful for debug, loaders, etc.
    public static TileType fromSymbol(char c) {
        for (TileType type : values()) {
            if (type.symbol == c) return type;
        }
        return FLOOR; // fallback
    }
}
