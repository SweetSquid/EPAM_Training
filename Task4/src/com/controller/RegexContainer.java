package com.controller;


public class RegexContainer {
    static final String NAME_LAT_REGEX = "^[A-Z][a-z]{1,20}$";
    static final String SECOND_NAME_LAT_REGEX = "^[A-Z][a-z]{1,20}$";
    static final String NAME_UKR_REGEX = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    static final String SECOND_NAME_UKR_REGEX = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    static final String PHONE_NUMBER_REGEX = "((\\+)?(38))?0[0-9]{9}";
    static final String EMAIL_REGEX = "[A-Za-z0-9\\.]+(@){1}[a-z]+(\\.){1}[a-z]+";
    static final String LOGIN_REGEX ="[a-zA-Z0-9\\._\\-]{3,}";
}
