package AccommodationInfo;
import utils.DateValidator;

import java.util.Scanner;

public class AccommodationInfoView {
    private static final String EXIT_CMD = "/quit";

    public AccommodationItinerary inputAccommodationInfo(String tripId) {
        Scanner scan = new Scanner(System.in);
        String check_in="";
        String check_out="";

        System.out.println("@@@ 숙소 정보 기록 @@@");
        System.out.println("※ 체크인 시간은 체크아웃 시간보다 이전이어야 합니다.");

        String accommodation = inputAccommodationName(scan);
        if (accommodation == null) return null;

        check_in = inputDateTime(scan, "체크인");
        if (check_in == null) return null;

        check_out = inputDateTime(scan, "체크아웃");
        if (check_out == null) return null;

        // 체크인과 체크아웃 시간 순서 검증
        try {
            DateValidator.validateTimeRange(check_in, check_out, true);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
            System.out.println("체크인과 체크아웃 시간을 다시 입력해주세요.");
            return inputAccommodationInfo(tripId); // 재귀 호출로 다시 입력받기
        }

        System.out.println("입력된 숙소 정보:");
        System.out.println("숙소명: " + accommodation);
        System.out.println("체크인: " + check_in);
        System.out.println("체크아웃: " + check_out);

        return new AccommodationItinerary(tripId, accommodation, check_in, check_out);
    }

    private String inputAccommodationName(Scanner scan) {
        while (true) {
            try {
                System.out.print("숙소명 : ");
                String name = scan.nextLine();
                if (name.equalsIgnoreCase(EXIT_CMD)) return null;
                
                if (name.trim().isEmpty()) {
                    System.out.println("[오류] 숙소명은 비어있을 수 없습니다.");
                    continue;
                }
                return name;
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private String inputDateTime(Scanner scan, String label) {
        while (true) {
            try {
                System.out.println(label + " 시간을 입력하세요");
                
                int year = inputYear(scan);
                if (year == -1) return null;
                
                int month = inputMonth(scan);
                if (month == -1) return null;
                
                int day = inputDay(scan, year, month);
                if (day == -1) return null;
                
                int hour = inputHour(scan);
                if (hour == -1) return null;
                
                int minute = inputMinute(scan);
                if (minute == -1) return null;

                return buildTime(year, month, day, hour, minute);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
                System.out.println("다시 입력해주세요.");
            }
        }
    }

    private int inputYear(Scanner scan) {
        while (true) {
            try {
                System.out.print("연도 : ");
                String year = scan.nextLine();
                if (year.equalsIgnoreCase(EXIT_CMD)) return -1;
                DateValidator.validateYear(year);
                return Integer.parseInt(year);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputMonth(Scanner scan) {
        while (true) {
            try {
                System.out.print("월 : ");
                String month = scan.nextLine();
                if (month.equalsIgnoreCase(EXIT_CMD)) return -1;
                DateValidator.validateMonth(month);
                return Integer.parseInt(month);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputDay(Scanner scan, int year, int month) {
        while (true) {
            try {
                System.out.print("일 : ");
                String day = scan.nextLine();
                if (day.equalsIgnoreCase(EXIT_CMD)) return -1;
                DateValidator.validateDay(String.valueOf(year), String.valueOf(month), day);
                return Integer.parseInt(day);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputHour(Scanner scan) {
        while (true) {
            try {
                System.out.print("시 : ");
                String hour = scan.nextLine();
                if (hour.equalsIgnoreCase(EXIT_CMD)) return -1;
                DateValidator.validateHour(hour);
                return Integer.parseInt(hour);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private int inputMinute(Scanner scan) {
        while (true) {
            try {
                System.out.print("분 : ");
                String minute = scan.nextLine();
                if (minute.equalsIgnoreCase(EXIT_CMD)) return -1;
                DateValidator.validateMinute(minute);
                return Integer.parseInt(minute);
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    public String buildTime(String year, String month, String day, String hour, String minute) {
        int y = Integer.parseInt(year);
        int m = Integer.parseInt(month);
        int d = Integer.parseInt(day);
        int h = Integer.parseInt(hour);
        int min = Integer.parseInt(minute);

        return String.format("%04d-%02d-%02d %02d:%02d", y, m, d, h, min);
    }

    private String buildTime(int year, int month, int day, int hour, int minute) {
        return String.format("%04d-%02d-%02d %02d:%02d", year, month, day, hour, minute);
    }
}