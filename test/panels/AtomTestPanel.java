package panels;

import com.graphicEngine.Model2D;
import com.graphicEngine.*;
import models.SingleElement;

import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.*;

public abstract class AtomTestPanel extends TestPanel {

    protected Timer updateClock;
    protected ActionListener updateClockListener;
    public static final int cycleTime = 10;
    protected Model2D model2D;

    public AtomTestPanel(Model2D model2D, Screen screen) {
        super(screen);
        this.model2D = model2D;

        updateClockListener = timeEvent -> model2D.update();
        updateClock = new Timer(cycleTime, updateClockListener);
        updateClock.start();

        initTest();
    }

    protected void initTest() {
    }

    public void addElement(SingleElement element) {
        model2D.addElement(element);
    }

    public static Color randColor() {
        java.util.List<Integer> rgb = new ArrayList<>(3);
        rgb.add((int) (Math.random() * 255));
        rgb.add(0);
        rgb.add(255);
        Collections.shuffle(rgb);
        return new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        model2D.drawOutline(graphics, screen, new com.abstractEngine.math.Vector());
    }
}

