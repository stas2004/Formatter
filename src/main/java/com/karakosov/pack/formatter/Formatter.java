package com.karakosov.pack.formatter;

import com.karakosov.pack.InterfaceFormatter.IFormatter;
import com.karakosov.pack.InterfaceFormatter.IReader;
import com.karakosov.pack.InterfaceFormatter.IWriter;

import java.io.IOException;

/**
 * Created  on 26.03.16. by Stas Karakosov
 */
public class Formatter implements IFormatter {
    /**
     * Default constructor
     */
    public Formatter(){

    }
    private static final Integer VALUE = 4;

    /**
     *
     * @param read is reference variable to read the file
     * @param writer is reference variable for file recording
     */
    public void format(final IReader read, final IWriter writer) {
        char c;
        boolean flag = true;
        StringBuilder str = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder whiteSpace = new StringBuilder();

        while (flag) {
            try {
                c = read.reading();
                if (c != '\u7413') {
                    str.append(c);
                } else {
                    flag = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < str.length() - 1; i++) {
            char a = str.charAt(i);

            switch (a) {
                case '{':
                    stringBuilder.append(a);
                    stringBuilder.append(System.lineSeparator());
                    whiteSpace.append("    ");
                    if (whiteSpace.length() == VALUE) {
                        stringBuilder.append(whiteSpace);
                    } else {
                        stringBuilder.append(whiteSpace);
                    }

                    while ((str.charAt(i + 1) == '\n') || (str.charAt(i + 1) == '\r') || (str.charAt(i + 1) == ' ')) {
                        if (i + 1 < str.length()) {
                            i++;
                        } else {
                            stringBuilder.append(a);
                            break;
                        }
                    }
                    break;

                case '}':
                    stringBuilder.append(System.lineSeparator());

                    if (whiteSpace.length() != VALUE) {
                        whiteSpace.delete(VALUE, whiteSpace.length());
                        stringBuilder.append(whiteSpace);
                    }

                    stringBuilder.append(a);

                    while ((i + 1 < str.length()) && ((str.charAt(i + 1) == '\n') ||
                            (str.charAt(i + 1) == '\r') || (str.charAt(i + 1) == ' '))) {
                        if (i + 1 < str.length()) {
                            i++;
                        } else {
                            stringBuilder.append(a);
                            stringBuilder.append(System.lineSeparator());
                            break;
                        }
                    }

                    break;
                case ';':
                    stringBuilder.append(a);

                    while ((i + 1 < str.length()) && ((str.charAt(i + 1) == '\n') ||
                            (str.charAt(i + 1) == '\r') || (str.charAt(i + 1) == ' '))) {
                        if (i + 1 < str.length()) {
                            i++;
                        } else {
                            stringBuilder.append(a);
                            stringBuilder.append(System.lineSeparator());
                            stringBuilder.append(whiteSpace);

                            break;
                        }
                    }
                    break;

                default:
                    stringBuilder.append(a);
                    break;

            }

        }

        try {
            writer.write(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
