
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIvoid3 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.submit(new thread());
        service.shutdown();
    }
}
class thread extends Thread{
    @Override
    public void run(){
        JFrame jFrame = new JFrame("title");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(900,900);
        jFrame.setLocation(900,900);
        jFrame.setLayout(new GridLayout(3,3));
        jFrame.add(new JButton("11111111"));
        jFrame.add(new JButton("22222222"));
        jFrame.add(new JButton("33333333"));
        jFrame.add(new JButton("44444444"));
        jFrame.add(new JButton("55555555"));
        jFrame.add(new JButton("66666666"));
        jFrame.setVisible(true);
    }
}
