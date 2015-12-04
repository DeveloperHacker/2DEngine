package worlds;

import javax.swing.*;

public class Test extends JFrame {
    public Test(String name, TestPanel testingPanel) {
        super(name);
        setBounds(10, 10, testingPanel.width(), testingPanel.height() + 30);
        setResizable(false);
        testingPanel.setBackground(TestPanel.backgroundColor);
        this.add(testingPanel);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Test("Test 1", new _1_TestPanel(16 * 70, 9 * 70)));
    }
}