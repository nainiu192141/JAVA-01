package com.nainiu192141.insertonemillion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * Created by xfx on 2021/2/28 13:49
 */
public class loadDataUtil {

    /**
     * 将字符串转成流
     * @return
     */
    public static InputStream getTestDataInputStream() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            for (int j = 0; j <= 10000; j++) {

                builder.append(4);
                builder.append("\t");
                builder.append(4 + 1);
                builder.append("\t");
                builder.append(4 + 2);
                builder.append("\t");
                builder.append(4 + 3);
                builder.append("\t");
                builder.append(4 + 4);
                builder.append("\t");
                builder.append(4 + 5);
                builder.append("\n");
            }
        }
        byte[] bytes = builder.toString().getBytes();
        InputStream is = new ByteArrayInputStream(bytes);
        return is;
    }
}
