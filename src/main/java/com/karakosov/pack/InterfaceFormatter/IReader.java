package com.karakosov.pack.InterfaceFormatter;

import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public interface IReader {
    char reading() throws IOException;
    void close();
}
