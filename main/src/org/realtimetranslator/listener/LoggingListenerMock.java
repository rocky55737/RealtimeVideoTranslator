package org.realtimetranslator.listener;

import org.realtimetranslator.CaptureListener;

import java.awt.image.BufferedImage;

public class LoggingListenerMock implements CaptureListener {


    @Override
    public void onImageCapture(BufferedImage image) {
        System.out.println("Image size: " + image.getWidth() + " x " + image.getHeight());
    }
}
