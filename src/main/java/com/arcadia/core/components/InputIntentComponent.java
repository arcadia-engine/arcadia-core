package com.arcadia.core.components;

import com.arcadia.core.entity.Component;

public class InputIntentComponent implements Component {
    public int moveX = 0;
    public int moveY = 0;

    public void clear() {
        moveX = 0;
        moveY = 0;
    }
}
