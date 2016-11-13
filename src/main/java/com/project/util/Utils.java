package com.project.util;

import java.io.UnsupportedEncodingException;
import java.util.zip.CRC32;

/**
 * Created by MINH THANG on 2/3/2016.
 */
public class Utils {
    public static long crc32(String url) {
        String crc32 = "";
        try {
            crc32 = java.net.URLDecoder.decode(url, "UTF-8").split("\\?")[0].split("#")[0].split("&")[0];
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        CRC32 crc = new CRC32();

        crc.update(crc32.getBytes());
        long output = crc.getValue();
        System.out.println(output);
        return output;
    }
}
