package com.venkatyarlagadda.jwt.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 
 * @author Venkat Yarlagadda
 * @version V1
 *
 */
public class DateUtils {
	
	final static DateTimeFormatter YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	private static LocalDateTime toZone(final LocalDateTime time, final ZoneId fromZone, final ZoneId toZone) {
		final ZonedDateTime zonedtime = time.atZone(fromZone);
		final ZonedDateTime converted = zonedtime.withZoneSameInstant(toZone);
		return converted.toLocalDateTime();
	}
	
	public static LocalDateTime getCurrentUTCTime() {
		return toUtc(LocalDateTime.now());
	}

	public static LocalDateTime toZone(final LocalDateTime localDateTime, final ZoneId toZone) {
		return toZone(localDateTime, ZoneId.systemDefault(), toZone);
	}

	public static LocalDateTime toUtc(final LocalDateTime localDateTime, final ZoneId fromZone) {
		return toZone(localDateTime, fromZone, ZoneOffset.UTC);
	}

	public static LocalDateTime toLocalZone(final LocalDateTime localDateTime) {
		return toZone(localDateTime, ZoneOffset.UTC, ZoneId.systemDefault());
	}

	public static LocalDateTime toUtc(final LocalDateTime localDateTime) {
		return toUtc(localDateTime, ZoneId.systemDefault());
	}

	public static Date convertLocalDateTimeToDate(final LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date convertLocalDateTimeToUtcDate(final LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneOffset.UTC).toInstant());
	}
	
	public static LocalDateTime convertStringToLocalDateTime(final String stringDate) {
		return LocalDateTime.parse(stringDate, YYYY_MM_DD_HH_MM);
	}
}