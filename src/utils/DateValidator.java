package utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateValidator {
    
    // 년도 검증 (1900~2100)
    public static void validateYear(String year) {
        int y = parseInt(year, "년도");
        if (y < 1900 || y > 2100) {
            throw ValidationException.outOfRange("년도", "1900", "2100");
        }
    }

    // 월 검증 (1~12)
    public static void validateMonth(String month) {
        int m = parseInt(month, "월");
        if (m < 1 || m > 12) {
            throw ValidationException.outOfRange("월", "1", "12");
        }
    }

    // 일 검증 (해당 월의 유효한 일자)
    public static void validateDay(String year, String month, String day) {
        int y = parseInt(year, "년도");
        int m = parseInt(month, "월");
        int d = parseInt(day, "일");

        if (d < 1 || d > getDaysInMonth(y, m)) {
            throw ValidationException.invalidInput("일", "해당 월의 일자 범위를 벗어났습니다.");
        }
    }

    // 시간 검증 (0~23)
    public static void validateHour(String hour) {
        int h = parseInt(hour, "시간");
        if (h < 0 || h > 23) {
            throw ValidationException.outOfRange("시간", "0", "23");
        }
    }

    // 분 검증 (0~59)
    public static void validateMinute(String minute) {
        int min = parseInt(minute, "분");
        if (min < 0 || min > 59) {
            throw ValidationException.outOfRange("분", "0", "59");
        }
    }

    // 시작일이 종료일보다 이전인지 검증 (선택적)
    public static void validateDateRange(String startDate, String endDate, boolean strict) {
        if (!strict) return; // strict가 false면 검증하지 않음
        
        LocalDate start = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate end = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        if (start.isAfter(end)) {
            throw ValidationException.invalidInput("여행 기간", "시작일(" + startDate + ")은 종료일(" + endDate + ")보다 이전이어야 합니다.");
        }
    }

    // 시작시간이 종료시간보다 이전인지 검증 (선택적)
    public static void validateTimeRange(String startTime, String endTime, boolean strict) {
        if (!strict) return; // strict가 false면 검증하지 않음
        
        LocalDateTime start = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime end = LocalDateTime.parse(endTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        
        if (start.isAfter(end)) {
            throw ValidationException.invalidInput("시간 범위", "시작시간(" + startTime + ")은 종료시간(" + endTime + ")보다 이전이어야 합니다.");
        }
    }

    // 해당 월의 일수 반환
    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    // 윤년 판별
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // 문자열을 정수로 변환
    private static int parseInt(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw ValidationException.invalidInput(fieldName, "숫자로 입력해야 합니다.");
        }
    }
}
