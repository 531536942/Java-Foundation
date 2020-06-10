package cn.com.huangdc.network;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP传输
 */
public class TestUDP1 {
    @Test
    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket();
        // 每个数据包不能超过64K
        byte [] b = "你好".getBytes();
        DatagramPacket packet = new DatagramPacket(b, 0, b.length,
                InetAddress.getByName("127.0.0.1"), 9090);
        socket.send(packet);

        socket.close();
    }

    @Test
    public void server() throws IOException {
        DatagramSocket ds = new DatagramSocket(9090);
        byte[] b = new byte[3];
        DatagramPacket packet = new DatagramPacket(b, 0, b.length);
        ds.receive(packet);

        String str = new String(packet.getData(), 0, packet.getLength());
        System.out.println(str);

        ds.close();
    }
}
