package com.longxw.library.uitl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author longxw
 * @since 2020/4/10
 */
public class FileUtils {

    public static String readBytesAsString(InputStream is) throws IOException {
        return readBytesAsString(is, StandardCharsets.UTF_8);
    }

    public static String readBytesAsString(InputStream is, Charset charset) throws IOException {
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        return new String(bytes, charset);
    }
}
