package com.arcadia.core.entity;

public class PositionComponent extends Component {
    public int x, y;

    public PositionComponent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Position(" + x + ", " + y + ")";
    }
}
