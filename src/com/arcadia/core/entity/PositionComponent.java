package com.arcadia.core.entity;

public class PositionComponent implements Component {
    public double x, y;

    public PositionComponent(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Position(%.2f, %.2f)", x, y);
    }
}
