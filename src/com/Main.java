package com;

import com.graphicEngine.World2D;
import javafx.scene.layout.Background;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    public Main(String name) {
        super(name);
        setBounds(10, 10, World2D.WIDTH, World2D.HEIGHT);
        setResizable(false);

        JPanel editorPanel = new EditorPanel();
        editorPanel.setBackground(EditorPanel.backgroundColor);
        this.add(editorPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main("Main"));
    }
}

class EditorPanel extends JPanel {
    private World2D world = new World2D();
    private Timer paintClock;
    private ActionListener paintClockListener;
    public static final Color backgroundColor = Color.WHITE;
    public static final int repaintCycleTime = 15;

    public EditorPanel() {
        super();
        paintClockListener = timeEvent -> paint(getGraphics());
        paintClock = new Timer(repaintCycleTime, paintClockListener);
        paintClock.start();
    }

    public World2D getWorld() {
        return world;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        repaint();
        world.show(graphics);
    }
}