package com.example.moduleapp.controller;


import com.example.modulecore.dto.LoginRequest;
import com.example.modulecore.dto.SignupRequest;
import com.example.modulecore.dto.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Tag(name = "유저 인증 API", description = "회원가입 및 로그인 API")
public class UserController {
    @PostMapping("/signup")
    @Operation(summary = "회원가입", description = "새로운 사용자를 등록합니다.")
    public ResponseEntity<UserDto> register(@RequestBody SignupRequest request) {
        // 더미 데이터 반환 (실제 서비스 로직 없이)
        return ResponseEntity.ok(new UserDto(1L, request.getName(), request.getEmail(), request.getPassword()));
    }

    @PostMapping("/login")
    @Operation(summary = "로그인", description = "사용자 로그인을 수행합니다.")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        // 더미 토큰 반환
        return ResponseEntity.ok("Bearer dummy-jwt-token");
    }
}