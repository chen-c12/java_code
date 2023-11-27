import javax.swing.*;
import java.awt.*;

public class GUIvoid1 {
    private static void GUI(){
        JFrame jFrame = new JFrame("title");
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(1000,1000);
        jFrame.setLocation(200,200);
        jFrame.add(new JButton("PAGE_START"),BorderLayout.PAGE_START);
        jFrame.add(new JButton("PAGE_END"),BorderLayout.PAGE_END);
        jFrame.add(new JButton("LINE_START"),BorderLayout.LINE_START);
        jFrame.add(new JButton("LINE_END"),BorderLayout.LINE_END);
        jFrame.add(new JButton("CENTER"),BorderLayout.CENTER);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIvoid1::GUI);
    }
}
