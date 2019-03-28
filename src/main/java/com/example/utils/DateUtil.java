package com.example.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Objects;

/**
 * @author 牛国凯
 * @createTime 2019-03-03
 * @description 日期工具
 */
public class DateUtil {

    /**
     * 时间格式化规则
     */
    private final static String DATE_PATTERN = "yyyy-MM-dd";
    private final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 初始化格式化工具
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_PATTERN);
    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_PATTERN, Locale.CHINESE);
    private static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATETIME_PATTERN, Locale.CHINESE);

    /**
     * DATETIME_PATTERN 格式化
     *
     * @param date
     * @return
     */
    public static synchronized String formatDate(Date date) {
        if (Objects.isNull(date)) {
            return EMPTY_STRING;
        } else {
            return simpleDateFormat.format(date);
        }
    }

    /**
     * 根据传入的dateFormat 格式化时间
     *
     * @param date
     * @param dateFormat
     * @return
     */
    public static String formatDate(Date date, String dateFormat) {
        if (Objects.isNull(date)) {
            return EMPTY_STRING;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
            return sdf.format(date);
        }
    }

    /**
     * 获取某天开始时间
     *
     * @param str
     * @return
     */
    public static String getBeginDateTimeStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return EMPTY_STRING;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(str, dateTimeFormatter);
            return dateTime.format(dateTimeFormatter);
        } catch (DateTimeParseException e) {
            try {
                LocalDate date = LocalDate.parse(str, dateFormatter);
                return date.toString().concat(" 00:00:00");
            } catch (DateTimeParseException e1) {
                try {
                    return LocalDateTime.now().format(dateTimeFormatter);
                } catch (DateTimeParseException e2) {
                    return EMPTY_STRING;
                }
            }
        }
    }

    /**
     * 获取某天开始时间 重载
     *
     * @param date
     * @return
     */
    public static String getBeginDateTimeStr(LocalDate date) {
        return date.format(dateFormatter).concat(" 00:00:00");
    }

    /**
     * 获取某天结束时间
     *
     * @param str
     * @return
     */
    public static String getEndDateTimeStr(String str) {
        if (StringUtils.isEmpty(str)) {
            return EMPTY_STRING;
        }
        try {
            LocalDateTime dateTime = LocalDateTime.parse(str, dateTimeFormatter);
            return dateTime.format(dateTimeFormatter);
        } catch (DateTimeParseException e) {
            try {
                LocalDate date = LocalDate.parse(str, dateFormatter);
                return date.toString().concat(" 23:59:59");
            } catch (DateTimeParseException e1) {
                try {
                    return LocalDateTime.now().format(dateTimeFormatter);
                } catch (DateTimeParseException e2) {
                    return EMPTY_STRING;
                }
            }
        }
    }

    /**
     * 获取某天结束时间 重载
     *
     * @param date
     * @return
     */
    public static String getEndDateTimeStr(LocalDate date) {
        return date.format(dateFormatter).concat(" 23:59:59");
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @param formatStr
     * @return
     */
    private static String formatDate(Long dateTime, String formatStr) {
        String format = StringUtils.isEmpty(formatStr) ? DATETIME_PATTERN : formatStr;
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(dateTime);
    }

    /**
     * 当前时间
     *
     * @return
     */
    public static String nowTime() {
        return formatDate(System.currentTimeMillis(), DATETIME_PATTERN);
    }

    /**
     * 当前时间 使用formatStr格式化
     *
     * @param formatStr
     * @return
     */
    public static String nowTime(String formatStr) {
        return formatDate(System.currentTimeMillis(), formatStr);
    }

    /**
     * 解析日期字符串 为 Date对象
     *
     * @param dateStr
     * @param formatStr
     * @return
     */
    public static Date getDateByStrFormat(String dateStr, String formatStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return null;
        }
        if (StringUtils.isEmpty(formatStr)) {
            formatStr = DATETIME_PATTERN;
        }
        try {
            DateFormat format = new SimpleDateFormat(formatStr);
            return format.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 通过Date 获取dateStr
     *
     * @param date
     * @param formatStr
     * @return
     */
    public static String getDateStrByDateFormat(Date date, String formatStr) {
        if (date == null) {
            return null;
        }
        if (StringUtils.isEmpty(formatStr)) {
            formatStr = DATETIME_PATTERN;
        }
        try {
            DateFormat format = new SimpleDateFormat(formatStr);
            return format.format(date);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 添加一年
     *
     * @param date
     * @param years
     * @return
     */
    public static Date addYear(Date date, Integer years) {
        if (Objects.isNull(date) || Objects.isNull(years) || years == 0) {
            return null;
        }
        GregorianCalendar gc = dateTimeCheck(date);
        gc.add(GregorianCalendar.YEAR, years);
        return gc.getTime();
    }

    /**
     * 添加一个月
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addMonth(Date date, Integer months) {
        if (Objects.isNull(date) || Objects.isNull(months) || months == 0) {
            return null;
        }
        GregorianCalendar gc = dateTimeCheck(date);
        gc.add(GregorianCalendar.MONTH, months);
        return gc.getTime();
    }

    /**
     * 添加一天
     *
     * @param date
     * @param days
     * @return
     */
    public static Date addDay(Date date, Integer days) {
        if (Objects.isNull(date) || Objects.isNull(days) || days == 0) {
            return null;
        }
        GregorianCalendar gc = dateTimeCheck(date);
        gc.add(GregorianCalendar.DATE, days);
        return gc.getTime();
    }

    private static GregorianCalendar dateTimeCheck(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc;
    }
}
