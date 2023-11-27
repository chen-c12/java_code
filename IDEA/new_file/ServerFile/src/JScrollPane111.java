import javax.swing.*;
import java.awt.*;

public class JScrollPane111 {
    private static void GUI(){
        JFrame jFrame = new JFrame("Panel");
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);
        jFrame.setSize(600,600);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jScrollPane.setVerticalScrollBarPolicy(22);
        JPanel jPanel = new JPanel();
        JOptionPane jOptionPane = new JOptionPane("弹窗");
        jPanel.add(new JButton("第一个按钮"));
        jPanel.add(new JButton("第二个按钮"));
        jPanel.add(new JButton("第三个按钮"));
        jPanel.add(new JButton("第四个按钮"));
        jPanel.add(jOptionPane);
        jScrollPane.setViewportView(jPanel);
        jFrame.add(jScrollPane,BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(JScrollPane111::GUI);
    }
}
