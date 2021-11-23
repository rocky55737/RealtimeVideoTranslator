package org.realtimetranslator.setting;

import org.realtimetranslator.ScreenCaptor;
import org.realtimetranslator.ScreenSettingUI;
import org.realtimetranslator.common.ScreenUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultScreenSettingUI implements ScreenSettingUI {
    private final ScreenCaptor captor;

    public DefaultScreenSettingUI(ScreenCaptor captor) {
        this.captor = captor;
    }

    @Override
    public void startUI() {
        EventQueue.invokeLater(() -> {
            setLookAndFeels();
            startJFrame();
        });
    }

    private void setLookAndFeels() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) { }
    }

    private void startJFrame() {
        JFrame frame = new JFrame("Select Screen");
        frame.setUndecorated(true);
        frame.setBackground(new Color(100, 100, 100, 100));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        CapturePane pane = new CapturePane(captor);
        Rectangle bounds = ScreenUtils.getFullScreenBound();
        frame.setLocation(bounds.getLocation());
        frame.setSize(bounds.getSize());
        pane.setSize(bounds.getSize());
        frame.add(pane);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    static class CapturePane extends JPanel {
        private final CaptureMouseEventListener listener;

        public CapturePane(ScreenCaptor captor) {
            setOpaque(false);
            this.setBackground(new Color(0,0,0,0));
            listener = new CaptureMouseEventListener(captor);
            this.addMouseListener(listener);
            this.addMouseMotionListener(listener);
        }

        @Override
        public void paint(Graphics g) {
            paintComponents(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(new Color(0,0,0,125));
            removeRectangles(g2d, listener.getLegacyBound());
            drawRectangle(g2d, listener.getSelectionBound());
            g2d.dispose();
        }

        private void drawRectangle(Graphics2D g2d, Rectangle selectionBounds) {
            if (selectionBounds != null)
                g2d.draw(selectionBounds);
        }

        private void removeRectangles(Graphics2D g2d, Rectangle selectionBounds) {
            if (selectionBounds != null) {
                int removePadding = 10; //딱 맞게 지우면 안지워지는 경우가 존재함
                g2d.clearRect(selectionBounds.x, selectionBounds.y,
                        selectionBounds.width + removePadding, selectionBounds.height + removePadding);
            }
        }

    }

    static class CaptureMouseEventListener extends MouseAdapter {

        private Rectangle selectionBounds;
        private Rectangle legacyBounds;
        private Point clickPoint;
        private final ScreenCaptor captor;

        public CaptureMouseEventListener(ScreenCaptor captor) {
            this.captor = captor;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            clickPoint = e.getPoint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            captor.startCaptureArea(selectionBounds);
            clearSelection();
            SwingUtilities.getWindowAncestor(e.getComponent()).setVisible(false);
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            legacyBounds = selectionBounds;
            selectionBounds = calculateSelectionBounds(clickPoint, e.getPoint());
            e.getComponent().repaint();
        }


        public Rectangle getSelectionBound() {
            return this.selectionBounds;
        }

        public Rectangle getLegacyBound() {
            return this.legacyBounds;
        }

        private Rectangle calculateSelectionBounds(Point clickPoint, Point dragPoint) {
            int x = Math.min(clickPoint.x, dragPoint.x);
            int y = Math.min(clickPoint.y, dragPoint.y);
            int width = Math.max(clickPoint.x - dragPoint.x, dragPoint.x - clickPoint.x);
            int height = Math.max(clickPoint.y - dragPoint.y, dragPoint.y - clickPoint.y);
            return new Rectangle(x, y, width, height);
        }

        private void clearSelection() {
            this.legacyBounds = null;
            this.selectionBounds = null;
            this.clickPoint = null;
        }
    }
}
