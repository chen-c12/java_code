import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class SocketServer {
    public static void main(String[] args)throws IOException{
        ServerSocket socket = new ServerSocket(6666);
        System.out.println("正在运行中");
        for (;;){
            Socket socket1 = socket.accept();
            System.out.println("端口号为:"+socket1.getRemoteSocketAddress());
            Thread thread = new First(socket1);
            thread.start();

        }
    }
}

class First extends Thread{
    Socket socket;
    public First(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try(InputStream input = this.socket.getInputStream()){
            try(OutputStream output = this.socket.getOutputStream()){
                first(input,output);
                }
            }catch (Exception e){
                try {
                    socket.close();
                }catch (IOException ioe){
                }
            }
            System.out.println("client disconnents");
        }
    private void first(InputStream input,OutputStream output)throws IOException{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8));
        writer.write("输入");
        writer.flush();
        for(;;){
            String s = reader.readLine();
            if (s.equals("退出")){
                this.socket.close();
            }
            writer.write("输入文字为"+s);
            writer.flush();
        }
    }
}