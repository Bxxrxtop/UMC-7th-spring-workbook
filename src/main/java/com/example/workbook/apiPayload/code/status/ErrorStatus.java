package com.example.workbook.apiPayload.code.status;

import com.example.workbook.apiPayload.code.BaseErrorCode;
import com.example.workbook.apiPayload.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,
            "COMMON500",
            "서버 에러."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,
            "COMMON400",
            "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,
            "COMMON401",
            "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN,
            "COMMON403",
            "금지된 요청입니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST, "TEMP4001", "이거는 테스트");


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;


    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }


    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}

