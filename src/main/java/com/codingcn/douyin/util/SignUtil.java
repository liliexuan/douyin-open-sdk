package com.codingcn.douyin.util;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * 加签验签工具类
 *
 * @author liexuan
 * @date 2023-05-17 10:51
 **/
public class SignUtil {


    /**
     * 签名工具类
     *
     * @param privateKeyStr 私钥
     * @param method        请求方式
     * @param uri           请求URI
     * @param timestamp     时间戳
     * @param nonce         随机字符串
     * @param body          如果有body的body
     * @return String 签名
     * @throws Exception
     */
    public static String getSignature(String privateKeyStr, String method, String uri, long timestamp, String nonce, String body) throws Exception {
        //method内容必须大写，如GET、POST，uri不包含域名，必须以'/'开头
        String rawStr = method + "\n" + uri + "\n" + timestamp + "\n" + nonce + "\n" + body + "\n";
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initSign(SignUtil.toPrivateKey(privateKeyStr));
        sign.update(rawStr.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(sign.sign());
    }

    private static PrivateKey toPrivateKey(String privateKeyStr) {
        PrivateKey prvKey = null;
        try {
            byte[] privateBytes = Base64.getDecoder().decode(privateKeyStr);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            prvKey = keyFactory.generatePrivate(keySpec);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return prvKey;
    }


    public static boolean verify(String httpBody, String publicKey, String signStr, Long timestamp, String nonce) throws Exception {
        StringBuffer buffer = new StringBuffer();
        buffer.append(timestamp).append("\n");
        buffer.append(nonce).append("\n");
        buffer.append(httpBody).append("\n");
        String message = buffer.toString();
        Signature sign = Signature.getInstance("SHA256withRSA");
        sign.initVerify(SignUtil.toPublicKey(publicKey));
        sign.update(message.getBytes(StandardCharsets.UTF_8));
        return sign.verify(Base64.getDecoder().decode(signStr.getBytes(StandardCharsets.UTF_8)));
    }


    private static PublicKey toPublicKey(String publicKeyStr) throws Exception {
        byte[] decoded = Base64.getDecoder().decode(publicKeyStr);
        return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
    }

}
