package com.karakosov.pack.formatter;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public class WriterTest {


    @Test
    public void write1() throws Exception {
        Writer writer = new Writer("src/test/resources/WriterTest.java");
        String s = "StringBuilder str = new StringBuilder();" +
                "\nStringBuilder stringBuilder = new StringBuilder();\n";
        writer.write(s);
        writer.close();
        Reader read = new Reader("src/test/resources/WriterTest.java");
        char c;
        boolean flag = true;
        StringBuilder str = new StringBuilder();
        while (flag) {
            c = read.reading();
            if (c != '\u7413') {
                str.append(c);
            } else {
                flag = false;
            }
        }
        read.close();

        assertEquals(str.toString(),s);

    }

    @Test (expected = Exception.class)
    public void close1() throws Exception {

        Writer writer = new Writer("src/test/resources/WriterTest.java");
        writer.close();
        writer.write("12345");
    }


}