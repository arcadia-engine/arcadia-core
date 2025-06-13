package com.arcadia.core.components;

import com.arcadia.core.entity.Component;

public class PositionComponent implements Component {
    public int x;
    public int y;

    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
