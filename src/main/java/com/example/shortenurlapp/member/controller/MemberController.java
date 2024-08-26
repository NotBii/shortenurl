package com.example.shortenurlapp.member.controller;

import com.example.shortenurlapp.member.dto.SignUpRequestDto;
import com.example.shortenurlapp.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping(value = "/member")
  public ResponseEntity<?> signUp(SignUpRequestDto requestDto) {

    memberService.signUp(requestDto);

    return ResponseEntity.ok(null);
  }

}
