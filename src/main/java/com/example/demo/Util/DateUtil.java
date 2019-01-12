package com.example.demo.Util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateUtil {
		public static SimpleDateFormat sdFormat;
	    private static final int SECONDS_PER_MINUTE = 60;
	    private static final int MINUTES_PER_HOUR = 60;
	    private static final int HOURS_PER_DAY = 24;
	    private static final int SECONDS_PER_DAY = (HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE);
	    private static final long DAY_MILLISECONDS = SECONDS_PER_DAY * 1000L;

	    public static String StringtoDate(String date, String format) {
	    	    sdFormat = new SimpleDateFormat(format);
				return sdFormat.format(date);
	    	
	    }
	    public static String DoubletoDate(double numberString, String format) {
	    	    sdFormat = new SimpleDateFormat(format);
	         int wholeDays = (int)Math.floor(numberString);
	         int millisecondsInday = (int)((numberString - wholeDays) * DAY_MILLISECONDS + 0.5);
	         Calendar calendar = new GregorianCalendar();
	         setCalendar(calendar, wholeDays, millisecondsInday, false);
	         return sdFormat.format(calendar.getTime());
	  
	     }
	  
	    private static void setCalendar(Calendar calendar, int wholeDays,
	             int millisecondsInDay, boolean use1904windowing) {
	    	 int startYear = 1900;
	    	 int dayAdjust = -1; // Excel thinks 2/29/1900 is a valid date, which it isn't
	    	 if (use1904windowing) {
	    		 startYear = 1904;
	    		 dayAdjust = 1; // 1904 date windowing uses 1/2/1904 as the first day
	    	 }
	    	 else if (wholeDays < 61) {
	    		 // Date is prior to 3/1/1900, so adjust because Excel thinks 2/29/1900 exists
	    		 // If Excel date == 2/29/1900, will become 3/1/1900 in Java representation
	    		 dayAdjust = 0;
	    	 }
	    	 calendar.set(startYear,0, wholeDays + dayAdjust, 0, 0, 0);
	    	 calendar.set(GregorianCalendar.MILLISECOND, millisecondsInDay);
	     }
}
