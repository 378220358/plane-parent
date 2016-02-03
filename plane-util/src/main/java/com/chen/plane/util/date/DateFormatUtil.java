package com.chen.plane.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DateFormatUtil
 *
 * @author 李威 (liwei@66xf.com)
 * @version 1.0 2015/06/01 20:23
 */
public class DateFormatUtil {

	public static final String ISO_DATE_FORMAT = "yyyy-MM-dd";
	public static final String ISO_TIME_FORMAT = "HH:mm:ss";
	public static final String ISO_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String FULL_DATE_TIME_FORMAT_WITH_NO_SYMBOL = "yyyyMMddHHmmss";

	public static String formatISODateTime(Date date) {
		if (date == null) {
			return null;
		}
		return new SimpleDateFormat(ISO_DATE_FORMAT + " " + ISO_TIME_FORMAT).format(date);
	}

    public static String formatFullDateTimeWithNoSymbol(Date date) {
        if (date == null) {
            return null;
        }
        return new SimpleDateFormat(FULL_DATE_TIME_FORMAT_WITH_NO_SYMBOL).format(date);
    }

}
