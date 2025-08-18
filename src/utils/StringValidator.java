package utils;

public class StringValidator {
    
    // 빈 문자열 검증
    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw ValidationException.invalidInput(fieldName, "비어있을 수 없습니다.");
        }
    }

    // 최대 길이 검증
    public static void validateMaxLength(String value, String fieldName, int maxLength) {
        if (value == null) {
            throw ValidationException.invalidInput(fieldName, "null일 수 없습니다.");
        }
        
        if (value.trim().length() > maxLength) {
            throw ValidationException.invalidInput(fieldName, "최대 " + maxLength + "자 이하여야 합니다.");
        }
    }

}
