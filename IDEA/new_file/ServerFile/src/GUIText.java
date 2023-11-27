import javax.swing.*;
import java.awt.*;

public class GUIText {
    private static void GUI(){
        JFrame jFrame = new JFrame("文本框");
        jFrame.setLayout(new BorderLayout());
        jFrame.setSize(400,300);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);
        JTextArea jTextArea = new JTextArea(12,34);
        jTextArea.setEditable(false);
        JScrollPane jScrollPane = new JScrollPane(jTextArea);
        JPanel jPanel = new JPanel();
        JTextField jTextField = new JTextField(20);
        JLabel jLabel = new JLabel("聊天信息");
        JButton jButton = new JButton("发送");
        jButton.addActionListener(e->{
            String content = jTextField.getText();
            if (content != null && !content.trim().equals("")){
                jTextArea.append("本人输入信息："+content+"\n");
            }else {
                jTextArea.append("输入信息不能为空！！"+"\n");
            }
            jTextField.setText("");
        });
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        jFrame.add(jScrollPane,BorderLayout.PAGE_START);
        jFrame.add(jPanel,BorderLayout.PAGE_END);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUIText::GUI);
    }
}
