import javax.swing.*;
import java.awt.*;

public class GUIvoid2 {
    private static void GUI2(){
        JFrame jFrame = new JFrame("title");
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER,30,30));
        jFrame.setSize(1000,1000);
        jFrame.setLocation(150,150);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(new JButton("first button"));
        jFrame.add(new JButton("22222 button"));
        jFrame.add(new JButton("33333 button"));
        jFrame.add(new JButton("44444 button"));
        jFrame.add(new JButton("55555 button"));
        jFrame.add(new JButton("66666 button"));
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIvoid2::GUI2);
    }
}
