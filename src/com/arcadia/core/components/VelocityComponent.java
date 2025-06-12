package com.arcadia.core.components;

import com.arcadia.core.entity.Component;

public class VelocityComponent implements Component {
    public double dx, dy;

    public VelocityComponent(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public String toString() {
        return "Velocity(" + dx + ", " + dy + ")";
    }
}