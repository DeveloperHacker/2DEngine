import panels.*;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Test extends JFrame {

    private final List<TestPanel> testingPanels;
    private int currentPanel;

    public Test(List<TestPanel> testingPanels, String name) {
        super(name);
        currentPanel = 0;
        if (testingPanels.size() == 0) {
            System.out.println("Error");
            System.exit(0);
        }
        this.testingPanels = testingPanels;
        addCurrentPane();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                if (keycode == KeyEvent.VK_W || keycode == KeyEvent.VK_UP) {
                    endPanel();
                }
                if (keycode == KeyEvent.VK_S || keycode == KeyEvent.VK_DOWN) {
                    beginPanel();
                }
                if (keycode == KeyEvent.VK_A || keycode == KeyEvent.VK_LEFT) {
                    prevPanel();
                }
                if (keycode == KeyEvent.VK_D || keycode == KeyEvent.VK_RIGHT) {
                    nextPanel();
                }
                addCurrentPane();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public TestPanel nextPanel() {
        ++currentPanel;
        if (currentPanel >= testingPanels.size()) {
            currentPanel = 0;
        }
        return testingPanels.get(currentPanel);
    }

    public TestPanel prevPanel() {
        --currentPanel;
        if (currentPanel < 0) {
            currentPanel = testingPanels.size() - 1;
        }
        return testingPanels.get(currentPanel);
    }

    public TestPanel beginPanel() {
        currentPanel = 0;
        return testingPanels.get(currentPanel);
    }

    public TestPanel endPanel() {
        currentPanel = testingPanels.size() - 1;
        return testingPanels.get(currentPanel);
    }

    public TestPanel currentPanel() {
        return testingPanels.get(currentPanel);
    }

    public void addCurrentPane() {
        setBounds(10, 10, currentPanel().width(), currentPanel().height() + 30);
        setResizable(false);
        setContentPane(currentPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        List<TestPanel> testingPanels = new ArrayList<>();
        testingPanels.add(new _1_AtomTestPanel(16 * 70, 9 * 70, "Gas"));
        testingPanels.add(new _2_AtomTestPanel(16 * 70, 9 * 70, "Newton balls"));
        testingPanels.add(new _3_AtomTestPanel(16 * 70, 9 * 70, "Comets"));
        testingPanels.add(new _1_ViewTestPanel(16 * 70, 9 * 70));
        testingPanels.add(new _4_ViewTestPanel(16 * 70, 9 * 70));
        testingPanels.add(new _5_ViewTestPanel(16 * 70, 9 * 70));
        testingPanels.add(new _2_ViewTestPanel(16 * 70, 9 * 70));
        testingPanels.add(new _3_ViewTestPanel(16 * 70, 9 * 70));
        SwingUtilities.invokeLater(() -> new Test(testingPanels, "Tests"));
    }
}