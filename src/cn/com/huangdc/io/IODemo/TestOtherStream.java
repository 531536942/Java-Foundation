package cn.com.huangdc.io.IODemo;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class TestOtherStream {
    /**
     * @Description: InputStreamReader  OutputStreamWriter
     * @author huangdc
     * @date 2020/5/25 0025 10:29
     */
    @Test
    public void test1() throws IOException {
        File file = new File("file.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        File file2 = new File("file2.txt");
        FileOutputStream fos = new FileOutputStream(file2);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);

        String str;

        while((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
            bw.flush();
        }

        bw.close();
        br.close();
    }
}
