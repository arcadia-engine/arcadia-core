package com.arcadia.core.engine;

import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.core.io.lanterna.LanternaInputProvider;
import com.arcadia.core.io.lanterna.LanternaRenderer;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.*;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class ArcadiaMain {
    public static void main(String[] args) {
        try {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(80, 24));
            Screen screen = terminalFactory.createScreen();
            screen.startScreen();

            Renderer renderer = new LanternaRenderer(screen);
            InputProvider input = new LanternaInputProvider(screen);

            GameLoop loop = new GameLoop(renderer, input);
            loop.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
