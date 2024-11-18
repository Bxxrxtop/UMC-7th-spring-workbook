package com.example.workbook.apiPayload.exception.handler;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.exception.GeneralException;

public class RestaurantHandler extends GeneralException {
    public RestaurantHandler(BaseErrorCode code) {
        super(code);
    }
}
