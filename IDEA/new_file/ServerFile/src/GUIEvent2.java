import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.nio.file.WatchEvent;

public class GUIEvent2 {
    private static void GUI4(){
        JFrame a = new JFrame("WindowEvent");
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setSize(400,400);
        a.setLocationRelativeTo(null);
        a.setResizable(false);
        a.setVisible(true);
        JButton jButton = new JButton("JButton");
        a.add(jButton);
        jButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouseClicked=====鼠标点击");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("mousePressed=====鼠标按下");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("mouseReleased======鼠标松开");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("mouseEntered=======鼠标移入");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("mouseExited=======鼠标移出");
            }
        });
        a.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("windowOpened---窗口打开事件");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing---窗口正在关闭事件");
            }

            @Override
            public void windowClosed(WindowEvent e) {
                System.out.println("windowClosed---窗口已关闭事件");
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified---窗口图标化事件");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                System.out.println("windowDeiconified---窗口取消图标化事件");
            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("windowActivated---窗口激活事件");
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                System.out.println("windowDeactibated---窗口取消激活事件");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIEvent2::GUI4);
    }
}
