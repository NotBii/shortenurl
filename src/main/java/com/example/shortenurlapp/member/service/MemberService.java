package com.example.shortenurlapp.member.service;

import com.example.shortenurlapp.member.dto.SignUpRequestDto;
import com.example.shortenurlapp.member.repository.MemberMapper;
import java.util.ArrayList;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
  @Autowired
  MemberMapper memberMapper;
  public String signUp(SignUpRequestDto request) {
    return null;
  }
  public ArrayList<HashMap<String, Object>> findAll() {
    return memberMapper.findAll();
  }

}
