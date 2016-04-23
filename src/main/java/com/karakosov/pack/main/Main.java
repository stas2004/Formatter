package com.karakosov.pack.main;

import com.karakosov.pack.formatter.Formatter;
import com.karakosov.pack.formatter.Reader;
import com.karakosov.pack.formatter.Writer;

import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public final class Main {
    /**
     * Default constructor
     */
    private Main(){

 }

    /**
     *
     * @param args is argument
     * @throws IOException is exception when reading or writing

     */
    public static void main(final String[] args) throws IOException {

        Reader read = new Reader("src/main/resources/1.java");
        Writer writer = new Writer("src/main/resources/2.java");
        Formatter formatter = new Formatter();
        formatter.format(read, writer);
        read.close();
        writer.close();
    }
}
