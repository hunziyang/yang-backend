package com.yang.portal.security.utils;

import com.yang.portal.core.CoreConstant;
import com.yang.portal.security.SecurityConstant;

import java.util.Random;

public class SaltUtil {

    public static String getSalt() {
        char[] chars = ("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = CoreConstant.BEGIN_INDEX; i < SecurityConstant.Salt.BASE_CYCLE; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            stringBuffer.append(aChar);
        }
        return stringBuffer.toString();
    }
}
