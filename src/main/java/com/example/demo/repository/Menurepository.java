package com.example.demo.repository;

import com.example.demo.model.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Menurepository extends JpaRepository <Menu, String> {  //<테이블명,기본키의 자료형>
}
