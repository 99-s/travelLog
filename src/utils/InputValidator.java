package utils;

public class InputValidator {
    
    // 메뉴 번호 검증
    public static boolean isValidMenu(int menu) {
        return menu >= 1 && menu <= 5;
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
}
