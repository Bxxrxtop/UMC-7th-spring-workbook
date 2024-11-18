package com.example.workbook.apiPayload.exception.handler;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode code) {
        super(code);
    }
}
