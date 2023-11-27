import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIEvent {
    private static void createAndShowGUI(){
        JFrame f = new JFrame("JFrame窗口");
        f.setSize(200,100);
        JButton btn = new JButton("按钮");
        btn.addActionListener(new MyListener());
        f.add(btn);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIEvent::createAndShowGUI);
    }
}
class MyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("用户点击了JButton按钮组件");
    }
}
