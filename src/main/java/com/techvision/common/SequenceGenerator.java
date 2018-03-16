package com.techvision.common;

import java.util.Calendar;

public class SequenceGenerator {
	public static void main(String[] args) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, 0);
		cal.set(Calendar.YEAR, 2016);
		System.out.println(cal.getActualMaximum(Calendar.DAY_OF_MONTH)); // 28
	}
}