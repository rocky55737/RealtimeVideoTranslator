package org.realtimetranslator.captor;

import org.realtimetranslator.CaptureListener;
import org.realtimetranslator.ScreenCaptor;
import org.realtimetranslator.common.ScreenUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;
import java.util.concurrent.*;

public class DefaultScreenCaptor implements ScreenCaptor {

    private final ScheduledExecutorService service;
    private final List<CaptureListener> listeners;
    private final long delayTs;
    private ScheduledFuture<?> taskFuture;

    public DefaultScreenCaptor(ScheduledExecutorService threadPool,
                               List<CaptureListener> listener, long delayTs) {
        this.service = threadPool;
        this.listeners = listener;
        this.delayTs = delayTs;
    }

    @Override
    public void startCaptureArea(Rectangle captureArea) {
        Runnable screenShotTask = () -> {
            try {
                BufferedImage capture = ScreenUtils.takeScreenShot(captureArea);
                for (CaptureListener listener : listeners)
                    listener.onImageCapture(capture);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        this.taskFuture = service.scheduleWithFixedDelay(screenShotTask,
                0L,delayTs, TimeUnit.MILLISECONDS);
    }

    @Override
    public void stopIfRunning() {
        if (taskFuture != null && !taskFuture.isDone()) {
            taskFuture.cancel(true);
            taskFuture = null;
        }
    }

}
