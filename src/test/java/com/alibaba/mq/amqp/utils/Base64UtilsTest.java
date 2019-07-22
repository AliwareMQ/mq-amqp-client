package com.alibaba.mq.amqp.utils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author - chugang.cg
 * @create - 2019-07-19
 */
public class Base64UtilsTest {

    @Test
    public void decode() {
        String t1 = Base64Utils.encode("0:182939381:akbjai191");
        assertEquals(Base64Utils.decode(t1), Base64Utils.decodeV2(t1));

        String t2 = Base64Utils.encode("你好，世界");
        assertEquals(Base64Utils.decode(t2), Base64Utils.decodeV2(t2));
    }

    @Test
    public void encode() {
        assertEquals(Base64Utils.encode("hello"), Base64Utils.encodeV2("hello"));
        assertEquals(Base64Utils.encode("你好，世界"), Base64Utils.encodeV2("你好，世界"));
        assertEquals(Base64Utils.encode("0:182939381:akbjai191"), Base64Utils.encodeV2("0:182939381:akbjai191"));
        assertEquals(Base64Utils.encode(""), Base64Utils.encodeV2(""));
        assertEquals(Base64Utils.encode("    "), Base64Utils.encodeV2("    "));
    }
}