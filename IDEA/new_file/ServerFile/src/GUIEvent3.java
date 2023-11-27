import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUIEvent3 {
    private static void GUI(){
        JFrame jFrame = new JFrame("键盘");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(400,300);
        jFrame.setLocationRelativeTo(null);
        JTextField jf = new JFormattedTextField(30);
        jFrame.add(jf);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                char keyChar = e.getKeyChar();
                int keyCode = e.getKeyCode();
                System.out.print("键盘按下的字符内容为:"+keyChar+" ");
                System.out.println("键盘按下的字符代码为："+keyCode);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIEvent3::GUI);
    }
}
