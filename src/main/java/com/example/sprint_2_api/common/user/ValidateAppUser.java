package com.example.sprint_2_api.common.user;

import org.springframework.validation.Errors;


public class ValidateAppUser {

    private ValidateAppUser() {
        throw new IllegalStateException("Utility class");
    }
    private static final String NAME_NOT_EMPTY = "Không để trống tài khoản";
    private static final String CHAR_LENGTH_LESS_THREE = "Số lượng ký tự phải lớn hơn hoặc bằng 3";
    private static final String CHAR_LENGTH_GREATER_FIFTY = "Số lượng ký tự bé hơn hoặc bằng 50";
    private static final String USER_NAME = "userName";
    private static final String PASSWORD = "password";

    public static void checkValidateAppUserName(String name, Errors errors) {
        if (name == null || name.trim().length() == 0) {
            errors.rejectValue(USER_NAME, "", NAME_NOT_EMPTY);
        } else if (name.length() > 50) {
            errors.rejectValue(USER_NAME, "", CHAR_LENGTH_GREATER_FIFTY);
        } else if (name.length() < 3) {
            errors.rejectValue(USER_NAME, "", CHAR_LENGTH_LESS_THREE);
        }
    }

    public static void checkValidateAppUserPassword(String password, Errors errors) {
        if (password == null || password.trim().length() == 0) {
            errors.rejectValue(PASSWORD, "", NAME_NOT_EMPTY);
        } else if (password.length() > 50) {
            errors.rejectValue(PASSWORD, "", CHAR_LENGTH_GREATER_FIFTY);
        } else if (password.length() < 3) {
            errors.rejectValue(PASSWORD, "", CHAR_LENGTH_LESS_THREE);
        }
    }
}