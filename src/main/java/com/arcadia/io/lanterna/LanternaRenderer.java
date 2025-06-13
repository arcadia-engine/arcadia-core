package com.arcadia.io.lanterna;

import com.arcadia.core.io.Renderer;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.graphics.TextGraphics;


public class LanternaRenderer implements Renderer {
    private final Screen screen;

    public LanternaRenderer(Screen screen) {
        this.screen = screen;
    }

    @Override
    public void render(char[][] buffer) {
        try {
            screen.clear(); // 🧼 clear previous frame!
        } catch (Exception e) {
            throw new RuntimeException("Failed to clear screen", e);
        }

        TextGraphics tg = screen.newTextGraphics();
        for (int y = 0; y < buffer.length; y++) {
            for (int x = 0; x < buffer[y].length; x++) {
                tg.setCharacter(x, y, buffer[y][x]);
            }
        }

        try {
            screen.refresh();
        } catch (Exception e) {
            throw new RuntimeException("Failed to refresh screen", e);
        }
    }

}
