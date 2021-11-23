package org.realtimetranslator;

import java.awt.*;

public interface ScreenCaptor {
    void startCaptureArea(Rectangle captureArea);
    void stopIfRunning();
}
