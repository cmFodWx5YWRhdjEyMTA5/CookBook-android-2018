/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/01/30
 * ******************************************************************************
 */

package com.dangtin.cookbook.constant;

public interface Constant {

    int FAIL_CONNECT_CODE = -1;
    int JSON_PARSER_CODE = -10;
    int OTHER_CODE = -20;

    String GENERIC_ERROR = "General error, please try again later";
    String SERVER_ERROR = "Fail to connect to server";

    String HOST_SCHEMA = "http://";
    String DOMAIN_NAME = "stg2.passp.asia";
    String HOST = HOST_SCHEMA + DOMAIN_NAME + "/api/";
}
