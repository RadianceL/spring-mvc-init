package com.landscape.common.utils.common;

import com.landscape.exceptions.basic.BusinessBasisRuntimeException;
import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

/**
 * @author eddie
 * @createTime 2019-03-03
 * @description 日期工具
 */
public class DateUtil {

    /**
     * 时间格式化规则
     */
    private final static String DATE_PATTERN = "yyyy-MM-dd";
    private final static String DATE_PATTERN_MONTH = "yyyy-MM";
    private final static String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

    /**
     * 空字符串
     */
    private static final String EMPTY_STRING = "";

    /**
     * 初始化格式化工具
     */
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATETIME_PATTERN);
    private static SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
    private static SimpleDateFormat sdfMonth = new SimpleDateFormat(DATE_PATTERN_MONTH);
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
     * DATETIME_PATTERN 格式化
     *
     * @param date
     * @return
     */
    public static synchronized String formatDateSdf(Date date) {
        if (Objects.isNull(date)) {
            return EMPTY_STRING;
        } else {
            return sdf.format(date);
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
     * 解析日期字符串 为 Date对象
     *
     * @param dateStr
     * @return
     */
    public static Date getDateByStrFormat(String dateStr) {
        return getDateByStrFormat(dateStr, DATETIME_PATTERN);
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

    public static boolean dateCompare(String date){
        LocalDate current = LocalDate.now();
        LocalDate comDate = LocalDate.parse(date , dateTimeFormatter);
        return comDate.isAfter(current);
    }

    /**
     * specifiedDay向后period天
     * @param specifiedDay      原始日期
     * @param period            偏移量
     * @return                  目标日期
     */
    public static String getSpecifiedAddOneDay(String specifiedDay, int period){
        return getSpecifiedDayBefore(specifiedDay, period);
    }

    public static void main(String[] args) {
        System.out.println(getSpecifiedAddOneDay("2019-02-05", 1));
    }

    /**
     * 获取
     * @param specifiedDay
     * @param period
     * @return
     */
    public static String getSpecifiedOneWeekAfter(String specifiedDay, int period){
        int amount = 7 * period;
        return getSpecifiedDayBefore(specifiedDay, amount);
    }


    public static String getSpecifiedOneMonthAfter(String specifiedDay, int period){
        return getSpecifiedWeekBefore(specifiedDay, period);
    }

    public static String getSpecifiedOneDayBefore(String specifiedDay){
        return getSpecifiedDayBefore(specifiedDay, -1);
    }

    public static String getSpecifiedOneWeekBefore(String specifiedDay){
        return getSpecifiedDayBefore(specifiedDay, -7);
    }

    public static String getSpecifiedOneMonthBefore(String specifiedDay){
        return getSpecifiedWeekBefore(specifiedDay, -1);
    }

    /**
     * 获得指定日期的后N天
     * @param specifiedDay
     * @return
     */
    private static String getSpecifiedDayBefore(String specifiedDay, int amount) {
        Calendar c = Calendar.getInstance();
        Date dateByStrFormat = getDateByStrFormat(specifiedDay, DATE_PATTERN);
        if (Objects.isNull(dateByStrFormat)){
            throw new BusinessBasisRuntimeException("日期格式化异常, {}", specifiedDay);
        }
        c.setTime(dateByStrFormat);
        c.add(Calendar.DATE, amount);
        return new SimpleDateFormat(DATE_PATTERN).format(c.getTime());
    }

    /**
     * 获得指定日期的前N月
     * @param specifiedDay
     * @return
     * @throws Exception
     */
    private static String getSpecifiedWeekBefore(String specifiedDay, int amount){
        Calendar c = Calendar.getInstance();
        Date dateByStrFormat = getDateByStrFormat(specifiedDay, DATE_PATTERN);
        if (Objects.isNull(dateByStrFormat)){
            throw new BusinessBasisRuntimeException("日期格式化异常, {}", specifiedDay);
        }
        c.setTime(dateByStrFormat);
        c.add(Calendar.MONTH, amount);
        return new SimpleDateFormat(DATE_PATTERN).format(c.getTime());
    }



    private static GregorianCalendar dateTimeCheck(Date date) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(date);
        return gc;
    }


    /**
     * 获取上个月日期  2019-04
     *
     * @return
     */
    public static synchronized String getBeforeMonthdate() {
        //获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdfMonth.format(calendar.getTime());
    }


    /**
     * 获取上个月的第一天
     *
     * @return
     */
    public static synchronized String getBeforeFirstMonthdate() {
        //获取当前日期
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取上个月的最后一天
     *
     * @return
     */
    public static synchronized String getBeforeLastMonthdate() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取前一天日期  yyyy-MM-dd
     * @return
     */
    public static synchronized  String getPreDay(){
        //取时间
        Date date=new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        //把日期往前减少一天
        calendar.add(Calendar.DATE,-1);
        return sdf.format(calendar.getTime());
    }

    /**
     * 获取指定年月的第一天
     *
     * @param dateStr   字符串日期
     * @param formatStr 日期格式
     * @return
     */
    public static synchronized String getFirstDayOfMonth(String dateStr, String formatStr) {
        Date date = getDateByStrFormat(dateStr, formatStr);
        if (Objects.isNull(date)){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        return sdf.format(cal.getTime());
    }


    /**
     * 获取指定年月的最后一天
     *
     * @param dateStr   字符串日期
     * @param formatStr 日期格式
     * @return
     */
    public static synchronized String getLastDayOfMonth(String dateStr, String formatStr) {
        Date date = getDateByStrFormat(dateStr, formatStr);
        if (Objects.isNull(date)){
            return null;
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        return sdf.format(cal.getTime());
    }

    /**
     * 非获取数据库当前周方法禁用，结束日期多一天，方便数据库查询
     * @param date
     * @return
     */
    public static synchronized String[] getTimeInterval(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        // 判断要计算的日期是否是周日，如果是则减一天计算周六的，否则会出问题，计算到下一周去了
        // 获得当前日期是一个星期的第几天
        int dayWeek = cal.get(Calendar.DAY_OF_WEEK);
        if (1 == dayWeek) {
            cal.add(Calendar.DAY_OF_MONTH, -1);
        }
        // System.out.println("要计算日期为:" + sdf.format(cal.getTime())); // 输出要计算日期
        // 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        // 获得当前日期是一个星期的第几天
        int day = cal.get(Calendar.DAY_OF_WEEK);
        // 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        cal.add(Calendar.DATE, cal.getFirstDayOfWeek() - day);
        String intervalBegin = sdf.format(cal.getTime());
        cal.add(Calendar.DATE, 7);
        String intervalEnd = sdf.format(cal.getTime());
        return new String[]{intervalBegin, intervalEnd};
    }

    /**
     * 传入时间是否为当前周
     * @param time
     * @return
     */
    public static boolean isThisWeek(long time) {
        Calendar calendar = Calendar.getInstance();
        int currentWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        calendar.setTime(new Date(time));
        int paramWeek = calendar.get(Calendar.WEEK_OF_YEAR);
        return paramWeek == currentWeek;
    }

    /**
     * 判断选择的日期是否是今天
     * @param time
     * @return
     */
    public static boolean isToday(String time) {
        return isThisTime(time,"yyyy-MM-dd");
    }

    /**
     * 判断选择的日期是否是本月
     * @param time
     * @return
     */
    public static boolean isThisMonth(String time) {
        return isThisTime(time,"yyyy-MM");
    }

    /**
     * 是否为当前时间
     * @param time
     * @param pattern
     * @return
     */
    private static boolean isThisTime(String time, String pattern) {
        Date date = getDateByStrFormat(time, pattern);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        //参数时间
        String param = sdf.format(date);
        //当前时间
        String now = sdf.format(new Date());
        return param.equals(now);
    }

    public synchronized static String getDateZeroClock(String time){
        Calendar cal = Calendar.getInstance();
        Date dateByStrFormat = getDateByStrFormat(time, DATE_PATTERN);
        if (Objects.isNull(dateByStrFormat)){
            throw new BusinessBasisRuntimeException("日期格式不合法，无法解析");
        }
        cal.setTime(dateByStrFormat);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date zero = cal.getTime();
        return simpleDateFormat.format(zero);
    }

    /**
     * 判断两个日期间隔多少天
     * @param startDate yyyy-MM-dd
     * @param endDate   yyyy-MM-dd
     */
    public static int differentDays(String startDate, String endDate){
        long startTime = getDateByStrFormat(startDate, DATE_PATTERN).getTime();
        long endTime = getDateByStrFormat(endDate, DATE_PATTERN).getTime();
        if(startTime > endTime){
            return -1;
        }

        Long times = endTime - startTime;
        long days = times/1000/60/60/24;
        return Integer.parseInt(days + "");
    }

    /**
     * 时间参数校验,开始时间必须小于结束时间，且时间跨度小于365天
     * @param startDate  yyyy-MM-dd
     * @param endDate    yyyy-MM-dd
     * @return true表示校验通过
     */
    public static boolean checkDateQueryParam(String startDate, String endDate){
        if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
            throw new BusinessBasisRuntimeException("无效的请求参数");
        }

        Date sDate = getDateByStrFormat(startDate, DATE_PATTERN);
        Date eDate = getDateByStrFormat(endDate, DATE_PATTERN);
        if(sDate == null || eDate == null){
            throw new BusinessBasisRuntimeException("时间格式有误");
        } else if (eDate.getTime() - sDate.getTime() < 0) {
            throw new BusinessBasisRuntimeException("结束时间必须晚于开始时间");
        } else if (eDate.getTime() - sDate.getTime() > 3600 * 1000 * 24 * 365L) {
            throw new BusinessBasisRuntimeException("时间跨度不能大于365天");
        }
        return true;
    }

    /**
     * 时间参数校验,开始时间必须小于结束时间，且时间跨度小于days天
     * @param startDate  yyyy-MM-dd
     * @param endDate    yyyy-MM-dd
     * @param days    yyyy-MM-dd
     * @return true表示校验通过
     */
    public static boolean checkDateQueryParam(String startDate, String endDate, int days){

        if (StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)) {
            throw new BusinessBasisRuntimeException("无效的请求参数");
        }

        Date sDate = getDateByStrFormat(startDate, DATE_PATTERN);
        Date eDate = getDateByStrFormat(endDate, DATE_PATTERN);
        if(sDate == null || eDate == null){
            throw new BusinessBasisRuntimeException("时间格式有误");
        } else if (eDate.getTime() - sDate.getTime() < 0) {
            throw new BusinessBasisRuntimeException("结束时间必须晚于开始时间");
        } else if (eDate.getTime() - sDate.getTime() > days * 24 * 1000 * 3600L) {
            throw new BusinessBasisRuntimeException("时间跨度不能大于" + days + "天");
        }
        return true;
    }
}
