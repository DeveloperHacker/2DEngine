package panels;

import com.graphicEngine.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TestPanel extends JPanel {

    public static final Color backgroundColor = Color.BLACK;

    protected Screen screen;

    protected Timer paintClock;
    protected ActionListener paintClockListener;
    public static final int repaintCycleTime = 10;

    public int width() {
        return (int) (screen.width());
    }

    public int height() {
        return (int) (screen.height());
    }

    public TestPanel(Screen screen) {
        this.screen = screen;
        this.setBackground(backgroundColor);

        paintClockListener = timeEvent -> repaint();
        paintClock = new Timer(repaintCycleTime, paintClockListener);
        paintClock.start();
    }
}
