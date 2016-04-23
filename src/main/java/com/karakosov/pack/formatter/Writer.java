package com.karakosov.pack.formatter;

import com.karakosov.pack.InterfaceFormatter.IWriter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public class Writer implements IWriter {

    private FileWriter fileWriter;

    /**
     *
     * @param fileName is name of the file for writer
     * @throws IOException if there is an exception when file not found
     */
    public Writer(final String fileName) throws IOException {
        try {
            fileWriter = new FileWriter(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param out is string for writer
     * @throws IOException if there is an exception when writing
     */
    public void write(final String out) throws IOException {
        fileWriter.write(out);

    }

    /**
     * Close the stream
     */
    public void close() {
        try {
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
