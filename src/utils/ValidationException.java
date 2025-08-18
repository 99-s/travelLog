package utils;

public class ValidationException extends RuntimeException {
    
    public ValidationException(String message) {
        super(message);
    }
    
    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public ValidationException(String fieldName, String reason) {
        super("[VALIDATION ERROR] " + fieldName + ": " + reason);
    }
    
    public ValidationException(String fieldName, String expected, String actual) {
        super("[VALIDATION ERROR] " + fieldName + ": 예상값=" + expected + ", 실제값=" + actual);
    }
    
    public static ValidationException invalidInput(String fieldName, String reason) {
        return new ValidationException(fieldName, reason);
    }
    
    public static ValidationException invalidFormat(String fieldName, String expectedFormat) {
        return new ValidationException(fieldName, "올바른 형식이 아닙니다. (" + expectedFormat + ")");
    }
    
    public static ValidationException outOfRange(String fieldName, String min, String max) {
        return new ValidationException(fieldName, min + "~" + max + " 범위여야 합니다.");
    }
}
