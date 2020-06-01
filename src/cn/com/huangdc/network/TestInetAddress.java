package cn.com.huangdc.network;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {

    @Test
    public void test () throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();
        System.out.println(inetAddress);
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        System.out.println(byName);
    }
}
