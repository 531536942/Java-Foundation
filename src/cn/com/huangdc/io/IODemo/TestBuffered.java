package cn.com.huangdc.io.IODemo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestBuffered {

    /**
     * @Description: 使用buffer实现非文本文件的复制
     * @author Administrator
     * @date 2020/5/24 22:21
     */
    public void testBufferedInputOutputStream() throws IOException {
        File file1 = new File("src/cn/com/huangdc/io/IODemo/file/1.jpg");
        File file2 = new File("src/cn/com/huangdc/io/IODemo/file/2.jpg");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1) {
            bos.write(b,0, len);
        }

        bos.close();
        bis.close();
    }
}
