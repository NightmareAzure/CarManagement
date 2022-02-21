package com.cm.util;

import java.sql.Date;
import java.util.Calendar;

public class DateHelper {
		public static Calendar getCalendar(String time) 
	    { 
	        if (null == time) 
	        { 
	            return null; 
	        } 
	        String[] times = time.split("-"); 
	        Calendar calendar = Calendar.getInstance(); 
	        calendar.set(Integer.valueOf(times[0]), Integer.valueOf(times[1]), Integer.valueOf(times[2])); 
	        return calendar; 
	    } 
	    
	public static long DayCount(String startTime,String endtime){ 
	      Calendar c1 = getCalendar(startTime); 
	      Calendar c2 = getCalendar(endtime); 
	      return (c2.getTimeInMillis() - c1.getTimeInMillis())/(1000*60*60*24); 
	}
	public static Date newDay(String startTime){ 
	      Calendar c = getCalendar(startTime); 
	      Date rs=new Date(c.getTimeInMillis()+48*24*60*60*1000);
	      return rs; 
	}
}
