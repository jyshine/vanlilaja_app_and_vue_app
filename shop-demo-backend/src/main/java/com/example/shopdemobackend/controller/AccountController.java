package com.example.shopdemobackend.controller;

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

    @PostMapping("/api/account/login")
    public String login(@RequestBody Map<String,String> params) {
        System.out.println(params);
//        Member email = memberRepository.findByEmail(params.get("email"));
        if (true){

        }
        return params.get("email");
    }

}
