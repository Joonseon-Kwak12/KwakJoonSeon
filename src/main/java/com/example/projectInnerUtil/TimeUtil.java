package com.example.projectInnerUtil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {
	
	public static String getNowString() {
		
		LocalDateTime now = LocalDateTime.now();
		
		return now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}

}
