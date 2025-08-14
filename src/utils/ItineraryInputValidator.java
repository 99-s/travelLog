package utils;

public class ItineraryInputValidator {

    public void checkYear(String year) {
        int y = parseInt(year, "[ERROR] 년도는 숫자로 입력해야 합니다.");
        if (y < 1900 || y > 2100) {
            throw new IllegalArgumentException("[ERROR] 년도는 1900~2100 사이여야 합니다.");
        }
    }

    public void checkMonth(String month) {
        int m = parseInt(month, "[ERROR] 월은 숫자로 입력해야 합니다.");
        if (m < 1 || m > 12) {
            throw new IllegalArgumentException("[ERROR] 월은 1~12 사이여야 합니다.");
        }
    }

    public void checkDay(String year, String month, String day) {
        int y = parseInt(year, "[ERROR] 년도는 숫자로 입력해야 합니다.");
        int m = parseInt(month, "[ERROR] 월은 숫자로 입력해야 합니다.");
        int d = parseInt(day, "[ERROR] 일은 숫자로 입력해야 합니다.");

        if (d < 1 || d > getDaysInMonth(y, m)) {
            throw new IllegalArgumentException("[ERROR] 해당 월의 일자 범위를 벗어났습니다.");
        }
    }

    public void checkHour(String hour) {
        int h = parseInt(hour, "[ERROR] 시간은 숫자로 입력해야 합니다.");
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("[ERROR] 시간은 0~23 사이여야 합니다.");
        }
    }

    public void checkMinute(String minute) {
        int min = parseInt(minute, "[ERROR] 분은 숫자로 입력해야 합니다.");
        if (min < 0 || min > 59) {
            throw new IllegalArgumentException("[ERROR] 분은 0~59 사이여야 합니다.");
        }
    }

    private int getDaysInMonth(int year, int month) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4: case 6: case 9: case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    private int parseInt(String value, String errorMessage) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
