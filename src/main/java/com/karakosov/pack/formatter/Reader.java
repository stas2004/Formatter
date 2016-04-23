package com.karakosov.pack.formatter;

import com.karakosov.pack.InterfaceFormatter.IReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 * Class reading data of file in stream and return one char of the stream
 */
public class Reader implements IReader {

    private BufferedReader in;

    /**
     *
     * @param fileName is name of the file for reader
     */
    public Reader(final String fileName) {

        File file = new File(fileName);
        try {
            in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     * @return char of file. If the symbol is '\u7413'  to finish reading a file
     * @throws IOException if there is an exception when reading
     */
    public char reading() throws IOException {
        char c;
        int a = in.read();
        if (a  == -1) {
            c = '\u7413';
        } else {
            c = (char) a;
        }
       return c;
    }

    /**
     * Close the stream
     */
    public void close() {
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
