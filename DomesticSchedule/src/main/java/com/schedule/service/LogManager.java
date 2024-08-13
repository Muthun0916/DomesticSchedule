package com.schedule.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogManager {

	private static final String FILE_PATH = "log.txt";

	public static void print(String message) {
		// 日付と時刻のフォーマット
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String timestamp = LocalDateTime.now().format(dtf);

		// ログメッセージにタイムスタンプを付加
		String logMessage = timestamp + " - " + message;

		System.out.println(logMessage);
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			writer.write(logMessage);
			writer.newLine();
		} catch (IOException e) {
			System.err.println("ログファイルへの書き込みに失敗しました: " + e.getMessage());
		}
	}

}
