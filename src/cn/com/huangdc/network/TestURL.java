package cn.com.huangdc.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * 统一资源定位符
 * 可以通过url的对象，调用其方法，将此资源下载
  */

public class TestURL {
    public static void main() throws IOException {
        URL url = new URL("http://127.0.0.1?a=b");
        url.getProtocol();// 协议
        url.getHost();// 主机名
        url.getPort();// 端口
        url.getPath();// 资源文件路径
        url.getFile();// 资源文件名
        url.getRef();// 在文件中的相对位置
        url.getQuery();// url的查询名

        // 读取资源
        InputStream is = url.openStream();
        byte[] b = new byte[1024];
        int len;
        while ((len = is.read(b)) != -1) {
            String str = new String(b, 0, len);
            System.out.println(str);
        }

        is.close();

        // 输出、发送数据
        URLConnection uc = url.openConnection();
        uc.setConnectTimeout(500);
        InputStream is1 = uc.getInputStream();
        byte[] b1 = new byte[1024];
        int len1;
        while ((len1 = is.read(b1)) != -1) {
            String str = new String(b1, 0, len1);
            System.out.println(str);
        }
        OutputStream os = uc.getOutputStream();
    }
}
