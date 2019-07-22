package com.alibaba.mq.amqp.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.alibaba.mq.amqp.constants.Constants.UTF8;


public class UserUtils {

    public static int ACCESS_FROM_USER = 0;

    /***
     *
     * Get AMQP Connection UserName
     *
     * 用户根据ak和sk登录,获取用户名的方法
     * @param ak  aliyun 用户accesskey
     * @param resourceOwnerId  接入点内的数字部分
     * @return 返回用户名称
     */
    public static String getUserName(String ak, long resourceOwnerId) {
        StringBuffer buf = new StringBuffer();
        return Base64Utils.encode(buf.append(ACCESS_FROM_USER).append(":").append(resourceOwnerId).append(":")
            .append(ak).toString());
    }

    /***
     *
     * Get AMQP Connection UserName for STSToken scenario
     *
     * 用户根据ak和sk及stsToken 登录，获取用户名的方法；
     *
     *
     *
     * @param ak  aliyun 用户accesskey
     * @param resourceOwnerId 接入点内的数字部分
     * @param stsToken       stsToken
     * @return 返回带stsToken的用户名称
     */
    public static String getUserName(String ak, long resourceOwnerId, String stsToken) {
        StringBuffer buf = new StringBuffer();
        return Base64Utils.encode(buf.append(ACCESS_FROM_USER).
            append(":").append(resourceOwnerId)
            .append(":").append(ak).append(":").
                append(stsToken).toString());
    }

    /***
     *
     * Get AMQP Connection Password for
     *
     * 根据sk和时间戳获取password
     * @param sk aliyun secrectKey
     * @return  返回password
     * @throws InvalidKeyException  异常
     * @throws NoSuchAlgorithmException 异常
     */
    public static String getPassord(String sk) throws InvalidKeyException, NoSuchAlgorithmException {
        long timestamp = System.currentTimeMillis();
        StringBuffer buf = new StringBuffer();
        String signature = HmacSHA1Utils.hamcsha1(sk.getBytes(UTF8), String.valueOf(timestamp).getBytes(UTF8));
        return Base64Utils.encode(buf.append(signature).append(":").append(timestamp).toString());
    }
}
