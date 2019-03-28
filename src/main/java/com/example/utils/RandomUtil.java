package com.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 牛国凯
 * @createTime 2019-03-12
 * @description 获取随机数
 */
public class RandomUtil {

    private static final Pattern pattern = Pattern.compile("[^0-9]");

    /**
     * 获取随机数
     *
     * @param length
     * @return
     */
    public static Integer getRandomNumber(Integer length) {
        Double rand = Math.random();
        Double arg = Math.pow(10, length);
        Double result = Math.floor(rand * arg);
        return result.intValue();
    }

    /**
     * 获取随机数
     *
     * @param length
     * @return
     */
    public static String getRandomNumberString(Integer length) {
        return formatNumber(getRandomNumber(length), length);
    }

    /**
     * 格式化数字
     *
     * @param value
     * @param length
     * @return
     */
    private static String formatNumber(Integer value, Integer length) {
        if (value == null) {
            value = 0;
        }
        return String.format("%0" + length + "d", value);
    }

    /**
     * 获取字符串中的数字
     *
     * @param content
     * @return
     */
    public static String getNumbers(String content) {
        if (StringUtils.isEmpty(content)) {
            return "";
        }
        Matcher matcher = pattern.matcher(content);
        return matcher.replaceAll("").trim();
    }
}
