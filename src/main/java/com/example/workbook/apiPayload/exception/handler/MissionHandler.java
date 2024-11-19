package com.example.workbook.apiPayload.exception.handler;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.exception.GeneralException;

public class MissionHandler extends GeneralException {
    public MissionHandler(BaseErrorCode code) {
        super(code);
    }
}
