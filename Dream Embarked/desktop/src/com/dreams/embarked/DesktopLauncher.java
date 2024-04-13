package com.dreams.embarked;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import main.java.embarked.Platform;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
    public static void main (String[] arg) {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        config.setForegroundFPS(60);
        // Can upscale to 1920 x 1080 or 1280 x 720 with aspect ratio kept.
        config.setWindowedMode(640, 360);
        config.setTitle("Dreams Embarked");
        new Lwjgl3Application(new Platform(), config);
    }
}
