package com.example.shortenurlapp.member.repository;

import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface MemberMapper {
  ArrayList<HashMap<String, Object>> findAll();

}
