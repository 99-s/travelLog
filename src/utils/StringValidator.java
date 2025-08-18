package utils;

public class StringValidator {
    
    // 빈 문자열 검증
    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw ValidationException.invalidInput(fieldName, "비어있을 수 없습니다.");
        }
    }
    
    // 문자열 길이 검증
    public static void validateLength(String value, String fieldName, int minLength, int maxLength) {
        if (value == null) {
            throw ValidationException.invalidInput(fieldName, "null일 수 없습니다.");
        }
        
        int length = value.trim().length();
        if (length < minLength || length > maxLength) {
            throw ValidationException.outOfRange(fieldName, String.valueOf(minLength), String.valueOf(maxLength) + "자");
        }
    }
    
    // 최소 길이 검증
    public static void validateMinLength(String value, String fieldName, int minLength) {
        if (value == null) {
            throw ValidationException.invalidInput(fieldName, "null일 수 없습니다.");
        }
        
        if (value.trim().length() < minLength) {
            throw ValidationException.invalidInput(fieldName, "최소 " + minLength + "자 이상이어야 합니다.");
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
    
    // 숫자만 포함된 문자열 검증
    public static void validateNumeric(String value, String fieldName) {
        if (value == null || !value.trim().matches("^\\d+$")) {
            throw ValidationException.invalidInput(fieldName, "숫자만 입력해야 합니다.");
        }
    }
    
    // 알파벳과 숫자만 포함된 문자열 검증
    public static void validateAlphanumeric(String value, String fieldName) {
        if (value == null || !value.trim().matches("^[a-zA-Z0-9]+$")) {
            throw ValidationException.invalidInput(fieldName, "영문자와 숫자만 입력해야 합니다.");
        }
    }
    
    // 특수문자 포함 여부 검증
    public static void validateNoSpecialChars(String value, String fieldName) {
        if (value == null || value.trim().matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw ValidationException.invalidInput(fieldName, "특수문자를 포함할 수 없습니다.");
        }
    }
    
    // 이메일 형식 검증
    public static void validateEmail(String email) {
        if (email == null || !email.trim().matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            throw ValidationException.invalidFormat("이메일", "user@example.com");
        }
    }
    
    // 전화번호 형식 검증 (한국)
    public static void validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.trim().matches("^01[0-9]-?[0-9]{3,4}-?[0-9]{4}$")) {
            throw ValidationException.invalidFormat("전화번호", "010-1234-5678");
        }
    }
    
    // ID 형식 검증 (영문자로 시작, 영문자+숫자 조합, 4~20자)
    public static void validateId(String id) {
        if (id == null || !id.trim().matches("^[a-zA-Z][a-zA-Z0-9]{3,19}$")) {
            throw ValidationException.invalidInput("ID", "영문자로 시작하고, 영문자와 숫자 조합으로 4~20자여야 합니다.");
        }
    }
}
