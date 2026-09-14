package com.example.demo.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DateTimeTools {

	// 1. 현재 시간을 구해오는 도구(tool) 설정
	@Tool(description = "현재 날짜와 시간 정보를 제공합니다.")
	public String getCurrentDateTime() {
		String nowTime = LocalDateTime.now() // 현재 시간을 구함
				.atZone(LocaleContextHolder.getTimeZone().toZoneId()) // 현재 시간대 적용
				.toString();
		System.out.println("현재 시간:" + nowTime);
		return nowTime;
	}

	// 2. 알람을 설정하는 도구(tool) 설정
	@Tool(description = "지정된 시간에 알람을 설정합니다.")
	public void setAlarm(@ToolParam(description = "ISO-8601 형식의 시간", required = true) // ISO-8601 형식의 시간
	String time) {

		/*
		 * LLM은 다음과 같은 값을 제공할 수 있다. 2026-07-03T24:12:29+09:00 하지만 이 값은 유효하지 않은 ISO-8601
		 * 날짜/시간 포맷이다. 시간의 유효 범위를 0 ~ 23 으로 제한하기 때문에 24:12:29 는 파싱 불가능하다. 따라서 24:… 를
		 * 00:… 로 변환하면서 날짜를 다음 날로 증가시켜야한다.
		 */

		// "T24:" 패턴 처리 : 24:00 ~ 24:59 범위의 시간은 다음 날 00:00 ~ 00:59 범위로 변환
		if (time.contains("T24:")) { // "T24:" 패턴이 포함되어 있는 경우
			int tIndex = time.indexOf("T"); // "T"의 인덱스 위치를 찾음
			String datePart = time.substring(0, tIndex); // 날짜 부분 추출
			String timePart = time.substring(tIndex + 1);// 시간 부분 추출

			// 날짜 +1
			LocalDate date = LocalDate.parse(datePart);// 날짜 문자열을 LocalDate로 변환
			date = date.plusDays(1); // 날짜를 하루 증가

			// "24:" → "00:"으로 교체
			timePart = timePart.replaceFirst("24:", "00:"); // 시간 부분에서 "24:"를 "00:"으로 교체
			// 재조합
			time = date + "T" + timePart; // 날짜와 시간 부분을다시조합
		}
		// 파싱 시도
		LocalDateTime alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
		System.out.println("알람 설정 시간: " + alarmTime);

	}
}
