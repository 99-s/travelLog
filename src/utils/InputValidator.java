package utils;

public class InputValidator {
    
    // 메뉴 번호 검증
    public static boolean isValidMenu(int menu) {
        return menu >= 1 && menu <= 5;
    }
    
    // 메뉴 번호 검증 (범위 지정)
    public static boolean isValidMenu(int menu, int min, int max) {
        return menu >= min && menu <= max;
    }
    
    // Y/N 입력 검증
    public static boolean isValidYesNo(String input) {
        if (input == null) return false;
        String upperInput = input.trim().toUpperCase();
        return upperInput.equals("Y") || upperInput.equals("N");
    }
    
    // 여정 타입 검증
    public static boolean isValidItineraryType(String type) {
        if (type == null) return false;
        String upperType = type.trim().toUpperCase();
        return upperType.equals("A") || upperType.equals("M");
    }
    
    // 여행 ID 형식 검증 (영문자+숫자 조합, 3~20자)
    public static boolean isValidTripId(String tripId) {
        if (tripId == null) return false;
        return tripId.trim().matches("^[a-zA-Z0-9]{3,20}$");
    }
    
    // 여정 ID 형식 검증 (UUID 형식)
    public static boolean isValidItineraryId(String itineraryId) {
        if (itineraryId == null) return false;
        return itineraryId.trim().matches("^[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}$");
    }
    
    // 파일명 검증 (특수문자 제외)
    public static boolean isValidFileName(String fileName) {
        if (fileName == null) return false;
        return fileName.trim().matches("^[a-zA-Z0-9가-힣\\s._-]+$");
    }
    
    // 경로 검증 (상대 경로 또는 절대 경로)
    public static boolean isValidPath(String path) {
        if (path == null) return false;
        return path.trim().matches("^[a-zA-Z0-9가-힣\\s._/-\\\\]+$");
    }
    
    // 숫자 입력 검증
    public static boolean isValidNumber(String input) {
        if (input == null) return false;
        try {
            Integer.parseInt(input.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    // 양수 검증
    public static boolean isValidPositiveNumber(String input) {
        if (!isValidNumber(input)) return false;
        int num = Integer.parseInt(input.trim());
        return num > 0;
    }
    
    // 범위 내 숫자 검증
    public static boolean isValidNumberInRange(String input, int min, int max) {
        if (!isValidNumber(input)) return false;
        int num = Integer.parseInt(input.trim());
        return num >= min && num <= max;
    }
}
