package com.alibaba.mq.amqp.utils;

import org.junit.Test;

import java.io.IOException;

import static com.alibaba.mq.amqp.constants.Constants.UTF8;
import static org.junit.Assert.assertEquals;

/**
 * @author - typeorigin
 * @create - 2019-07-19
 */
public class Base64UtilsTest {

    @Test
    public void decode() {
        String t1 = Base64Utils.encode("0:182939381:akbjai191");
        String result1;
        try {
            result1 = new String(net.iharder.Base64.decode(t1), UTF8);
        } catch (IOException e1) {
            throw new IllegalArgumentException("Decoding input string exception", e1);
        }
        assertEquals(Base64Utils.decode(t1), result1);

        String t2 = Base64Utils.encode("你好，世界");
        String result;
        try {
            result = new String(net.iharder.Base64.decode(t2), UTF8);
        } catch (IOException e) {
            throw new IllegalArgumentException("Decoding input string exception", e);
        }
        assertEquals(Base64Utils.decode(t2), result);
    }

    @Test
    public void encode() {
        assertEquals(Base64Utils.encode("hello"), net.iharder.Base64.encodeBytes("hello".getBytes(UTF8)));
        assertEquals(Base64Utils.encode("你好，世界"), net.iharder.Base64.encodeBytes("你好，世界".getBytes(UTF8)));
        assertEquals(Base64Utils.encode("0:182939381:akbjai191"), net.iharder.Base64.encodeBytes("0:182939381:akbjai191".getBytes(UTF8)));
        assertEquals(Base64Utils.encode(""), net.iharder.Base64.encodeBytes("".getBytes(UTF8)));
        assertEquals(Base64Utils.encode("    "), net.iharder.Base64.encodeBytes("    ".getBytes(UTF8)));
    }
}