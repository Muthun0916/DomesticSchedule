package com.schedule.service;

import java.time.LocalTime;

public class TimeManager {

	public static String getGreeting() {
		LocalTime time = LocalTime.now();
		String message = "";
		if (time.compareTo(LocalTime.of(0, 0)) >= 0 && time.isBefore(LocalTime.of(4, 0))) {
			message = "夜分遅くまでお疲れ様です";
		} else if (time.compareTo(LocalTime.of(4, 0)) >= 0 && time.isBefore(LocalTime.of(8, 0))) {
			message = "朝早くからおはようございます";
		} else if (time.compareTo(LocalTime.of(8, 0)) >= 0 && time.isBefore(LocalTime.of(12, 0))) {
			message = "おはようございます";
		} else if (time.compareTo(LocalTime.of(12, 0)) >= 0 && time.isBefore(LocalTime.of(16, 0))) {
			message = "こんにちは";
		} else if (time.compareTo(LocalTime.of(16, 0)) >= 0 && time.isBefore(LocalTime.of(20, 0))) {
			message = "こんばんは";
		} else if (time.compareTo(LocalTime.of(20, 0)) >= 0 && time.compareTo(LocalTime.of(23, 59)) <= 0) {
			message = "おかえりなさい";
		}
		return message;
	}

}
