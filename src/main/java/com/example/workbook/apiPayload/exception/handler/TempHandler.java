package com.example.workbook.apiPayload.exception.handler;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
