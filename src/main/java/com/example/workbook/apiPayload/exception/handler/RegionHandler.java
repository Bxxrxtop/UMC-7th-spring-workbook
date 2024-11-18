package com.example.workbook.apiPayload.exception.handler;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode code) {
        super(code);
    }
}
