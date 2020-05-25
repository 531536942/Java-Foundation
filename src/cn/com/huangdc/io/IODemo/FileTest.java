package cn.com.huangdc.io.IODemo;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {

    @Test
    public void fileTest() {
        //        File file = new File("cd/heelo.txt");
        //        System.out.println("###");
        //        System.out.println(file.getName());
        //        System.out.println(file.getPath());
        //        System.out.println(file.getAbsoluteFile());
        //        System.out.println(file.getAbsolutePath());
        //        System.out.println(file.getParent());
        //
        //        System.out.println(file.exists());
        //
        //        Scanner sn = new Scanner(System.in);
        //        System.out.println(1);

        try {
            //新建一个文件
            File temp = File.createTempFile("temp", ".txt", new File("D:////io"));
            //若果成功
            if (temp.exists()) {
                System.out.println("ok.");
                //改名
//                if (temp.renameTo(new File("temp.txt"))) System.out.println("rename ok.");
                System.out.println(temp.getPath());
            }
        } catch (IOException e) {
            System.out.println("error");
        }
    }
}
