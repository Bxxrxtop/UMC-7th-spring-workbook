package com.example.workbook.service.UserService;

import com.example.workbook.domain.common.User;
import com.example.workbook.web.dto.user.UserRequestDTO;

public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDto request);
}
