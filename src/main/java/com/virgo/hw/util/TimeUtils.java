package com.virgo.hw.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * javadoc TimeUtils 时间工具类
 *
 * @author weng xiaoyong
 * @date 2019-07-26 13:22
 * @version 1.0.0
 */
@SuppressWarnings(value = "unused")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TimeUtils {
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class Property {
        /* date time formatter layout */
        public static final String DEFAULT_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
        public static final String DEFAULT_DATE_TIME_PATTERN_NO_SECOND = "yyyy-MM-dd HH:mm";
        public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
        public static final String POINT_DEFAULT_DATE_PATTERN = "yyyy.MM.dd";
        public static final String DEFAULT_TIME_PATTERN = "HH:mm:ss";
        public static final String DEFAULT_TIME_PATTERN_1 = "HHmmss";
        public static final String POINT_FORMAT_DATE_TIME_PATTERN = "yyyy.MM.dd HH:mm";
        public static final String POINT_FORMAT_MMDD_PATTERN = "MMdd";

        /* error message */
        public static final String DEFAULT_DATE_ERROR = "local date is illegal";
        public static final String DEFAULT_TIME_ERROR = "local time is illegal";
        public static final String DEFAULT_DATE_TIME_ERROR = "local date time is illegal";
        public static final String DEFAULT_FORMATTER_ERROR = "date time formatter is illegal";


        /* formatters */
        public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter DEFAULT_DATE_TIME_PATTERN_NO_SECOND_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_PATTERN_NO_SECOND, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_PATTERN, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_PATTERN, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter POINT_DEFAULT_DATE_PATTERN_FORMATTER = DateTimeFormatter.ofPattern(POINT_DEFAULT_DATE_PATTERN, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter POINT_FORMAT__DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(POINT_FORMAT_DATE_TIME_PATTERN, Locale.SIMPLIFIED_CHINESE);
        public static final DateTimeFormatter POINT_FORMAT__DDMM_FORMATTER = DateTimeFormatter.ofPattern(POINT_FORMAT_MMDD_PATTERN, Locale.SIMPLIFIED_CHINESE);
    }

    public static long timeStamp(LocalDateTime localDateTime) {
        checkNotNull(localDateTime);
        return localDateTime.atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
    }

    public static LocalDateTime toDateTime(long timestamp) {
        return LocalDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.of("Asia/Shanghai"));
    }

    public static LocalDateTime toDateTime(String dateTime) {
        return toDateTime(dateTime, Property.DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * javadoc date
     * @apiNote
     *
     * @param formatter requires not null, otherwise runtime exception throws
     * @param date requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 13:43
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date(LocalDate date, DateTimeFormatter formatter) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return date.format(formatter);
    }

    /**
     * javadoc date
     * @apiNote date with pattern
     *
     * @param date requires not null, otherwise runtime exception throws
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:55
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date(LocalDate date, String pattern) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return date.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc date
     * @apiNote
     *
     * @param date local date, requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 13:45
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date(LocalDate date) {
        return date(date, Property.DEFAULT_DATE_FORMATTER);
    }

    /**
     * javadoc date
     * @apiNote date of now(today) with given formatter
     *
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 13:47
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date(DateTimeFormatter formatter) {
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return LocalDate.now().format(formatter);
    }

    /**
     * javadoc date
     * @apiNote
     *
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:58
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date(String pattern) {
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return LocalDate.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc date
     * @apiNote date of now(today) with default date formatter
     *
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 13:49
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String date() {
        return date(LocalDate.now(), Property.DEFAULT_DATE_FORMATTER);
    }

    /**
     * javadoc time
     * @apiNote
     *
     * @param formatter requires not null, otherwise runtime exception throws
     * @param time requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 13:52
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time(LocalTime time, DateTimeFormatter formatter) {
        checkNotNull(time, Property.DEFAULT_TIME_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return time.format(formatter);
    }

    /**
     * javadoc time
     * @apiNote time with pattern
     *
     * @param time requires not null, otherwise runtime exception throws
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 15:00
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time(LocalTime time, String pattern) {
        checkNotNull(time, Property.DEFAULT_TIME_ERROR);
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return time.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc time
     * @apiNote time of now with given formatter
     *          由于涉及生成新的time实例, 所以本层检测了参数, 且没有调用重载的time, 避免二次检查, 或者因为参数非法而导致实例生成
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:12
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time(DateTimeFormatter formatter) {
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return LocalTime.now().format(formatter);
    }

    /**
     * javadoc time
     * @apiNote time of now with pattern
     *
     * @param pattern  requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:53
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time(String pattern) {
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return LocalTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc time
     * @apiNote
     *
     * @param time requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:14
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time(LocalTime time) {
        return time(time, Property.DEFAULT_TIME_FORMATTER);
    }

    /**
     * javadoc time
     * @apiNote time of now with default time formatter
     *
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:15
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String time() {
        return time(LocalTime.now(), Property.DEFAULT_TIME_FORMATTER);
    }

    /**
     * javadoc dateTime
     * @apiNote
     *
     * @param dateTime requires not null, otherwise runtime exception throws
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:18
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTime(LocalDateTime dateTime, DateTimeFormatter formatter) {
        checkNotNull(dateTime, Property.DEFAULT_DATE_TIME_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return dateTime.format(formatter);
    }

    /**
     * javadoc dateTime
     * @apiNote date time with pattern
     *
     * @param dateTime requires not null, otherwise runtime exception throws
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:46
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTime(LocalDateTime dateTime, String pattern) {
        checkNotNull(dateTime, Property.DEFAULT_DATE_TIME_ERROR);
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return dateTime.format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc dateTime
     * @apiNote date time with default date time formatter
     *
     * @param dateTime requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:26
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTimeToStr(LocalDateTime dateTime) {
        return dateTime != null ? dateTime(dateTime, Property.DEFAULT_DATE_TIME_FORMATTER) : null;
    }

    public static String dateTimeToStrNoSecond(LocalDateTime dateTime) {
        return dateTime != null ? dateTime(dateTime, Property.DEFAULT_DATE_TIME_PATTERN_NO_SECOND_FORMATTER) : null;
    }

    /**
     * yyyy.MM.dd HH:mm
     * javadoc dateTimePointFormatToStr
     *
     * @param dateTime
     * @return java.lang.String
     * @author yachun liu
     * @date 2020/3/16 15:05
     * @modified none
     */
    public static String dateTimePointFormatToStr(LocalDateTime dateTime) {
        return dateTime != null ? dateTime(dateTime, Property.POINT_FORMAT__DATE_TIME_FORMATTER) : null;
    }

    /**
     *
     * @author: guo tao
     * @Date: 2020/5/23
     * @param dateTime:
     * @return
     **/
    public static String dateTimePointFormat(LocalDateTime dateTime) {
        return dateTime != null ? dateTime(dateTime, Property.POINT_DEFAULT_DATE_PATTERN_FORMATTER) : null;
    }

    /**
     * javadoc dateTimeDDMMFormatToStr
     * 
 * @param dateTime
     * @return java.lang.String       
     * @author yachun liu
     * @date 2020/4/14 13:21
     * @modified none       
     */
    public static String dateTimeDDMMFormatToStr(LocalDateTime dateTime) {
        return dateTime != null ? dateTime(dateTime, Property.POINT_FORMAT__DDMM_FORMATTER) : null;
    }




    /**
     * javadoc dateTime
     * @apiNote date time with default date time formatter
     *
     * @param dateTime requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:26
     * @modified none
     */
    public static String dateTime(LocalDateTime dateTime) {
        return dateTime(dateTime, Property.DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * javadoc dateTime @apiNote date time of now with given formatter
     *
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:30
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTime(DateTimeFormatter formatter) {
        checkNotNull(formatter, Property.DEFAULT_DATE_TIME_ERROR);
        return LocalDateTime.now().format(formatter);
    }

    /**
     * javadoc dateTime
     * @apiNote
     *
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:37
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTime(String pattern) {
        checkArgument(StringUtils.isNoneBlank(pattern), Property.DEFAULT_FORMATTER_ERROR);
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc dateTime
     * @apiNote date time of now with default formatter
     *
     * @return java.lang.String
     * @author weng xiaoyong
     * @date 2019-07-26 14:31
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static String dateTime() {
        return dateTime(LocalDateTime.now(), Property.DEFAULT_DATE_TIME_FORMATTER);
    }

    /**
     * javadoc toDate
     * @apiNote
     *
     * @param date requires not blank, otherwise runtime exception throws
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 15:02
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate toDate(String date, DateTimeFormatter formatter) {
        checkArgument(StringUtils.isNoneBlank(date), Property.DEFAULT_DATE_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return LocalDate.parse(date, formatter);
    }

    /**
     * javadoc toDate
     * @apiNote
     *
     * @param date requires not blank, otherwise runtime exception throws
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 15:06
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate toDate(String date, String pattern) {
        checkArgument(StringUtils.isNoneBlank(date) && StringUtils.isNoneBlank(pattern), "date or pattern is illegal");
        return LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc toDate
     * @apiNote
     *
     * @param date requires not blank, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 15:11
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate toDate(String date) {
        checkArgument(StringUtils.isNoneBlank(date), Property.DEFAULT_DATE_ERROR);
        return LocalDate.parse(date, Property.DEFAULT_DATE_FORMATTER);
    }

    /**
     * javadoc toTime
     * @apiNote
     *
     * @param time requires not blank, otherwise runtime exception throws
     * @param formatter requires not null, otherwise runtime exception throws
     * @return java.time.LocalTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:14
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalTime toTime(String time, DateTimeFormatter formatter) {
        checkArgument(StringUtils.isNoneBlank(time), Property.DEFAULT_TIME_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return LocalTime.parse(time, formatter);
    }

    /**
     * javadoc toTime
     * @apiNote
     *
     * @param time requires not blank, otherwise runtime exception throws
     * @param pattern requires not blank, otherwise runtime exception throws
     * @return java.time.LocalTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:20
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalTime toTime(String time, String pattern) {
        checkArgument(StringUtils.isNoneBlank(time) && StringUtils.isNoneBlank(pattern), "time or pattern is illegal");
        return LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * javadoc toTime
     * @apiNote
     *
     * @param time requires not blank, otherwise runtime exception throws
     * @return java.time.LocalTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:22
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalTime toTime(String time) {
        checkArgument(StringUtils.isNoneBlank(time), Property.DEFAULT_TIME_ERROR);
        return LocalTime.parse(time, Property.DEFAULT_TIME_FORMATTER);
    }

    /**
     * javadoc toTime
     * @apiNote convert seconds to a time, and make it simple to convert to string,
     *          ex: 112 seconds -> LocalTime(0, 1, 58) -> "1:58" or "1.58"
     *
     * @param seconds it must be positive, and ,less than 24 * 60 * 60
     * @return java.time.LocalTime
     * @author weng xiaoyong
     * @date 2019-07-26 18:06
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalTime toTime(int seconds) {
        checkArgument(seconds >= 0 && seconds < 24 * 60 * 60, "seconds is illegal, maybe less than 0 or bigger than 24 hours");
        int hours = seconds / 60 / 60;
        int dex = seconds % (60 * 60);
        int minutes = dex / 60;
        int second = dex % 60;
        return LocalTime.of(hours, minutes, second);
    }


    /**
     * javadoc toDateTime
     * @apiNote
     *
     * @param dateTime requires not blank, otherwise runtime exception throws
     * @param formatter requires not blank, otherwise runtime exception throws
     * @return java.time.LocalDateTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:26
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDateTime toDateTime(String dateTime, DateTimeFormatter formatter) {
        checkArgument(StringUtils.isNoneBlank(dateTime), Property.DEFAULT_DATE_TIME_ERROR);
        checkNotNull(formatter, Property.DEFAULT_FORMATTER_ERROR);
        return LocalDateTime.parse(dateTime, formatter);
    }

    /**
     * javadoc toDateTime
     * @apiNote
     *
     * @param dateTime dateTime requires not blank, otherwise runtime exception throws
     * @param pattern dateTime requires not blank, otherwise runtime exception throws
     * @return java.time.LocalDateTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:28
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDateTime toDateTime(String dateTime, String pattern) {
        checkArgument(StringUtils.isNoneBlank(dateTime) && StringUtils.isNoneBlank(pattern), "date time or pattern is illegal");
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }


    /**
     * javadoc toDateTime
     * @apiNote
     *
     * @param dateTime requires not blank, otherwise runtime exception throws
     * @return java.time.LocalDateTime
     * @author weng xiaoyong
     * @date 2019-07-26 15:31
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDateTime strToDateTime(String dateTime) {
        checkArgument(StringUtils.isNoneBlank(dateTime), Property.DEFAULT_DATE_TIME_ERROR);
        //return LocalDateTime.parse(dateTime, Property.DEFAULT_DATE_TIME_FORMATTER);
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static LocalDateTime strToDateTimeV2(String dateTime) {
        checkArgument(StringUtils.isNoneBlank(dateTime), Property.DEFAULT_DATE_TIME_ERROR);
        //return LocalDateTime.parse(dateTime, Property.DEFAULT_DATE_TIME_FORMATTER);
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("HH:mm"));
    }


    /**
     * javadoc years
     * @apiNote range year value between start and end
     *
     * @param start requires not null, otherwise runtime exception throws
     * @param end requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 15:38
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long years(LocalDateTime start, LocalDateTime end) {
        checkNotNull(start, Property.DEFAULT_DATE_TIME_ERROR);
        checkNotNull(end, Property.DEFAULT_DATE_TIME_ERROR);
        return ChronoUnit.YEARS.between(start, end);
    }

    /**
     * javadoc years
     * @apiNote range year value between start and LocalDateTime.now()
     *
     * @param start requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 15:45
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long years(LocalDateTime start) {
        checkNotNull(start, Property.DEFAULT_DATE_TIME_ERROR);
        return ChronoUnit.YEARS.between(start, LocalDateTime.now());
    }

    /**
     * javadoc years
     * @apiNote
     *
     * @param start requires not null, otherwise runtime exception throws
     * @param end requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 16:17
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long years(LocalDate start, LocalDate end) {
        checkNotNull(start, Property.DEFAULT_DATE_ERROR);
        checkNotNull(end, Property.DEFAULT_DATE_ERROR);
        return ChronoUnit.YEARS.between(start, end);
    }

    /**
     * javadoc years
     * @apiNote
     *
     * @param start requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 16:18
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long years(LocalDate start) {
        checkNotNull(start, Property.DEFAULT_DATE_ERROR);
        return ChronoUnit.YEARS.between(start, LocalDate.now());
    }

    /**
     * javadoc days
     * @apiNote
     *
     * @param start requires not null, otherwise runtime exception throws
     * @param end requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 16:22
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long days(LocalDateTime start, LocalDateTime end) {
        checkNotNull(start, Property.DEFAULT_DATE_TIME_ERROR);
        checkNotNull(end, Property.DEFAULT_DATE_TIME_ERROR);
        return ChronoUnit.DAYS.between(start, end);
    }

    /**
     * javadoc seconds
     * @apiNote 时间差（秒）
     *
     * @param start start non null
     * @param end end non null
     * @return long
     * @author wang chenkai
     * @date 2020/3/19  6:14 下午
     * @modified none
     */
    public static long seconds(LocalDateTime start, LocalDateTime end) {
        checkNotNull(start, Property.DEFAULT_DATE_TIME_ERROR);
        checkNotNull(end, Property.DEFAULT_DATE_TIME_ERROR);
        return ChronoUnit.SECONDS.between(start, end);
    }

    public static long hours(LocalDateTime start, LocalDateTime end) {
        checkNotNull(start, Property.DEFAULT_DATE_ERROR);
        return ChronoUnit.HOURS.between(start, end);
    }

    /**
     * javadoc days
     * @apiNote
     *
     * @param start requires not null, otherwise runtime exception throws
     * @return long
     * @author weng xiaoyong
     * @date 2019-07-26 16:24
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static long days(LocalDateTime start) {
        checkNotNull(start, Property.DEFAULT_DATE_TIME_ERROR);
        return ChronoUnit.DAYS.between(start, LocalDateTime.now());
    }

    /**
     * javadoc firstDayOfMonth
     * @apiNote first day of month given by date
     *
     * @param date requires not null, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:33
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate firstDayOfMonth(LocalDate date) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        return date.with(TemporalAdjusters.firstDayOfMonth());
    }

    /**
     * javadoc firstDayOfMonth
     * @apiNote first day of this month
     *
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:35
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate firstDayOfMonth() {
        return firstDayOfMonth(LocalDate.now());
    }

    /**
     * javadoc lastDayOfMonth
     * @apiNote last day of month given by date
     *
     * @param date requires not null, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:38
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate lastDayOfMonth(LocalDate date) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        return date.with(TemporalAdjusters.lastDayOfMonth());
    }

    /**
     * javadoc lastDayOfMonth
     * @apiNote last day of this month
     *
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:39
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate lastDayOfMonth() {
        return lastDayOfMonth(LocalDate.now());
    }

    /**
     * javadoc firstDayOfYear
     * @apiNote first day of year given by date
     *
     * @param date requires not null, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:42
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate firstDayOfYear(LocalDate date) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        return date.with(TemporalAdjusters.firstDayOfYear());
    }

    /**
     * javadoc firstDayOfYear
     * @apiNote first day of this year
     *
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:43
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate firstDayOfYear() {
        return firstDayOfMonth(LocalDate.now());
    }

    /**
     * javadoc lastDayOfYear
     * @apiNote last day of year given by date
     *
     * @param date requires not null, otherwise runtime exception throws
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:46
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate lastDayOfYear(LocalDate date) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        return date.with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * javadoc lastDayOfYear
     * @apiNote last day of this year
     *
     * @return java.time.LocalDate
     * @author weng xiaoyong
     * @date 2019-07-26 17:46
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDate lastDayOfYear() {
        return lastDayOfYear(LocalDate.now());
    }

    /**
     * javadoc isLeapYear
     * @apiNote 判断是否是闰年
     *
     * @param date requires not null, otherwise runtime exception throws
     * @return boolean
     * @author weng xiaoyong
     * @date 2019-07-26 17:47
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static boolean isLeapYear(LocalDate date) {
        checkNotNull(date, Property.DEFAULT_DATE_ERROR);
        return date.isLeapYear();
    }

    /**
     * javadoc isLeapYear
     * @apiNote 判断今年是否是闰年
     *
     * @return boolean
     * @author weng xiaoyong
     * @date 2019-07-26 17:49
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static boolean isLeapYear() {
        return LocalDate.now().isLeapYear();
    }

    /**
     * javadoc tidyDateTime
     * @apiNote 2019-12-11 13:30:58 -> 2019-12-11 13:00:00
     *
     * @param dateTime requires not null, otherwise runtime exception throws
     * @return java.time.LocalDateTime
     * @author weng xiaoyong
     * @date 2019-07-26 17:54
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDateTime tidyDateTime(LocalDateTime dateTime) {
        checkNotNull(dateTime, Property.DEFAULT_DATE_TIME_ERROR);
        return LocalDateTime.of(dateTime.toLocalDate(), LocalTime.of(dateTime.getHour(), 0, 0));
    }

    /**
     * javadoc tidyDateTime
     * @apiNote now() -> now with 0 minute 0 second
     *
     * @return java.time.LocalDateTime
     * @author weng xiaoyong
     * @date 2019-07-26 17:57
     * @modified none
     */
    @SuppressWarnings(value = "unused")
    public static LocalDateTime tidyDateTime() {
        return tidyDateTime(LocalDateTime.now());
    }

    /**
     * javadoc getMinute
     * @apiNote 10:09:11  ->  11:10:12  格式化为  相差 xx时:xx分:xx秒
     *
     * @param start 开始时间
     * @param end 结束时间
     * @return java.lang.String
     * @author wang chenkai
     * @date 2020/3/14  3:54 下午
     * @modified none
     */
    public static String getMinute(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long hour = duration.getSeconds() / ChronoUnit.HOURS.getDuration().getSeconds();
        long minute = (duration.getSeconds() - ChronoUnit.HOURS.getDuration().getSeconds() * hour) / ChronoUnit.MINUTES.getDuration().getSeconds();
        long second = (duration.getSeconds() - ChronoUnit.HOURS.getDuration().getSeconds() * hour) - minute * ChronoUnit.MINUTES.getDuration().getSeconds();
        return String.format("%s:%s:%s:", unitFormat(hour), unitFormat(minute), unitFormat(second));
    }

    /**
     * 计算时间差 XX天XX时XX分
     * javadoc betweenDays
     *
     * @param start
     * @param end
     * @return java.lang.String
     * @author yachun liu
     * @date 2020/3/16 15:26
     * @modified none
     */
    public static String betweenDays(LocalDateTime start, LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long days = duration.getSeconds() / ChronoUnit.DAYS.getDuration().getSeconds();
        long hours = (duration.getSeconds() - ChronoUnit.DAYS.getDuration().getSeconds() * days) / ChronoUnit.HOURS.getDuration().getSeconds();
        long minutes = (duration.getSeconds() - ChronoUnit.HOURS.getDuration().getSeconds() * hours - ChronoUnit.DAYS.getDuration().getSeconds() * days) / ChronoUnit.MINUTES.getDuration().getSeconds();
        return String.format("%s天%s时%s分:", unitFormat(days), unitFormat(hours), unitFormat(minutes));
    }


    /**
     * javadoc secondToTime
     * @apiNote 总秒数 格式化为  相差 xx时:xx分:xx秒
     *
     * @param second
     * @return java.lang.String
     * @author wang chenkai
     * @date 2020/3/14  4:20 下午
     * @modified none
     */
    public static String secondToTime(long second) {
        long days = second / 86400;
        second = second % 86400;
        long hours = second / 3600;
        second = second % 3600;
        long minutes = second / 60;
        second = second % 60;
        if (days > 0) {
            return String.format("%s:%s:%s:%s", unitFormat(days), unitFormat(hours), unitFormat(minutes), unitFormat(second));
        } else {
            return String.format("%s:%s:%s", unitFormat(hours), unitFormat(minutes), unitFormat(second));
        }
    }

    /**
     * javadoc unitFormat
     * @apiNote 格式化  1 -> 01
     *
     * @param i 时间单位<>天，时，分，秒</>
     * @return java.lang.String
     * @author wang chenkai
     * @date 2020/3/14  4:19 下午
     * @modified none
     */
    private static String unitFormat(long i) {
        int max = 10;
        if (i >= 0 && i < max) {
            return String.format("0%s", i);
        } else {
            return String.valueOf(i);
        }
    }

    public static Date utcToLocal(String utcTime) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T' HH:mm:ss'Z'");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date utcDate = null;
        try {
            utcDate = sdf.parse(utcTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        sdf.setTimeZone(TimeZone.getDefault());
        Date locatlDate = null;
        String localTime = sdf.format(utcDate.getTime());
        try {
            locatlDate = sdf.parse(localTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return locatlDate;
    }

//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//
//        System.out.println(TimeUtils.toDateTime("2017-12-08T09:26:17Z"));;
////        System.out.println(TimeUtils.toDateTime(sdf.parse("2017-12-08T09:26:17Z").getTime(), ));;
////        System.out.println(utcToLocal("2017-12-08T09:26:17Z"));;
//    }

    public static void main(String args[]) throws ParseException {

        //UTCToCST("2017-11-27T03:16:03.944Z", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        LocalDateTime data = strToDateTime("2020-03-26 11:12:13");
        System.out.println(data);

        String date = dateTimeToStr(data);
        System.out.println(date);

        System.out.println(TimeZone.getDefault());
    }

    public static LocalDateTime UTCToDateTime(String UTCStr) throws ParseException {
        Date date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        date = sdf.parse(UTCStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
//        calendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 8);
        //calendar.getTime() 返回的是Date类型，也可以使用calendar.getTimeInMillis()获取时间戳
//        System.out.println("北京时间: " + TimeUtils.toDateTime(calendar.getTimeInMillis()));
        return TimeUtils.toDateTime(calendar.getTimeInMillis());
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     *
     * @param dateDate
     * @return
     */
    public static String dateToStr(Date dateDate, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        String dateString = formatter.format(dateDate);
        return dateString;
    }


//    public static void main(String[] args) {
//        LocalDateTime now = LocalDateTime.now();
//        LocalDateTime end = LocalDateTime.now().plusDays(1).plusHours(1).plusMinutes(10).plusSeconds(5);
//        Duration duration = Duration.between(now, end);
//
//        long seconds = duration.getSeconds();
//
//        System.out.println("差多少秒：" +seconds);
//        String s = secondToTime(seconds);
//        System.out.println("结果：" +s);
//    }


}
