package utils;

public class ValidationException extends RuntimeException {
    
    public ValidationException(String fieldName, String reason) {
        super("[VALIDATION ERROR] " + fieldName + ": " + reason);
    }
    
    public static ValidationException invalidInput(String fieldName, String reason) {
        return new ValidationException(fieldName, reason);
    }
    
    public static ValidationException outOfRange(String fieldName, String min, String max) {
        return new ValidationException(fieldName, min + "~" + max + " 범위여야 합니다.");
    }
}
