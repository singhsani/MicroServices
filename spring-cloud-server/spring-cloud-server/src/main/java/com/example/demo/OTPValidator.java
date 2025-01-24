package com.example.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OTPValidator {

    public boolean isOtpValid(LocalDateTime otpCreatedOn, int otpHours, int currentHours) {
        // Check if OTP hours are the same as current hours
        if (otpHours - currentHours == 0) {
            // Calculate the duration between the current time and OTP creation time
            Duration duration = Duration.between(otpCreatedOn, LocalDateTime.now());

            // Get the minutes difference from the duration
            long minutesDifference = duration.toMinutes();

            // Check if the difference in minutes is between 0 and 2 (inclusive)
            if (minutesDifference >= 0 && minutesDifference <= 2) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Test the OTP validation logic
        OTPValidator validator = new OTPValidator();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime otpCreatedOn = LocalDateTime.parse("2025-01-13 15:38:21.665",formatter); // OTP created 1 minute ago

        boolean isValid = validator.isOtpValid(otpCreatedOn, otpCreatedOn.getHour(), LocalDateTime.now().getHour());
        System.out.println("Is OTP valid: " + isValid);
    }
}
