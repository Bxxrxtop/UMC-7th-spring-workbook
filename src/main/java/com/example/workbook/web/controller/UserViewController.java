package com.example.workbook.web.controller;

import com.example.workbook.service.UserService.UserCommandService;
import com.example.workbook.web.dto.user.UserRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserViewController {
    private final UserCommandService userCommandService;

    @PostMapping("/users/signup")
    public String joinUser(@ModelAttribute("userJoinDto") UserRequestDTO.JoinDto request,
                           BindingResult bindingResult,
                           Model model) {
        log.info("넘어옴");
        if (bindingResult.hasErrors()) {
            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
            return "signup";
        }
        log.info("바인딩 성공");
        try {
            userCommandService.joinUser(request);
            log.info("서비스 통과");
            return "redirect:/login";
        } catch (Exception e) {
            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이지를 유지합니다.
            log.info("회원가입 에러 -> {}", e.getMessage());
            model.addAttribute("error", e.getMessage());
            return "signup";
        }
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage(Model model) {
        model.addAttribute("userJoinDto", new UserRequestDTO.JoinDto());
        return "signup";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }
}
