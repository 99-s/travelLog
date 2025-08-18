package MoveInfo;
import utils.DateValidator;

import java.util.Scanner;

public class MoveInfoView {
    private static final String EXIT_CMD = "/quit";

    public MoveItinerary inputMoveInfo(String tripId){
        Scanner scan = new Scanner(System.in);
        String departure_place="";
        String departure_time="";
        String arrival_time="";

        System.out.println("@@@ 이동 정보 기록 @@@");
        System.out.println("※ 출발시간은 도착시간보다 이전이어야 합니다.");

        departure_place = inputDeparturePlace(scan);
        if (departure_place == null) return null;

        String destination = inputDestination(scan);
        if (destination == null) return null;

        departure_time = inputDateTime(scan, "출발");
        if (departure_time == null) return null;

        arrival_time = inputDateTime(scan, "도착");
        if (arrival_time == null) return null;

        // 출발시간과 도착시간 순서 검증
        try {
            DateValidator.validateTimeRange(departure_time, arrival_time, true);
        } catch (Exception e) {
            System.out.println("[오류] " + e.getMessage());
            System.out.println("출발시간과 도착시간을 다시 입력해주세요.");
            return inputMoveInfo(tripId); // 재귀 호출로 다시 입력받기
        }

        System.out.println("입력된 이동 정보:");
        System.out.println("출발지: " + departure_place);
        System.out.println("도착지: " + destination);
        System.out.println("출발시간: " + departure_time);
        System.out.println("도착시간: " + arrival_time);

        return new MoveItinerary(tripId, departure_place, destination, departure_time, arrival_time);
    }

    private String inputDeparturePlace(Scanner scan) {
        while (true) {
            try {
                System.out.print("출발지 : ");
                String place = scan.nextLine();
                if (place.equalsIgnoreCase(EXIT_CMD)) return null;
                
                if (place.trim().isEmpty()) {
                    System.out.println("[오류] 출발지는 비어있을 수 없습니다.");
                    continue;
                }
                return place;
            } catch (Exception e) {
                System.out.println("[오류] " + e.getMessage());
            }
        }
    }

    private String inputDestination(Scanner scan) {
        while (true) {
            try {
                System.out.print("도착지 : ");
                String dest = scan.nextLine();
                if (dest.equalsIgnoreCase(EXIT_CMD)) return null;
                
                if (dest.trim().isEmpty()) {
                    System.out.println("[오류] 도착지는 비어있을 수 없습니다.");
                    continue;
                }
                return dest;
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

