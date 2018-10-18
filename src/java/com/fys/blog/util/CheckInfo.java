package com.fys.blog.util;

/**
 * 辅助类，检查信息是否合格
 */
public class CheckInfo {
    public static boolean isNullOrWhile(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }
        return false;
    }
}