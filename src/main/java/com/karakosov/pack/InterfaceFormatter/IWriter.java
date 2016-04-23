package com.karakosov.pack.InterfaceFormatter;

import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public interface IWriter {
    void write(String out) throws IOException;
    void close();
}
