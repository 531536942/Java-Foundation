
package cn.com.huangdc.io.IODemo;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestFileInputOutputStream {


    @Test
    public void fileInputOutputStream() throws IOException {
        File file1 = new File("file.txt");
        File file2 = new File("file3.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] b = new byte[20];
        int len;
        while ((len = fis.read(b)) != -1) {
            fos.write(b, 0, len);
        }
        fos.close();

    }

    @Test
    public void fileOutputStream() throws IOException {
        File file = new File("file2.txt");

        FileOutputStream fos = new FileOutputStream(file);
        fos.write(new String("i love you").getBytes());
        fos.close();

    }

    /**
     * @Description: 字节数组读取文件
     * @author huangdc
     * @date 2020/5/22 0022 17:16
     */
    @Test
    public void fileInputStream1() throws IOException {
        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] b = new byte[20];
        int len;
        while((len = fis.read(b)) != -1){// 读入到b
            for (int i = 0; i < len; i++) {
                System.out.print((char)b[i]);
            }
            System.out.println();
        }

        fis.close();
    }

    /**
     * @Description: 单字节读取文件
     * @author huangdc
     * @date 2020/5/22 0022 17:16
     */
    @Test
    public void fileInputStream() throws IOException {
        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
//        int b = fis.read();
//        while(b != -1){
//            System.out.println((char)b);
//            b = fis.read();
//        }
        int b;
        while((b = fis.read()) != -1){
            System.out.println((char)b);
        }
        fis.close();
    }
}
