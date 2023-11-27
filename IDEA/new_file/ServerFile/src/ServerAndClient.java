import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ServerAndClient {
    public static void main(String[] args) throws IOException{
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("the Server is running...");
        for(;;){
            Socket sock = ss.accept();
            System.out.println("connented from"+sock.getRemoteSocketAddress());
            Thread thread = new handle(sock);
            thread.start();
        }

    }
}
class handle extends Thread {
    Socket sock;

    public handle(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream input = this.sock.getInputStream(); OutputStream output = this.sock.getOutputStream()) {
            handle(input, output);
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ioe) {

            }
        }
        System.out.println("client disconnented");
    }
    private void handle(InputStream input,OutputStream output) throws IOException{
        BufferedReader reader = new BufferedReader((new InputStreamReader(input, StandardCharsets.UTF_8)));
        BufferedWriter writer = new BufferedWriter((new OutputStreamWriter(output,StandardCharsets.UTF_8)));
        writer.write("hello\n");
        writer.flush();
        for (;;){
            String s = reader.readLine();
            if (s.equals("bye")){
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok"+s+"\n");
            writer.flush();
        }
    }
}