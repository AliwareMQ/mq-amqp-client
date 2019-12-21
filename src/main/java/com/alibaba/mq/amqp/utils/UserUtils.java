package com.alibaba.mq.amqp.utils;

import com.alibaba.mq.amqp.constants.Constants;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class UserUtils {
    public static int ACCESS_FROM_USER = 0;

    public UserUtils() {
    }

    public static String getUserName(String ak, String instanceId) {
        StringBuffer buf = new StringBuffer();
        return Base64Utils.encode(buf.append(ACCESS_FROM_USER).append(":").append(instanceId).append(":").append(ak).toString());
    }

    public static String getUserName(String ak, String instanceId, String stsToken) {
        StringBuffer buf = new StringBuffer();
        return Base64Utils.encode(buf.append(ACCESS_FROM_USER).append(":").append(instanceId).append(":").append(ak).append(":").append(stsToken).toString());
    }

    public static String getPassord(String sk) throws InvalidKeyException, NoSuchAlgorithmException {
        long timestamp = System.currentTimeMillis();
        StringBuffer buf = new StringBuffer();
        String signature = HmacSHA1Utils.hamcsha1(sk.getBytes(Constants.UTF8), String.valueOf(timestamp).getBytes(Constants.UTF8));
        return Base64Utils.encode(buf.append(signature).append(":").append(timestamp).toString());
    }
}
