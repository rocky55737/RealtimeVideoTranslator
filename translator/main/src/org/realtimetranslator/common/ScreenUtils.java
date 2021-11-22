package org.realtimetranslator.common;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenUtils {

    private static Robot robot;

    static {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static Rectangle getFullScreenBound() {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            bounds.add(gd.getDefaultConfiguration().getBounds());
        }
        return bounds;
    }

    public static BufferedImage takeScreenShot(Rectangle rectangle) {
        return robot.createScreenCapture(rectangle);
    }
}
