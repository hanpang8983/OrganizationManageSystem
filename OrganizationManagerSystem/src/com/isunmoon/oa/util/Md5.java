package com.isunmoon.oa.util;
import java.security.MessageDigest;

public class Md5 {
	public final static String toMD5(String s) {
		String result = null;
        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};       
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            md.update(s.getBytes());
            // 获得密文
            byte[] b = md.digest();
            // 把密文转换成十六进制的字符串形式
            int j = b.length;
            char str[] = new char[j*2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = b[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            result = new String(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public static void main(String args[]) {
		System.out.println(toMD5("1"));
	}
}
