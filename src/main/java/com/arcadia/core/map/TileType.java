package com.arcadia.demo.map;

public enum TileType {
    FLOOR('.', true),
    WALL('#', false);

    public final char symbol;
    public final boolean isWalkable;

    TileType(char symbol, boolean isWalkable) {
        this.symbol = symbol;
        this.isWalkable = isWalkable;
    }
}
