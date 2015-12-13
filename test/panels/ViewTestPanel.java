package panels;

import com.graphicEngine.*;
import com.abstractEngine.math.Vector;

import java.awt.*;
import java.util.*;
import java.util.List;

abstract class ViewTestPanel extends TestPanel {
    protected Frame2D frame2D;

    public ViewTestPanel(Frame2D frame2D, Screen screen) {
        super(screen);
        this.frame2D = frame2D;

        initTest();
    }

    protected void initTest() {
    }

    public void add(View view) {
        frame2D.add(view);
    }

    public static Color randColor() {
        List<Integer> rgb = new ArrayList<>(3);
        rgb.add((int) (Math.random() * 255));
        rgb.add(0);
        rgb.add(255);
        Collections.shuffle(rgb);
        return new Color(rgb.get(0), rgb.get(1), rgb.get(2));
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        frame2D.show(graphics, screen, screen.pos());
    }
}

