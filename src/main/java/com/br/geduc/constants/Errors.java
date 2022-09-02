package com.br.geduc.constants;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class Errors {

    public static final String USER_ALREADY_EXIST = "User already exists";
    public static final String USER_NOT_EXIST = "User not exists";
    public static final String INVALID_PASSWORD = "Wrong password";
    public static final String EMAIL_ALREADY_USE = "Email already use";
    public static final String REGISTRATION_IS_REQUIRED = "Registration is required";
    public static final String NAME_IS_REQUIRED = "Name is required";
    public static final String EMAIL_IS_REQUIRED = "Email is required";
    public static final String PASSWORD_IS_REQUIRED = "Password is required";
    public static final String TITLE_IS_REQUIRED = "Title is required";
    public static final String DESCRIPTION_IS_REQUIRED = "Description is required";
    public static final String START_IS_REQUIRED = "Start time is required";
    public static final String END_IS_REQUIRED = "End time is required";
    public static final String EVENT_NUMER_IS_NON_REQUIRED = "Event number must be null";
    public static final String EVENT_STATUS_IS_NON_REQUIRED = "Event status must be null";
}
