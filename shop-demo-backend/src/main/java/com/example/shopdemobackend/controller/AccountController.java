package com.example.shopdemobackend.controller;

import com.example.shopdemobackend.config.jwt.JwtService;
import com.example.shopdemobackend.entity.Member;
import com.example.shopdemobackend.entity.enums.Role;
import com.example.shopdemobackend.repository.MemberRepository;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.RequiredArgsConstructor;
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
    public String login(@RequestBody Map<String,String> params) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        params.get("email"),
                        params.get("password")
                )
        );

        Member member = memberRepository.findByEmail(params.get("email")).orElseThrow();
        return jwtService.generateToken(member);
    }

    @PostMapping("/api/account/signup")
    public String signup(){

        Member member = new Member();
        member.setEmail("Tester"+atomicInteger.incrementAndGet()+"@example.com");
        member.setPassword(passwordEncoder.encode("123123"));
        member.setName("User" + atomicInteger.get());
        member.setRole(Collections.singleton(Role.USER));
        memberRepository.save(member);
        return member.getUsername();
    }


}
