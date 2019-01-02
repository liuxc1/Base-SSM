package com.ths.lxc.utils;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtil {

	/**
	 * 将指定的日期按照指定格式转换为字符串
	 * @param d
	 * @param f
	 * @return
	 */
	public static String format( Date d, String f ) {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		return sdf.format(d);
	}
	
	/**
	 * 将字符串转换为Calendar
	 * @param sdate
	 * @param f
	 * @return
	 */
	public static Calendar dateFormat(String sdate,String f) {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Date date = null;
		try {
			date = sdf.parse(sdate);
		} catch (ParseException e) {
			System.out.println("日期转换出错");
			e.printStackTrace();
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}
	
	/**
	 * 获取当前日期的字符串
	 * @return
	 */
	public static String now() {
		return format( new Date(), "yyyy-MM-dd" );
	}
	
	/**
	 * 获取当期时间的字符串
	 * @return
	 */
	public static String nowHMS(){
		return format( new Date(), "yyyy/MM/dd HH:mm:ss" );
	}
	
	/**
	 * 判断字符串是否是日期格式
	 * @param date
	 * @return
	 */
	public static boolean isDate(String date){
		String eL = "[0-9]{4}-[0-9]{2}-[0-9]{2}";
		Pattern p = Pattern.compile(eL);
		Matcher m = p.matcher(date);
		return m.matches();
	}
	
	/**
	 * 获取历史时间
	 * @param f 时间格式
	 * @param base 历史时间基数，以当前时间为基准。+1为明天，-1为昨天。
	 * @return
	 */
	public static String history(String f,int base){
		Format format = new SimpleDateFormat(f);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DAY_OF_MONTH, base);
		return format.format(c.getTime());
	}
	
	/**
	 * 将字符串转换为日期
	 * @param strDate
	 * @param format
	 * @return
	 * @throws ParseException 
	 */
	public static Date stringToDate(String strDate,String f) throws ParseException{
		if(f.indexOf("-")<0&& f.length()>=8){
			f = f.substring(0, 4)+"-"+f.substring(4, 6)+"-"+f.substring(6, 8);
		}
		
		if(strDate.indexOf("-") < 0 && strDate.length() >= 8){
			strDate = strDate.substring(0,4) + "-" + strDate.substring(4,6) + "-" + strDate.substring(6,8);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Date date = sdf.parse(strDate);
		return date;
	}
	
	/**
	 * 格式化日期字符串，返回值也为字符串
	 * @param strdate
	 * @param f
	 * @return
	 * @throws ParseException 
	 */
	public static String formatString(String strdate, String f) throws ParseException{
		Date date = stringToDate(strdate,f);
		return format(date,f);
	}
	
	/**
	 * 日期加减
	 * @param date
	 * @param f
	 * @param base
	 * @return
	 */
	public static Date dateToAddOrSub(Date date,String f,int base){
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DAY_OF_MONTH, base);
	    return c.getTime();
	}
	
	/** 
     * 计算两个日期之间相差的天数 
     * @param date1 
     * @param date2 
     * @return 
     */  
    public static int daysBetween(Date date1,Date date2) {  
        Calendar cal = Calendar.getInstance();  
        cal.setTime(date1);  
        long time1 = cal.getTimeInMillis();               
        cal.setTime(date2);  
        long time2 = cal.getTimeInMillis();       
        long between_days=(time2-time1)/(1000*3600*24);  
        return Integer.parseInt(String.valueOf(between_days));         
    }
    
    /**
     * 判断是否是闰年
     * @param _year
     * @return
     */
    public static int isLeapYear(String _year){
    	int year = Integer.parseInt(_year);
    	return ((year%4==0&&year%100!=0)||year%400==0)?366:365;
    }
}
