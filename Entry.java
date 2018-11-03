/**
 * Entry.java - Entry objects used in journal (jou.java)
 *
 * Maria Dominguez
 * September 2018
 **/

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Entry {
	
	private String date;
	private String time;
	private String datetime;
	private String title;
	private String song;
	private String entry;

	Entry() {
		Date now = new Date();
		// date ex: Tue, Sep 18, 2018
		SimpleDateFormat d = new SimpleDateFormat("EEE, MMM d, yyyy");
		date = d.format(now);
		
		// time ex: 12:44 AM
		SimpleDateFormat t = new SimpleDateFormat("hh:mm a");
		time = t.format(now);
		
		// date-time ex: 2018-09-18 17-08-12
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		datetime = dt.format(now);
	}
	
	// date ex: Tue, Sep 18, 2018
	public void setDate(String d) {
		date = d;
	}
	
	// time ex: 12:44 AM
	public void setTime(String t) {
		time = t;
	}
	
	// date-time ex: 2018-09-18 17-08-12
	// OR if entered manually, no seconds
	// date-time ex: 2018-09-18 17-08
	public void setDateTime() {
		// parse from date and time
		String month, d, year, hours, mins;
	
		String[] arr = date.split(" "); 
		String[] arr2 = time.split(":"); 
		
		String d_comma = arr[2];
		String[] d_arr = d_comma.split(",");
		d = d_arr[0];
		
		year = arr[3];
		hours = arr2[0];
		
		String mins_a = arr2[1];
		String[] arr3 = mins_a.split(" ");
		mins = arr3[0];
		
		String[] arr4 = time.split(" ");
		
		if ((arr4[1]).equals("PM")) {
			int hours_i = Integer.parseInt(hours);
			// 12 PM is 12
			if (hours_i != 12) {
				hours_i = hours_i+12;
				hours = Integer.toString(hours_i);
			}
		} // 12 AM is 00
		else if ((arr4[1]).equals("AM")) {
			int hours_i = Integer.parseInt(hours);
			if (hours_i == 12) {
				hours_i = 00;
				hours = Integer.toString(hours_i);
			}
		}
		
		if ((arr[1]).equals("Jan")) {
		    month = "1";
		} else if ((arr[1]).equals("Feb")) {
		    month = "2";
		} else if ((arr[1]).equals("Mar")) {
		    month = "3";
		} else if ((arr[1]).equals("Apr")) {
		    month = "4";
		} else if ((arr[1]).equals("May")) {
		    month = "5";
		} else if ((arr[1]).equals("Jun")) {
		    month = "6";
		} else if ((arr[1]).equals("Jul")) {
		    month = "7";
		} else if ((arr[1]).equals("Aug")) {
		    month = "8";
		} else if ((arr[1]).equals("Sep")) {
		    month = "9";
		} else if ((arr[1]).equals("Oct")) {
		    month = "10";
		} else if ((arr[1]).equals("Nov")) {
		    month = "11";
		} else if ((arr[1]).equals("Dec")) {
		    month = "12";
		} else {
			month = "0";
		}
		
		// date-time ex: 2018-09-18 17-08 (no seconds)
		datetime = year + "-" + month + "-" + d + " " + hours + "-" + mins;
	}
	
	public void setTitle(String t) {
		title = t;
	}
	
	public void setSong(String s) {
		song = s;
	}
	
	public void setEntry(String e) {
		entry = e;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public String getDateTime() {
		return datetime;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getSong() {
		return song;
	}
	
	public String getEntry() {
		return entry;
	}
	
	// print date, time, title, song to txt file
	public void writeTxt() {
		try {
			String filename = datetime + ".txt";
			PrintWriter out = new PrintWriter(new FileWriter(filename));    
	        out.println(date);
	        out.println(time);
	        out.println();
	        out.println(title);
	        out.println(song);
	        out.println();
	        out.close();    
	        System.out.println(".txt written"); 
        } catch (Exception ex) {
           JOptionPane.showMessageDialog(null, ".txt writing error.");
        }  
	}
	
	// print writeText() things and entry to txt file
	public void writeTxt2(JTextArea jTextArea) {
		writeTxt();
		
	    Writer writer = null;
        
	    try {
	    	String filename = datetime + ".txt";
	        
	    	// true will append to file
	        writer = new BufferedWriter(new OutputStreamWriter(
	                new FileOutputStream(filename, true), "utf-8"));
	        
	        // print entry from jTextArea
	        jTextArea.write(writer);
	    } catch (IOException e) {
	    } finally {
	        try {
	            writer.close();
	        } catch (Exception e) {
	        }
	    }
	}
}
