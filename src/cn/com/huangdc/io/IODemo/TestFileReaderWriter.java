
package cn.com.huangdc.io.IODemo;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReaderWriter {

    @Test
    public void testFileReaderWriter() throws IOException {
        File red = new File("file.txt");
        File wri = new File("file2.txt");
        FileReader fileReader = new FileReader(red);
        FileWriter fileWriter = new FileWriter(wri);

        char[] c = new char[24];
        int len;
        while ((len = fileReader.read(c)) != -1) {
            String str = new String(c, 0, len);
            fileWriter.write(str);
            System.out.println(str);
        }
        fileReader.close();
        fileWriter.close();
    }

}
