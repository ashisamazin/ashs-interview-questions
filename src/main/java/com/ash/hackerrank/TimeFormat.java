package com.ash.hackerrank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TimeFormat {

	public static void main(String[] args) {
		Scanner sc = new Scanner("07:05:45PM");
		String arg = sc.next();
		SimpleDateFormat oldFormat = new SimpleDateFormat("hh:mm:ssa");
		SimpleDateFormat newFormat = new SimpleDateFormat("HH:mm:ss");
		try {
			System.out.println(newFormat.format(oldFormat.parse(arg)));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
