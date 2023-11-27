package com.example.shopdemobackend.controller;

import com.example.shopdemobackend.config.jwt.JwtService;
import com.example.shopdemobackend.entity.Member;
import com.example.shopdemobackend.entity.enums.Role;
import com.example.shopdemobackend.repository.MemberRepository;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final MemberRepository memberRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final AtomicInteger atomicInteger = new AtomicInteger();


    @PostMapping("/api/account/signin")
    public ResponseEntity<String> login(@RequestBody Map<String,String> params, HttpServletResponse response) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        params.get("email"),
                        params.get("password")
                )
        );

        Member member = memberRepository.findByEmail(params.get("email")).orElseThrow();
        String token = jwtService.generateToken(member);
        Cookie cookie = new Cookie("jwt", token);
        cookie.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days
        cookie.setSecure(false);
        cookie.setHttpOnly(false);
        cookie.setPath("/"); // Global
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/api/account/signup")
    public String signup(){

        Member member = new Member();
        member.setEmail("Tester"+atomicInteger.incrementAndGet()+"@example.com");
        member.setPassword(passwordEncoder.encode("123123"));
        member.setName("User" + atomicInteger.get());
        member.setRole(Collections.singleton(Role.USER));
        memberRepository.save(member);
        return member.getEmail();
    }


}
