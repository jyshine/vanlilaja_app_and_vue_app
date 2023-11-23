package com.example.shopdemobackend.controller;

import com.example.shopdemobackend.config.jwt.JwtService;
import com.example.shopdemobackend.entity.Member;
import com.example.shopdemobackend.repository.MemberRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;

    @PostMapping("/api/account/login")
    public String login(@RequestBody Map<String,String> params) {
        System.out.println(params);
//        Member email = memberRepository.findByEmail(params.get("email"));
        return jwtService.generateToken(params.get("email"));
    }

}
