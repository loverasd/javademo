package com.note.mysecret;

import javax.crypto.Cipher;
import java.nio.charset.Charset;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * @Classname MySecretTest
 * @Description TODO
 * @Date 2019/6/20 20:05
 * @Created by x1c
 */
public class MySecretTest {
    private static String algorithm = "RSA";
    private static String str = "123456";
    public static void main(String[] args) throws Exception {
        String s = enStrRsa(str, null);
//        deStrRsa("[B@7e2d773b","[B@23e028a9");
    }

    public  static String enStrRsa(String str, String privateKey) throws Exception {
        KeyPairGenerator instance = KeyPairGenerator.getInstance(algorithm);
        instance.initialize(1024);
        KeyPair keyPair = instance.generateKeyPair();
        PrivateKey aPrivate = keyPair.getPrivate();
        System.out.println("private "+new String(aPrivate.getEncoded(),"UTF-8"));
        PublicKey aPublic = keyPair.getPublic();
        byte[] s1 = aPublic.getEncoded(); //
        System.out.println("public "+new String(s1,"UTF-8"));

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, aPrivate);
        byte[] s = cipher.doFinal(str.getBytes()); //[B@7e2d773b
        byte[] encode = Base64.getEncoder().encode(s); //[B@7a187f14
        System.out.println("src " + new String(s,"UTF-8"));
        System.out.println("encode "+new String(encode,"UTF-8"));
        return null;
    }

    public static String  deStrRsa(String str,String publicKey) throws Exception {
        byte[] decode = Base64.getDecoder().decode(publicKey.getBytes(Charset.forName("UTF-8")));
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(decode);
        KeyFactory instance = KeyFactory.getInstance(algorithm);
        PublicKey publicKey1 = instance.generatePublic(x509EncodedKeySpec);

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.getBlockSize();
        cipher.init(Cipher.DECRYPT_MODE, publicKey1);
        byte[] bytes = cipher.doFinal(str.getBytes());
        System.out.println(bytes);
        System.out.println(new String(bytes));
        return null;

    }
    public String encode(byte[] bytes){
        return null;
    }
}
