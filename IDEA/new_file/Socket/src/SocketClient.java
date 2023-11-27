import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("localhost",6666);
        try(InputStream input = socket.getInputStream();OutputStream output = socket.getOutputStream()){
            handle1(input,output);
        }catch (Exception e){
            e.printStackTrace();
        }
        socket.close();
        System.out.println("disconnent client");
    }


    private static void handle1(InputStream input,OutputStream output) throws IOException{
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output,StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input,StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server]"+reader.readLine());
        for (;;){
            System.out.print(">>> "); // 打印提示
            String s = scanner.nextLine(); // 读取一行输入
            writer.write(s);
            writer.newLine();
            writer.flush();
            String resp = reader.readLine();
            System.out.println("<<< " + resp);
            if (resp.equals("bye")) {
                break;
            }
        }
    }
}
