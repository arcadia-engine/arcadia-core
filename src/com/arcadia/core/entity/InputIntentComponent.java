package com.arcadia.core.entity;

public class InputIntentComponent implements Component {
    public double moveX = 0;
    public double moveY = 0;

    public InputIntentComponent() {
    }

    public InputIntentComponent(double moveX, double moveY) {
        this.moveX = moveX;
        this.moveY = moveY;
    }

    public void clear() {
        moveX = 0;
        moveY = 0;
    }

    @Override
    public String toString() {
        return "InputIntent(" + moveX + ", " + moveY + ")";
    }
}