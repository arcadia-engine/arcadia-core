package com.arcadia.demo;

import com.arcadia.core.engine.ArcadiaApp;
import com.arcadia.core.io.InputProvider;
import com.arcadia.core.io.Renderer;
import com.arcadia.io.lanterna.LanternaInputProvider;
import com.arcadia.io.lanterna.LanternaRenderer;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

public class DemoMain {
    public static void main(String[] args) {
        Screen screen = null;

        try {
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory()
                .setInitialTerminalSize(new TerminalSize(80, 24))
                .setTerminalEmulatorTitle("Arcadia Engine")
                .setPreferTerminalEmulator(true);

            screen = terminalFactory.createScreen();
            screen.startScreen();

            Renderer renderer = new LanternaRenderer(screen);
            InputProvider input = new LanternaInputProvider(screen);

            ArcadiaApp app = new ArcadiaApp()
                .setRenderer(renderer)
                .setInputProvider(input)
                .setInitialScene(new DemoScene(renderer, input))
                .setFPS(60);

            app.start();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (screen != null) {
                try {
                    screen.stopScreen();
                } catch (Exception ignored) {}
            }
        }
    }
}
