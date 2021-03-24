package com.yago.softfocus.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarioUtil {

	public static Date createNewDate() {
		Date date = new Date();
		Calendar dateCal = Calendar.getInstance();
		dateCal.setTime(date);
		dateCal.set(Calendar.SECOND, 0);
		dateCal.set(Calendar.MILLISECOND, 0);
		return dateCal.getTime();
	}
}
