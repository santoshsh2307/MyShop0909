package com.myshop.demo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConversion {

	public static Date StringToDateConversion(String date){
		Date formattedDate = null;
		if(date != null)
		{
			if(!date.equals(""))
			{ 
				if(!date.isEmpty()){
					SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");//Changed for the flexibility of the date entry 
					try {
						formattedDate = formatter.parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return formattedDate;
	}
	public static Date StringToDateConversionUsingHyphen(String date,String dateFormat){
		Date formattedDate = null;
		if(date != null)
		{
			if(!date.equals(""))
			{ 
				if(!date.isEmpty()){
					SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);//Changed for the flexibility of the date entry 
					try {
						formattedDate = formatter.parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return formattedDate;
	}
	public static Date StringToDateConversionDBFields(String date){
		Date formattedDate1 = null;
		if(date != null)
		{
			if(!date.equals(""))
			{ 
				if(!date.isEmpty()){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					try {
						formattedDate1 = formatter.parse(date);
						System.out.println(""+formattedDate1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return formattedDate1;
	}
	public static String DateToStringConversion(Date date){
		String datestr = null;

		if(date != null)
		{

			/* Calendar calendar = Calendar.getInstance(); 

		        calendar.setTime(date);  
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			int month=calendar.get(Calendar.MONTH)+1;

		        System.out.println(calendar.get(Calendar.YEAR));  

			datestr=calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.YEAR);
			 */
			int day=date.getDate();
			int month=date.getMonth()+1;
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(date);
			datestr=day+"-"+month+"-"+year;
		}


		return datestr;
	}
	
	public static String DateToStringSlashConversion(Date date){
		String datestr = null;

		if(date != null)
		{

			/* Calendar calendar = Calendar.getInstance(); 

		        calendar.setTime(date);  
			int day=calendar.get(Calendar.DAY_OF_MONTH);
			int month=calendar.get(Calendar.MONTH)+1;

		        System.out.println(calendar.get(Calendar.YEAR));  

			datestr=calendar.get(Calendar.MONTH)+"/"+calendar.get(Calendar.DAY_OF_MONTH)+"/"+calendar.get(Calendar.YEAR);
			 */
			int day=date.getDate();
			int month=date.getMonth()+1;
			SimpleDateFormat df = new SimpleDateFormat("yyyy");
			String year = df.format(date);
			datestr=day+"/"+month+"/"+year;
		}


		return datestr;
	}
	
	public static Date StringToDateConversionMonth(String date){
		if(date.equals("")){
			date = "12/30/2014";
		}
		Date formattedDate = null;
		if(date != null)
		{
			if(date != "")
			{ 
				if(!date.isEmpty()){
					SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");//Changed for the flexibility of the date entry 
					try {
						formattedDate = formatter.parse(date);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		return formattedDate;
	}
	
	public static String printDatetostring(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date);
	}

	public static String printDatetostringWithFormat(Date date, String dateFormat) {
		if(date != null) {
			SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			return df.format(date);
		}else {
			return null;
		}
	}
	
	public static String printDatetostring2(Date date) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss a");
		return df.format(date); 
		
		
	}
	public static String printDatetostring3(Date date) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		return df.format(date); 
		
		
	}
	public static Date timeFormating(String time)
	{
		 DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		 try {
			Date fromtimeslot = (Date)formatter.parse(time);
			return fromtimeslot;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static String getTimeByTwelveHours(Date date) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("hh:mm a");
		return df.format(date); 
		
		}
	public static String getTimeBy24Hours(Date date) {
		// TODO Auto-generated method stub
		
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
		return df.format(date); 
		
		}
	public static Long AddDurationtoDate(int duration,Date date)
	{
		Long fromtimeinmillisecond=date.getTime();
		Date afterAddingDurationMins=new Date(fromtimeinmillisecond + (duration * 60000));
		Long addintervalTime =afterAddingDurationMins.getTime();
		return addintervalTime;
	}
	
	public static String dateToStringWithNewFormat(Date date) {
		// TODO Auto-generated method stub
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss_a");
		return df.format(date); 
		
		
	}

	public static String dateToCreateFolderStr(Date date) {
		SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyhhmmss");
		return df.format(date);
	}
	public static String dateFormatForExpiry(Date date, String dateFormat) {
		if(date != null) {
			SimpleDateFormat df = new SimpleDateFormat(dateFormat);
			return df.format(date);
		}else {
			return null;
		}
	}
	public static long daysBetween(Date one, Date two) {
        long difference =  (one.getTime()-two.getTime())/86400000;
        return Math.abs(difference);
    }

	public static Date StringToDateConversionDBFieldsWithTime(String date){
		Date formattedDate1 = null;
		if(date != null)
		{
			if(!date.equals(""))
			{ 
				if(!date.isEmpty()){
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					try {
						formattedDate1 = formatter.parse(date);
						System.out.println(""+formattedDate1);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}

		return formattedDate1;
	}

	
}