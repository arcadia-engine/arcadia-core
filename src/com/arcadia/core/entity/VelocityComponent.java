package com.arcadia.core.entity;

public class VelocityComponent extends Component {
    public int dx, dy;

    public VelocityComponent(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    @Override
    public String toString() {
        return "Velocity(" + dx + ", " + dy + ")";
    }
}