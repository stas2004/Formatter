package com.karakosov.pack.formatter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public class ReaderTest {

    @Test
    public void reading() throws Exception {
        Reader read = new Reader("src/test/resources/ReaderTest.java");
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
        assertEquals("StringBuilder str = new StringBuilder();" +
                "\nStringBuilder stringBuilder = new StringBuilder();\n",str.toString());

    }

    @Test (expected = Exception.class)
    public void close() throws Exception {
        Reader read = new Reader("src/test/resources/ReaderTest.java");
        read.close();
        read.reading();

    }
}