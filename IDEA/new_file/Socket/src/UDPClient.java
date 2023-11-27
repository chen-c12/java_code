import java.io.IOException;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket ds= new DatagramSocket();
        ds.setSoTimeout(1000);
        ds.connect(InetAddress.getByName("localhost"),6666);
        byte[] data = "Hello".getBytes();
        DatagramPacket packet = new DatagramPacket(data,data.length);
        ds.send(packet);
        byte[] buffer = new byte[1024];
        packet = new DatagramPacket(buffer,buffer.length);
        ds.receive(packet);
        String resp = new String(packet.getData(),packet.getOffset(),packet.getLength());
        ds.disconnect();



    }
}
