package utils;

public class InputValidator {
    
    // 메뉴 번호 검증
    public static boolean isValidMenu(int menu) {
        return menu >= 1 && menu <= 5;
    }
}
