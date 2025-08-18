package utils;

import java.util.Scanner;

public class ItineraryInputHelper {
    private static final String EXIT_CMD = "/quit";
    private final Scanner scan = new Scanner(System.in);

    public String inputDateTime(String label) {
        while (true) {
            try {
                System.out.println(label + " 시간을 입력하세요");

                System.out.print("연도 : ");
                String year = scan.nextLine();
                if (year.equalsIgnoreCase(EXIT_CMD)) return null;
                DateValidator.validateYear(year);

                System.out.print("월 : ");
                String month = scan.nextLine();
                if (month.equalsIgnoreCase(EXIT_CMD)) return null;
                DateValidator.validateMonth(month);

                System.out.print("일 : ");
                String day = scan.nextLine();
                if (day.equalsIgnoreCase(EXIT_CMD)) return null;
                DateValidator.validateDay(year, month, day);

                System.out.print("시 : ");
                String hour = scan.nextLine();
                if (hour.equalsIgnoreCase(EXIT_CMD)) return null;
                DateValidator.validateHour(hour);

                System.out.print("분 : ");
                String minute = scan.nextLine();
                if (minute.equalsIgnoreCase(EXIT_CMD)) return null;
                DateValidator.validateMinute(minute);

                return buildTime(year, month, day, hour, minute);
            } catch (ValidationException e) {
                System.out.println("[오류] " + e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private String buildTime(String year, String month, String day, String hour, String minute) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int h = Integer.parseInt(hour);
        int min = Integer.parseInt(minute);

        return String.format("%04d-%02d-%02d %02d:%02d", y, m, d, h, min);
    }

    public String inputNonEmptyText(String label) {
        while (true) {
            System.out.print(label + " : ");
            String value = scan.nextLine();
            if (value.equalsIgnoreCase(EXIT_CMD)) return null;
            if (value.trim().isEmpty()) {
                System.out.println("[오류] " + label + "은 비어있을 수 없습니다.");
                continue;
            }
            return value;
        }
    }
}
