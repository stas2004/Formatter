package com.karakosov.pack.formatter;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public class FormatterTest {

    @Test
    public void format() throws Exception {
        Reader read = new Reader("src/test/resources/FormatterTestRead.java");
        Writer writer = new Writer("src/test/resources/FormatterTestWrite.java");
        Formatter formatter = new Formatter();
        formatter.format(read, writer);
        read.close();
        writer.close();

        Reader reads = new Reader("src/test/resources/FormatterTestWrite.java");
        char c;
        boolean flag = true;
        StringBuilder str = new StringBuilder();
        while (flag) {
            c = reads.reading();
            if (c != '\u7413') {
                str.append(c);
            } else {
                flag = false;
            }
        }
        reads.close();
        assertEquals(str.toString(),"while (flag) {\n" + "    try {\n" +
                "        if ((c = read.reading()) != bbbbb'\\u7413');\n" + "    }\n" +"}");

    }
}