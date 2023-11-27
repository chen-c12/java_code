import javax.swing.*;

public class GUIvoid {
    private static void creatAndShowGUI() {
        JFrame jFrame = new JFrame("弹幕");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(200,200);
        jFrame.setLocation(500,500);
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIvoid::creatAndShowGUI);
    }
}
