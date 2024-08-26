package com.example.shortenurlapp.member;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.shortenurlapp.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MemberServiceTest {
  @Autowired
  private MemberService memberService;
  @Test
  @DisplayName("db")
  void findall(){
    int i = memberService.findAll().size();
    assertEquals(i, 1);
  }

}
